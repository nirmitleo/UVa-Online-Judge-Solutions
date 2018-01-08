package UVa.HowDoYouAdd.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/06/2017.
 */
public class Main
{
    private final static int MOD = (int) 1e6;
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }

    public void test()
    {
        int N = 5;
        int K = 5;
        for (int k = 0; k <= K; k++)
        {
            for (int n = Math.max(k - 3, 1); n <= N; n++)
            {
                System.out.println(n + " " + k);
            }
        }
        System.out.println(0 + " " + 0);
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if (N + K == 0)
            {
                return;
            }

            int[][] dp = new int[K + 1][N + 1];
            dp[0][0] = 1;
            for (int i = 0; i <= K - 1; i++)
            {
                for (int j = 0; j <= N; j++)
                {
                    if (dp[i][j] != 0)
                    {
                        for (int k = 0; k <= N; k++)
                        {
                            if (j + k > N)
                            {
                                break;
                            }
                            dp[i + 1][j + k] = (dp[i + 1][j + k] + dp[i][j]) % MOD;
                        }
                    }
                }
            }
            System.out.println(dp[K][N] % MOD);
        }

    }
}
