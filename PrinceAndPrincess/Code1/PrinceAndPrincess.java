package UVa.PrinceAndPrincess.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.Misc.BinarySearch;

import java.util.TreeMap;

public class PrinceAndPrincess
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            String line = in.next();
            if (line == null)
            {
                return;
            }
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = in.nextInt() + 1;
            int m = in.nextInt() + 1;
            int[] a = new int[m];
            for (int i = 1; i <= n; i++)
            {
                int num = in.nextInt();
                map.put(num, i);
            }
            for (int i = 0; i < m; i++)
            {
                int num = in.nextInt();
                Integer index = map.get(num);
                a[i] = index == null ? -1 : index;
            }
            int[] q = new int[m];
            int qt = 0;
            outer:
            for (int i = 0; i < m; i++)
            {
                if (i == 0)
                {
                    q[qt] = a[i];
                } else if (a[i] > -1)
                {
                    int j = BinarySearch.strictLowerBoundWithRange(a[i], q, -1, qt + 1);
                    q[j + 1] = a[i];
                    qt = Math.max(qt, j + 1);
                }
            }
            out.println("Case " + t + ": " + (qt + 1));
        }
    }
}
