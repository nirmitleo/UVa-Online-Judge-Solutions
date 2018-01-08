package UVa.HowManyNodes.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.math.BigInteger;
import java.util.TreeMap;

public class HowManyNodes
{
    private TreeMap<BigInteger, Integer> map = new TreeMap<>();

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        BigInteger prev = BigInteger.ONE;
        for (int i = 1; i < 400; i++)
        {
            long N = 2 * i + 1;
            N *= 2;
            long D = i + 2;
            BigInteger now = prev.multiply(BigInteger.valueOf(N));
            now = now.divide(BigInteger.valueOf(D));
            map.put(now, i + 1);
            prev = now;

        }
        for (; ; )
        {
            String line = in.next();
            if (line == null)
            {
                return;
            }
            BigInteger n = new BigInteger(line);
            Integer count = map.get(n);
            count = (count == null) ? 1 : count;
            out.println(count);
        }
    }
}
