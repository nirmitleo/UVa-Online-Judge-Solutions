package UVa.FamilyTree.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class FamilyTree
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int level = in.nextInt();
            int b1 = in.nextInt();
            int b2 = in.nextInt();

            int l1 = getCurrentLevel(b1);
            int l2 = getCurrentLevel(b2);

            int left1 = level - l1;
            int child1 = getChildCount(left1);

            int left2 = level - l2;
            int child2 = getChildCount(left2);

            int res = getChildCount(level - 1) + 1;
            res -= Math.min(child1, child2);
            out.println(res);
        }
    }

    private int getCurrentLevel(int n)
    {
        return Integer.numberOfTrailingZeros(Integer.highestOneBit(n)) + 1;
    }

    private int getChildCount(int n)
    {
        int res = 2 * (1 - pow(2, n));
        res /= (1 - 2);
        return res;
    }

    private int pow(int b, int e)
    {
        int res = 1;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                res = res * b;
            }
            e /= 2;
            b *= b;
        }
        return res;
    }
}

