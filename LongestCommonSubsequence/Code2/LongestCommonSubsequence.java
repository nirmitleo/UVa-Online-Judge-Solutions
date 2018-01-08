package UVa.LongestCommonSubsequence.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class LongestCommonSubsequence
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String line = in.nextLine();
            if (line == null)
            {
                return;
            }
            char[] a = in.toCharArray(line, 1);

            line = in.nextLine();
            char[] b = in.toCharArray(line, 1);

            int res = getLCS(a, b);
            out.println(res);
        }
    }

    private int getLCS(char[] a, char[] b)
    {
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (i == 0 || j == 0)
                {
                    continue;
                }
                if (a[i] == b[j])
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
