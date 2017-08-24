package UVa.CoinChange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DELL on 13-Jan-16.
 */
public class Main
{
    int coinType[] = new int[]{1, 5, 10, 25, 50};
    int dp[][] = new int[coinType.length][7501];

    public static void main(String arp[])
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        demo.solve(in);
    }

    public void solve(Scanner in)
    {
        for (int i = 0; i < dp.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        ways(0, 7500);
        while (in.hasNext())
        {
            int n = in.nextInt();
            System.out.println(dp[0][n]);
        }
    }

    public int ways(int index, int value)
    {
        if (index == coinType.length || value < 0)
        {
            return 0;
        }
        if (value == 0)
        {
            return 1;
        }
        if (dp[index][value] == -1)
        {
            dp[index][value] = ways(index + 1, value) + ways(index, value - coinType[index]);
        }
        return dp[index][value];
    }
}
