package UVa.DividingCoins.Code3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/06/2017.
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

            int sum = 0;
            int[] coins = new int[n];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
            {
                coins[i] = Integer.parseInt(st.nextToken());
                sum += coins[i];
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++)
            {
                for (int j = sum; j >= 0; j--)
                {
                    if (dp[j])
                    {
                        if (j + coins[i] <= sum)
                        {
                            dp[j + coins[i]] = true;
                        }
                    }
                }
            }

            int best = sum;
            for (int i = 0; i <= sum; i++)
            {
                if (dp[i] && dp[sum - i])
                {
                    best = Math.min(best, Math.abs(i - (sum - i)));
                }
            }
            System.out.println(best);

        }
    }
}
