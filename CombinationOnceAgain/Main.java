package UVa.CombinationOnceAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by DELL on 29-Mar-16.
 */
public class Main
{
    private long b[][] = new long[51][51];
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {

        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                b[i][j] = (j == 0 || i == j) ? 1 : b[i - 1][j] + b[i - 1][j - 1];
            }
        }
        int test = 1;
        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            if (n == 0)
            {
                break;
            }
            tokens = br.readLine().trim().split("[ ]+");
            TreeSet<Integer> queue = new TreeSet<Integer>();
            for (int i = 0; i < n; i++)
            {
                queue.add(Integer.parseInt(tokens[i]));
            }
            int total = queue.size();
            tokens = br.readLine().trim().split("[ ]+");
            System.out.println("Case " + (test++) + ":");
            for (int i = 0; i < tokens.length; i++)
            {
                int choose = Integer.parseInt(tokens[i]);
                int a = Math.max(total, choose);
                int bb = Math.min(total, choose);
                System.out.println(b[a][bb]);
            }
        }
    }
}

