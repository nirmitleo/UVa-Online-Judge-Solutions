package UVa.Boxes.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 04/06/2017.
 */
public class Main
{

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
        while (true)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }

            int[] weight = new int[n + 1];
            int[] load = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                st = new StringTokenizer(in.readLine());
                weight[i] = Integer.parseInt(st.nextToken());
                load[i] = Integer.parseInt(st.nextToken());

            }

            int[][] dp = new int[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++)
            {
                Arrays.fill(dp[i], -1);
            }

            dp[0][0] = 0;
            for (int i = 0; i <= n - 1; i++)
            {
                for (int j = 0; j < n + 1; j++)
                {
                    if (dp[i][j] != -1)
                    {
                        dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                        if (j == 0)
                        {
                            dp[i + 1][j + 1] = Math.max(dp[i + 1][j], load[i + 1]);
                        } else
                        {
                            dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], Math.min(dp[i][j] - weight[i + 1], load[i + 1]));
                        }
                    }
                }
            }

            int best = -1;
            for (int i = n; i >= 0; i--)
            {
                if (dp[n][i] >= 0)
                {
                    best = i;
                    break;
                }
            }
            System.out.println(best);
        }


    }
}
