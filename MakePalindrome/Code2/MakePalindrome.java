package UVa.MakePalindrome.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Stack;

public class MakePalindrome
{
    private int n;
    private char[] a;
    private int[][] dp;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String line = in.nextLine();
            if (line == null)
            {
                return;
            }

            n = line.length();
            a = line.toCharArray();
            dp = new int[n][n];
            go(0, n - 1);

            int cnt = 0;
            int x = 0;
            int y = n - 1;
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder("");
            while (x <= y)
            {
                if (x == y)
                {
                    sb.append(a[x]);
                    break;
                }
                if (a[x] == a[y])
                {
                    sb.append(a[x]);
                    stack.push(a[y]);
                    x++;
                    y--;
                } else
                {
                    cnt++;
                    if (dp[x + 1][y] == dp[x][y])
                    {
                        sb.append(a[x]);
                        stack.push(a[x]);
                        x++;
                    } else
                    {
                        sb.append(a[y]);
                        stack.push(a[y]);
                        y--;
                    }
                }
            }
            while (!stack.isEmpty())
            {
                sb.append(stack.pop());
            }
            out.println(cnt + " " + sb);
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
            dp[i][j] = (a[i] == a[j]) ? 2 : 1;
            return dp[i][j];
        }

        int res1 = go(i, j - 1);
        int res2 = go(i + 1, j);
        int res3 = -1;
        if (a[i] == a[j])
        {
            res3 = go(i + 1, j - 1) + 2;
        }
        dp[i][j] = Math.max(res1, Math.max(res2, res3));
        return dp[i][j];
    }
}
