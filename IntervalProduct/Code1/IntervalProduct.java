package UVa.IntervalProduct.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class IntervalProduct
{
    private int n;
    private int[] st;
    private final static int ZERO = 0;
    private final static int POSITIVE = 1;
    private final static int NEGATIVE = 2;


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String line = in.next();
            if (line == null)
            {
                return;
            }

            StringBuilder sb = new StringBuilder("");

            n = Integer.parseInt(line);
            int Q = in.nextInt();

            st = new int[4 * n];
            for (int i = 0; i < n; i++)
            {
                int value = in.nextInt();
                update(1, 0, n - 1, i, value);
            }

            while (Q-- > 0)
            {
                char ch = in.next().charAt(0);
                switch (ch)
                {
                    case 'C':
                        int x = in.nextInt() - 1;
                        int value = in.nextInt();
                        update(1, 0, n - 1, x, value);
                        break;
                    case 'P':
                        int left = in.nextInt() - 1;
                        int right = in.nextInt() - 1;
                        int res = query(1, 0, n - 1, left, right);
                        switch (res)
                        {
                            case ZERO:
                                sb.append("0");
                                break;
                            case POSITIVE:
                                sb.append("+");
                                break;
                            default:
                                sb.append("-");
                                break;
                        }
                }
            }
            out.println(sb);
        }
    }


    private void relax(int pos)
    {
        int leftPos = 2 * pos;
        int rightPos = leftPos + 1;

        if (st[leftPos] == ZERO || st[rightPos] == ZERO)
        {
            st[pos] = ZERO;
            return;
        }
        if ((st[leftPos] == NEGATIVE && st[rightPos] == POSITIVE) || (st[leftPos] == POSITIVE && st[rightPos] == NEGATIVE))
        {
            st[pos] = NEGATIVE;
            return;
        }
        st[pos] = POSITIVE;
    }

    private int query(int pos, int low, int high, int left, int right)
    {
        if (left > high || right < low)
        {
            return POSITIVE;
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

        if (res1 == ZERO || res2 == ZERO)
        {
            return ZERO;
        }
        if ((res1 == NEGATIVE && res2 == POSITIVE) || (res1 == POSITIVE && res2 == NEGATIVE))
        {
            return NEGATIVE;
        }
        return POSITIVE;
    }

    private void update(int pos, int low, int high, int x, int value)
    {
        if (x < low || x > high)
        {
            return;
        }
        if (x == low && x == high)
        {
            if (value > 0)
            {
                st[pos] = POSITIVE;
            } else if (value < 0)
            {
                st[pos] = NEGATIVE;
            } else
            {
                st[pos] = ZERO;
            }
            return;
        }

        int mid = low + high;
        mid /= 2;

        int leftPos = 2 * pos;
        int rightPos = leftPos + 1;
        update(leftPos, low, mid, x, value);
        update(rightPos, mid + 1, high, x, value);

        relax(pos);
    }

}
