package UVa.LongestPalindrome.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.io.IOException;

public class LongestPalindrome
{
    private int n;
    private char[] a;
    private int[][] dp;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            try
            {
                String line = in.br.readLine();
                if (line.trim().length() == 0)
                {
                    out.println(0);
                    continue;
                }
                a = line.toCharArray();
                n = a.length;
                dp = new int[n][n];
                int len = go(0, n - 1);
                out.println(len);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private int go(int left, int right)
    {
        if (left == right)
        {
            return dp[left][right] = 1;
        }
        if (left + 1 == right)
        {
            if (a[left] == a[right])
            {
                return dp[left][right] = 2;
            } else
            {
                return dp[left][right] = 1;
            }
        }
        if (dp[left][right] != 0)
        {
            return dp[left][right];
        }
        if (a[left] == a[right])
        {
            dp[left][right] = 2 + go(left + 1, right - 1);
        } else
        {
            dp[left][right] = Math.max(go(left, right - 1), go(left + 1, right));
        }
        return dp[left][right];
    }
}
