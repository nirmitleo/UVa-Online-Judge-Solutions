package UVa.DividingCoins.Code2;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 03-06-2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private Scanner in = new Scanner(System.in);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int sum = 0;
            int n = in.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++)
            {
                coins[i] = in.nextInt();
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
                        dp[j + coins[i]] = true;
                    }
                }
            }

            int best = sum;
            for (int i = 0; i <= sum; i++)
            {
                if (dp[i])
                {
                    int first = i;
                    int second = sum - i;
                    best = Math.min(best, Math.abs(first - second));
                }
            }
            System.out.println(best);
        }
    }
}