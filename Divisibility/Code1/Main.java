package UVa.Divisibility.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 10/06/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken()) % k;
                if (a[i] < 0)
                {
                    a[i] = (a[i] + k) % k;
                }
            }

            boolean[][] dp = new boolean[n + 1][k];
            dp[0][0] = true;
            for (int i = 0; i <= n - 1; i++)
            {
                for (int j = 0; j < k; j++)
                {
                    if (dp[i][j])
                    {
                        dp[i + 1][(j + a[i + 1]) % k] = true;
                        int jj = (j - a[i + 1]) % k;
                        if (jj < 0)
                        {
                            jj = (jj + k) % k;
                        }
                        dp[i + 1][jj] = true;
                    }
                }
            }
            if (dp[n][0])
            {
                System.out.println("Divisible");
            } else
            {
                System.out.println("Not divisible");
            }
        }

    }
}
