package UVa.FacingProblemWithTrees.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.math.BigInteger;

public class FacingProblemWithTrees
{
    private int N = 550;
    private BigInteger[] S = new BigInteger[N];

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        S[0] = BigInteger.ONE;
        S[1] = BigInteger.ONE;
        S[2] = BigInteger.ZERO;
        S[3] = BigInteger.ONE;
        for (int i = 4; i < N; i++)
        {
            if (i % 2 == 0)
            {
                S[i] = BigInteger.ZERO;
            } else
            {
                int b = i - 2;
                S[i] = ncr(b, (b + 1) / 2);
            }
        }
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int n = in.nextInt();
            out.println("Case " + t + ": " + S[n + 1]);
        }
    }

    private BigInteger ncr(int n, int r)
    {
        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < r; i++)
        {
            res = res.multiply(BigInteger.valueOf(n - i));
            res = res.divide(BigInteger.valueOf(i + 1));
        }
        return res;
    }
}
