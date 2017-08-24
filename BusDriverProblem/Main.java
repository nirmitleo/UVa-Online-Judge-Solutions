package UVa.BusDriverProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by DELL on 21-Mar-16.
 */
public class Main
{
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
        while (true)
        {
            tokens = br.readLine().split("[ ]+");
            int n = Integer.parseInt(tokens[0]);
            int d = Integer.parseInt(tokens[1]);
            int r = Integer.parseInt(tokens[2]);
            if (n == d && d == r && r == 0)
            {
                break;
            }
            int result[] = new int[n];
            int m[] = new int[n];
            tokens = br.readLine().split("[ ]+");
            for (int i = 0; i < tokens.length; i++)
            {
                m[i] = Integer.parseInt(tokens[i]);
            }

            int e[] = new int[n];
            tokens = br.readLine().split("[ ]+");
            for (int i = 0; i < tokens.length; i++)
            {
                e[i] = Integer.parseInt(tokens[i]);
            }

            Arrays.sort(m);
            Arrays.sort(e);
            int sum = 0;
            for (int i = e.length - 1, j = 0; i >= 0; i--, j++)
            {
                m[j] += e[i];
                sum += m[j] - d > 0 ? m[j] - d : 0;
            }
            System.out.println(sum * r);
        }
    }

}
