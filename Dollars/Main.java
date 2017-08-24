package UVa.Dollars;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by DELL on 13-Jan-16.
 */
public class Main
{
    int coinTypes[] = new int[]{5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
    long dp[] = new long[30100];

    public static void main(String arg[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        demo.solve(in);
    }

    public void solve(Scanner in)
    {
        dp[0] = 1;
        for (int i = 0; i < coinTypes.length; i++)
        {
            for (int j = 1; j < dp.length; j++)
            {
                if (j - coinTypes[i] < 0)
                {
                    dp[j] += 0;
                }
                else
                {
                    dp[j] += dp[j - coinTypes[i]];
                }
            }
        }
        while (true)
        {
            double n = in.nextDouble();
            if (n == 0)
            {
                break;
            }
            int intN = (int) (n * 100 + 0.005);
            //System.out.println(intN);
            long ans = dp[intN];
            System.out.printf("%6.2f%17d\n", n, ans);
        }
    }

}
