package UVa.Luggage.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.StringTokenizer;

public class Luggage
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int[] a = readArray(in);
            int n = a.length;
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
                boolean[] dp = new boolean[H + 1];
                dp[0] = true;
                for (int i = 0; i < n; i++)
                {
                    for (int j = H; j >= 0; j--)
                    {
                        if (dp[j] && j + a[i] <= H)
                        {
                            dp[j + a[i]] = true;
                        }
                    }
                }
                String res = (dp[H]) ? "YES" : "NO";
                out.println(res);
            }
        }
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
