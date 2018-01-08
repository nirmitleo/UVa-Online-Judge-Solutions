package UVa.LongestMatch.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.DataStructuresUtil.TreeMapUtils.TwoWayMap.NameMap.NameMap;

public class LongestMatch
{
    private NameMap<String> map;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (int t = 1; ; t++)
        {
            map = new NameMap<>(0, false);
            String s1 = in.nextLine();
            if (s1 == null)
            {
                return;
            }
            s1 = clean(s1);
            int[] a = getIntArray(s1);

            String s2 = in.nextLine();
            s2 = clean(s2);
            int[] b = getIntArray(s2);

            String s = String.format("%2d. ", t);
            if (s1.trim().length() == 0 || s2.trim().length() == 0)
            {
                out.println(s + "Blank!");
            } else
            {
                int len = getLCS(a, b);
                out.println(s + "Length of longest match: " + len);
            }
        }
    }

    private int[] getIntArray(String line)
    {
        String[] s1 = line.split("[ ]+");

        int n = s1.length;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            a[i] = map.put(s1[i - 1]);
        }
        return a;
    }

    private int getLCS(int[] a, int[] b)
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

    private String clean(String line)
    {
        String res = "";
        for (int i = 0; i < line.length(); i++)
        {
            char ch = line.charAt(i);
            if (Character.isLetterOrDigit(ch) || Character.isWhitespace(ch))
            {
                res += ch;
            } else
            {
                res += ' ';
            }
        }
        return res;
    }
}
