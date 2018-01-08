package UVa.Luggage.Code3;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.StringTokenizer;

public class Luggage
{
    private int n;
    private int[] a;
    private Boolean[][] dp;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            a = readArray(in);
            n = a.length;
            int S = 0;
            for (int i = 0; i < n; i++)
            {
                S += a[i];
            }
            if (S % 2 != 0)
            {
                out.println("NO");
            } else
            {
                int H = S / 2;
                dp = new Boolean[n][H + 1];
                boolean res = go(0, H);
                String p = res ? "YES" : "NO";
                out.println(p);
            }
        }
    }

    private boolean go(int pos, int left)
    {
        if (pos == n)
        {
            return left == 0;
        }
        if (dp[pos][left] != null)
        {
            return dp[pos][left];
        }
        boolean res = false;
        res |= go(pos + 1, left);
        if (left >= a[pos])
        {
            res |= go(pos + 1, left - a[pos]);
        }
        return dp[pos][left] = res;
    }

    private int[] readArray(FastScanner in)
    {
        String line = in.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = st.countTokens();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = Integer.parseInt(st.nextToken());
        }
        return a;
    }
}
