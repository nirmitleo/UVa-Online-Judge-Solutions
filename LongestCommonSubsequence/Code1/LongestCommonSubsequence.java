package UVa.LongestCommonSubsequence.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.io.IOException;

public class LongestCommonSubsequence
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String s1 = null;
            try
            {
                s1 = in.br.readLine();
                if (s1 == null)
                {
                    return;
                }
                String s2 = in.br.readLine();
                out.println(lcs(s1, s2));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private int lcs(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        char[] a = toCharArray(s1, 1);
        char[] b = toCharArray(s2, 1);

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < m + 1; j++)
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
        return dp[n][m];
    }

    private char[] toCharArray(String s, int offset)
    {
        int n = s.length();
        char[] ch = new char[n + offset];
        for (int i = 0; i < n; i++)
        {
            ch[i + offset] = s.charAt(i);
        }
        return ch;
    }
}
