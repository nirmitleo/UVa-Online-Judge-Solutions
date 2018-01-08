package UVa.MakingChange.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/06/2017.
 */
public class Main
{
    private final static int N = 6;
    private final static int MAX = (int) 1e4 + 100;
    private final static int INVALID = (int) 1e9;
    private int[] coins = new int[]{5, 10, 20, 50, 100, 200};

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
        int[] left = new int[N];
        while (true)
        {
            int sum = 0;
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
            {
                left[i] = Integer.parseInt(st.nextToken());
                sum += left[i];
            }
            if (sum == 0)
            {
                return;
            }

            String s = st.nextToken();
            int V = Integer.parseInt(s.substring(0, s.indexOf("."))) * 100;
            V += Integer.parseInt(s.substring(s.indexOf(".") + 1));

            int[] dp = new int[MAX];
            Arrays.fill(dp, INVALID);

            dp[0] = 0;
            for (int i = 0; i < N; i++)
            {
                for (int j = MAX - 1; j >= 0; j--)
                {
                    if (dp[j] != INVALID)
                    {
                        for (int k = 1; k <= left[i]; k++)
                        {
                            if (j + k * coins[i] < MAX)
                            {
                                dp[j + k * coins[i]] = Math.min(dp[j + k * coins[i]], dp[j] + k);
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++)
            {
                for (int j = MAX - 1; j >= coins[i]; j--)
                {
                    if (dp[j] != INVALID)
                    {
                        dp[j - coins[i]] = Math.min(dp[j - coins[i]], dp[j] + 1);
                    }
                }
            }
            String result = String.format("%3d", dp[V]);
            System.out.println(result);
        }
    }
}
