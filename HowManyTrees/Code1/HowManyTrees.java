package UVa.HowManyTrees.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.math.BigInteger;

public class HowManyTrees
{
    private int N = 1000;
    private BigInteger[] C = new BigInteger[N + 1];

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        C[0] = BigInteger.ONE;
        for (int i = 1; i < N + 1; i++)
        {
            long n = 2 * i + 1;
            n *= 2;
            long d = i + 2;
            C[i] = C[i - 1].multiply(BigInteger.valueOf(n));
            C[i] = C[i].divide(BigInteger.valueOf(d));
        }
        for (; ; )
        {
            String line = in.nextLine();
            if (line == null)
            {
                return;
            }
            int pos = Integer.parseInt(line);
            out.println(C[pos - 1]);
        }
    }
}
