package UVa.HistoryGrading.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.Misc.BinarySearch;

import java.util.StringTokenizer;

public class HistoryGrading
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            int num = in.nextInt();
            a[i] = num;
        }
        for (; ; )
        {
            int[] d = readArray(in);
            if (d == null)
            {
                return;
            }
            int[] c = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                int pos = a[i];
                c[pos] = d[i];
            }

            int qh = 0;
            int[] q = new int[n];
            for (int i = 1; i <= n; i++)
            {
                int pos = BinarySearch.lowerBoundWithRange(c[i], q, -1, qh);
                q[pos + 1] = c[i];
                qh = Math.max(qh, pos + 2);
            }
            out.println(qh);
        }
    }


    private int[] readArray(FastScanner in)
    {
        String line = in.nextLine();
        if (line == null)
        {
            return null;
        }
        StringTokenizer st = new StringTokenizer(line);
        int n = st.countTokens();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            a[i] = Integer.parseInt(st.nextToken());
        }
        return a;
    }
}
