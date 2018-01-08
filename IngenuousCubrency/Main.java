package UVa.IngenuousCubrency;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DELL on 13-Jan-16.
 */
public class Main
{
    int coinType[] = new int[21];
    long dp[][] = new long[coinType.length][10001];
    long ways[] = new long[10001];

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        demo.solve(in, 0);
    }

    public void solve(Scanner in, int method)
    {
        for (int i = 0; i < coinType.length; i++)
        {
            coinType[i] = (i + 1) * (i + 1) * (i + 1);
        }
        ways[0] = 1;
        for (int i = 0; i < coinType.length; i++)
        {
            for (int j = 1; j < ways.length; j++)
            {
                if (j - coinType[i] < 0)
                {
                    ways[j] += 0;
                }
                else
                {
                    ways[j] += ways[j - coinType[i]];
                }
            }
        }
        while (in.hasNext())
        {
            int n = in.nextInt();
            System.out.println(ways[n]);
        }

    }

    public void solve(Scanner in)
    {
        for (int i = 0; i < coinType.length; i++)
        {
            coinType[i] = (i + 1) * (i + 1) * (i + 1);
        }
        for (int i = 0; i < dp.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        ways(0, 10000);
        while (in.hasNext())
        {
            int n = in.nextInt();
            System.out.println(dp[0][n]);
        }
    }

    public long ways(int index, int value)
    {
        if (index == coinType.length || value < 0)
        {
            return 0;
        }
        if (value == 0)
        {
            return dp[index][value] = 1;
        }
        if (dp[index][value] == -1)
        {
            dp[index][value] = ways(index + 1, value) + ways(index, value - coinType[index]);
        }
        return dp[index][value];
    }
}
