package UVa.LongestPalindrome.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class LongestPalindrome
{
    private int n;
    private char[] s;
    private int[][] dp;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int tests = in.nextInt();
        for (int t = 1; t <= tests; t++)
        {
            s = in.nextLine().toCharArray();
            n = s.length;
            if (n == 0)
            {
                out.println(0);
                continue;
            }
            dp = new int[n][n];
            int res = go(0, n - 1);
            out.println(res);
        }
    }

    private int go(int i, int j)
    {
        if (dp[i][j] != 0)
        {
            return dp[i][j];
        }
        if (i == j)
        {
            return dp[i][j] = 1;
        }
        if (i + 1 == j)
        {
            dp[i][i] = 1;
            dp[j][j] = 1;
            return (dp[i][j] = s[i] == s[j] ? 2 : 1);
        }

        if (s[i] == s[j])
        {
            return dp[i][j] = 2 + go(i + 1, j - 1);
        }
        return dp[i][j] = Math.max(go(i, j - 1), go(i + 1, j));
    }
}
