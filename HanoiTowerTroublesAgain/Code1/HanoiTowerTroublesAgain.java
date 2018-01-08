package UVa.HanoiTowerTroublesAgain.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.TreeSet;

public class HanoiTowerTroublesAgain
{
    private int N = 7;
    private int res;
    private int[] pegs;
    private TreeSet<Integer> set = new TreeSet<>();
    private int[] dp = new int[51];

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        dp[1] = 1;
        dp[2] = 3;
        int now = 2;
        for (int i = 3; i < 51; i++)
        {
            if (i % 2 != 0)
            {
                now += 2;
            }
            dp[i] = dp[i - 1] + now;
        }
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int n = in.nextInt();
            out.println(dp[n]);
        }
    }

    private void go(int now)
    {
        for (int i = 0; i < N; i++)
        {
            if (pegs[i] == 0 || set.contains(pegs[i] + now))
            {
                int prev = pegs[i];
                pegs[i] = now;
                go(now + 1);
                pegs[i] = prev;
            }
        }
        res = Math.max(res, now);
    }
}
