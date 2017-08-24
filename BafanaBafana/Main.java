package UVa.BafanaBafana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 23-Feb-16.
 */
public class Main
{
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++)
        {
            tokens = br.readLine().split(" ");
            int total = Integer.parseInt(tokens[0]) - 1;
            int start = Integer.parseInt(tokens[1]) - 1;
            int n = Integer.parseInt(tokens[2]);
            int result = ((start + n) % (total + 1)) + 1;
            System.out.println("Case " + t + ": " + result);
        }
    }
}
