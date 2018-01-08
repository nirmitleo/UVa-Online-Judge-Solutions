package UVa.KTV.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;

import static Spark.Misc.IntegerBitSet.isBitSet;
import static Spark.Misc.IntegerBitSet.on;

public class KTV
{
    private int n;
    private int[] dp;
    private int[] scores;
    private final static int INVALID = -((int) 1e8);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (int t = 1; ; t++)
        {
            n = in.nextInt();
            if (n == 0)
            {
                return;
            }
            dp = new int[1 << 9];
            scores = new int[1 << 9];
            Arrays.fill(dp, INVALID);
            Arrays.fill(scores, INVALID);
            for (int i = 0; i < n; i++)
            {
                int mask = 0;
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                int s = in.nextInt();
                mask = on(mask, a, b, c);
                scores[mask] = s;
            }
            int res = go(0);
            if (res < 0)
            {
                out.println("Case " + t + ": -1");
            } else
            {
                out.println("Case " + t + ": " + res);
            }
        }
    }

    private int go(int mask)
    {
        if (Integer.bitCount(mask) == 9)
        {
            return 0;
        }
        if (dp[mask] != INVALID)
        {
            return dp[mask];
        }
        int res = INVALID;
        for (int i = 0; i < 9; i++)
        {
            if (isBitSet(mask, i)) continue;
            for (int j = i + 1; j < 9; j++)
            {
                for (int k = j + 1; k < 9 && !isBitSet(mask, j); k++)
                {
                    if (!isBitSet(mask, k))
                    {
                        int s = on(0, i, j, k);
                        if (scores[s] != INVALID)
                        {
                            int next = on(mask, i, j, k);
                            int aux = go(next);
                            if (aux != INVALID)
                            {
                                res = Math.max(res, aux + scores[s]);
                            }
                        }
                    }
                }
            }
        }
        return dp[mask] = res;
    }
}
