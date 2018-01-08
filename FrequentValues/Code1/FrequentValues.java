package UVa.FrequentValues.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;

public class FrequentValues
{
    private int N;
    private int[] a;
    private int[] st;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            N = in.nextInt();
            if (N == 0)
            {
                return;
            }
            int Q = in.nextInt();
            st = new int[4 * N];


            a = new int[N];
            int[] b = new int[N];
            for (int i = 0; i < N; i++)
            {
                b[i] = in.nextInt();
                a[i] = 1;
                if (i > 0)
                {
                    if (b[i] == b[i - 1])
                    {
                        a[i] = a[i - 1] + 1;
                    }
                }
            }
            System.out.println(Arrays.toString(b));
            System.out.println(Arrays.toString(a));

            build(1, 0, N - 1);
            while (Q-- > 0)
            {
                int s = in.nextInt() - 1;
                int e = in.nextInt() - 1;
                int left = Math.min(s, e);
                int right = Math.max(s, e);
                int res = query(1, 0, N - 1, left, right);
                out.println(res);
            }
        }
    }

    private void relax(int pos)
    {
        int leftPos = 2 * pos;
        int rightPos = leftPos + 1;

        st[pos] = Math.max(st[leftPos], st[rightPos]);
    }

    private int query(int pos, int low, int high, int left, int right)
    {
        if (left > high || right < low)
        {
            return -1;
        }
        if (low >= left && high <= right)
        {
            return st[pos];
        }
        int mid = low + high;
        mid /= 2;

        int leftPos = 2 * pos;
        int rightPos = leftPos + 1;
        int res1 = query(leftPos, low, mid, left, right);
        int res2 = query(rightPos, mid + 1, high, left, right);

        return Math.max(res1, res2);
    }

    private void build(int pos, int low, int high)
    {
        if (low == high)
        {
            st[pos] = a[low];
            return;
        }

        int mid = low + high;
        mid /= 2;

        int leftPos = 2 * pos;
        int rightPos = leftPos + 1;

        build(leftPos, low, mid);
        build(rightPos, mid + 1, high);

        relax(pos);
    }
}
