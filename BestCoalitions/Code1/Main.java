package UVa.BestCoalitions.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 05/06/2017.
 */
public class Main
{
    private final static int M = 100000;
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
            int person = Integer.parseInt(st.nextToken());

            if (n + person == 0)
            {
                return;
            }

            int[] values = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                st = new StringTokenizer(in.readLine());
                values[i] = (int) (Double.parseDouble(st.nextToken()) * 1000);
            }

            boolean[][] ok = new boolean[n + 1][M + 1];
            int[][] dp = new int[n + 1][M + 1];
            for (int i = 0; i <= n; i++)
            {
                Arrays.fill(dp[i], -1);
            }
            dp[0][0] = 0;
            ok[0][0] = true;
            for (int i = 0; i <= n - 1; i++)
            {
                for (int j = 0; j < M + 1; j++)
                {
                    if (dp[i][j] != -1)
                    {
                        if (dp[i + 1][j] < dp[i][j])
                        {
                            dp[i + 1][j] = dp[i][j];
                            ok[i + 1][j] = ok[i][j];
                        }
                        if (dp[i + 1][j + values[i + 1]] < dp[i][j] + values[i + 1])
                        {
                            dp[i + 1][j + values[i + 1]] = dp[i][j] + values[i + 1];
                            if (i + 1 == person)
                            {
                                ok[i + 1][j + values[i + 1]] = true;
                            } else
                            {
                                ok[i + 1][j + values[i + 1]] = ok[i][j];
                            }
                        }
                    }
                }
            }
            int best = 0;
            for (int i = 0; i <= M; i++)
            {
                if (dp[n][i] >= best && ok[n][i])
                {
                    best = dp[n][i];
                }
            }
            int last = best % 10;
            best = best / 10;
            if (last >= 5)
            {
                best++;
            }
            String s = best + "";
            s = s.substring(0, s.length() - 2) + "." + s.substring(s.length() - 2);
            System.out.println(s);
        }
    }
}
