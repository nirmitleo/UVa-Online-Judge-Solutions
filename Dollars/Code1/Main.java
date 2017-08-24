package UVa.Dollars.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/06/2017.
 */
public class Main
{
    private int[] coins = new int[]{0, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
    //private int[] coins = new int[]{0, 1, 5};
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int n = coins.length;
        int MAX = 300 * 100;
        long[][] dp = new long[n][MAX + 100];
        dp[0][0] = 1L;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j <= MAX; j++)
            {
                if (dp[i][j] != 0)
                {
                    for (int k = 0; true; k++)
                    {
                        if (j + k * coins[i + 1] > MAX)
                        {
                            break;
                        }
                        dp[i + 1][j + (k * coins[i + 1])] += dp[i][j];
                    }
                }
            }
        }


        while (true)
        {
            st = new StringTokenizer(in.readLine());
            double d = Double.parseDouble(st.nextToken());
            //System.out.println(d);
            int V = (int) (d * 100 + 0.05);
            //System.out.println(V);
            if (V == 0)
            {
                return;
            }
            long result = dp[n - 1][V];
            String s = String.format("%6.2f%17d", d, result);
            System.out.println(s);
        }

    }
}
