package UVa.MarksDistribution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/06/2017.
 */
public class Main
{
    private final static int INVALID = 0;
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 1][V + 1];
            for (int i = 0; i < n + 1; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }

            dp[0][0] = 1;
            int max = V - (P * (n - 1));
            for (int j = 0; j <= n - 1; j++)
            {
                for (int k = 0; k <= V; k++)
                {
                    if (dp[j][k] != INVALID)
                    {
                        for (int i = P; i <= max; i++)
                        {
                            if (k + i <= V)
                            {
                                dp[j + 1][k + i] += dp[j][k];
                            }
                        }
                    }
                }
            }
            System.out.println(dp[n][V]);
        }

    }
}
