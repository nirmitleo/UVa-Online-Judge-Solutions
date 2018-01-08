package UVa.PrinceAndPrincess.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.TreeMap;

public class PrinceAndPrincess
{
    private TreeMap<Integer, Integer> map;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int tests = in.nextInt();
        for (int t = 1; t <= tests; t++)
        {
            in.nextInt();

            int n = in.nextInt() + 1;
            int m = in.nextInt() + 1;

            map = new TreeMap<>();

            for (int i = 0; i < n; i++)
            {
                int v = in.nextInt();
                map.put(v, i);
            }

            int[] b = new int[m];
            for (int i = 0; i < m; i++)
            {
                b[i] = in.nextInt();
                Integer pos = map.get(b[i]);
                pos = (pos == null) ? -1 : pos;
                b[i] = pos;
            }

            int len = getLIS(b);
            out.println("Case " + t + ": " + len);
        }
    }

    private int getLIS(int[] a)
    {
        int n = a.length;
        int qh = 0;
        int[] q = new int[n];
        for (int i = 0; i < n; i++)
        {
            int low = -1;
            int high = qh;
            while (high - low > 1)
            {
                int mid = low + (high - low) / 2;
                if (q[mid] < a[i])
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
            q[low + 1] = a[i];
            qh = Math.max(low + 2, qh);
        }
        return qh;
    }
}
