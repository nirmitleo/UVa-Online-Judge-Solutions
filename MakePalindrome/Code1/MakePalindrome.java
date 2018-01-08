package UVa.MakePalindrome.Code1;


import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;
import java.util.Stack;

public class MakePalindrome
{
    private int n;
    private char[] a;
    private int[][] dp;
    private final static int INF = (((int) 1e7));
    private String s;
    private Stack<Character> stack;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String line = in.next();
            if (line == null)
            {
                return;
            }
            s = "";
            stack = new Stack<>();
            n = line.length();
            a = line.toCharArray();
            dp = new int[n][n];
            for (int i = 0; i < n; i++)
            {
                Arrays.fill(dp[i], INF);
            }
            int moves = go(0, n - 1);
            print(0, n - 1);
            while (!stack.isEmpty())
            {
                s += stack.pop();
            }
            out.println(moves + " " + s);
        }
    }

    private void print(int left, int right)
    {
        if (left > right)
        {
            return;
        }
        if (left == right)
        {
            s += a[left];
        } else if (dp[left][right] == dp[left + 1][right] + 1)
        {
            s += a[left];
            stack.push(a[left]);
            print(left + 1, right);
        } else if (dp[left][right] == dp[left][right - 1] + 1)
        {
            s += a[right];
            stack.push(a[right]);
            print(left, right - 1);
        } else
        {
            s += a[left];
            stack.push(a[left]);
            print(left + 1, right - 1);
        }
    }

    private int go(int left, int right)
    {
        if (left == right)
        {
            return dp[left][right] = 0;
        }
        if (left + 1 == right)
        {
            dp[left][left] = 0;
            dp[right][right] = 0;
            return dp[left][right] = (a[left] == a[right]) ? 0 : 1;
        }
        if (dp[left][right] != INF)
        {
            return dp[left][right];
        }
        if (a[left] == a[right])
        {
            return dp[left][right] = go(left + 1, right - 1);
        } else
        {
            int d1 = go(left, right - 1);
            int d2 = go(left + 1, right);
            return dp[left][right] = Math.min(d1, d2) + 1;
        }
    }
}
