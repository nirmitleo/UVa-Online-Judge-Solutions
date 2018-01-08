package UVa.QueensChessProblem.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.BitSet;

public class QueensChessProblem
{
    private int N = 8;
    private int B = 92;
    private int[] cols;

    private BitSet d1;
    private BitSet d2;
    private BitSet row;

    private int index = 0;
    private Board[] dp = new Board[B];


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        cols = new int[N];
        d1 = new BitSet(N);
        d2 = new BitSet(N);
        row = new BitSet(N);
        go(0);

        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            if (t > 1)
            {
                out.println();
            }
            out.println("SOLN       COLUMN");
            out.println(" #      1 2 3 4 5 6 7 8");
            out.println();

            int x = 1;
            int r = in.nextInt() - 1;
            int c = in.nextInt() - 1;
            for (int i = 0; i < B; i++)
            {
                if (dp[i].cols[c] == r)
                {
                    String s = "";
                    for (int j = 0; j < N; j++)
                    {
                        s += " " + (dp[i].cols[j] + 1);
                    }
                    out.println(String.format("%2d", x) + "     " + s);
                    x++;
                }
            }
        }
    }

    private void go(int pos)
    {
        if (pos == N)
        {
            int[] c = cols.clone();
            dp[index++] = new Board(c);
            return;
        }
        for (int i = 0; i < N; i++)
        {
            if (canPlace(i, pos))
            {
                row.set(i, true);
                int c1 = i - pos + N - 1;
                int c2 = i + pos;
                d1.set(c1, true);
                d2.set(c2, true);

                cols[pos] = i;
                go(pos + 1);

                row.set(i, false);
                d1.set(c1, false);
                d2.set(c2, false);
            }
        }
    }

    private boolean canPlace(int r, int c)
    {
        boolean f1 = row.get(r);

        int c1 = r - c + N - 1;
        int c2 = r + c;
        boolean f2 = d1.get(c1);
        boolean f3 = d2.get(c2);
        return !(f1 || f2 || f3);
    }

    class Board
    {
        int[] cols;

        public Board(int[] cols)
        {
            this.cols = cols;
        }
    }
}
