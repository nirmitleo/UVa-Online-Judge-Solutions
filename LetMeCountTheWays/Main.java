package UVa.LetMeCountTheWays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DELL on 13-Jan-16.
 */
public class Main
{
    int coinType[] = new int[]{1, 5, 10, 25, 50};
    long dp[] = new long[30001];

    public static void main(String arp[])
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        demo.solve(in);
    }

    public void solve(Scanner in)
    {
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i < coinType.length; i++)
        {
            for (int j = 1; j < dp.length; j++)
            {
                if (j - coinType[i] < 0)
                {
                    dp[j] += 0;
                }
                else
                {
                    dp[j] += dp[j - coinType[i]];
                }
            }
        }
        while (in.hasNext())
        {
            int n = in.nextInt();
            long ans = dp[n];
            if (ans == 1)
            {
                System.out.println("There is only 1 way to produce " + n + " cents change.");
            }
            else
            {
                System.out.println("There are " + ans + " ways to produce " + n + " cents change.");
            }
        }
    }

}

