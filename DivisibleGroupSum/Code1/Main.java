package UVa.DivisibleGroupSum.Code1;

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
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if (n + q == 0)
            {
                return;
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                a[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("SET " + t + ":");
            for (int qq = 0; qq < q; qq++)
            {
                st = new StringTokenizer(in.readLine());
                int D = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                long[][] dp = new long[m + 1][D];
                for (int i = 0; i < m; i++)
                {
                    Arrays.fill(dp[i], 0);
                }

                dp[0][0] = 1;
                for (int i = 0; i < n; i++)
                {
                    for (int j = m - 1; j >= 0; j--)
                    {
                        for (int k = D - 1; k >= 0; k--)
                        {
                            if (dp[j][k] > 0)
                            {
                                dp[j + 1][(((k + a[i]) % D) + D) % D] += dp[j][k];
                            }
                        }
                    }
                }

                long result = dp[m][0];
                System.out.println("QUERY " + (qq + 1) + ": " + result);
            }

        }

    }
}
