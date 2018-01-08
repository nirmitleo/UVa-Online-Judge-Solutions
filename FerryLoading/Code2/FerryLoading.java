package UVa.FerryLoading.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Arrays;

public class FerryLoading
{
    private int n;
    private int L;
    private Integer[] len;
    private int[][] dp;
    private final static int INVALID = -((int) 1e7);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            L = in.nextInt() * 100;
            L /= 100;
            len = readFerries(in);

            n = len.length;
            dp = new int[n][L + 1];
            for (int i = 0; i < n; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }

            StringBuilder sb = new StringBuilder("");
            int best = go(0, 0, 0);
            int x = 0;
            int y = 0;
            while (x < n && dp[x][y] != 0)
            {
                if (dp[x + 1][y] == dp[x][y] - 1)
                {
                    sb.append("port\n");
                    x = x + 1;
                } else
                {
                    sb.append("starboard\n");
                    y = y + len[x];
                    x = x + 1;
                }
            }
            if (t > 1)
            {
                out.println();
            }
            out.println(best);
            if (best > 0)
            {
                out.print(sb);
            }


//            System.out.print(" ");
//            for (int j = 0; j < L + 1; j++)
//            {
//                System.out.printf("%7d", j);
//            }
//            System.out.println();
//            for (int i = 0; i < n; ++i)
//            {
//                System.out.print(i);
//                for (int j = 0; j < L + 1; j++)
//                {
//                    if (dp[i][j] == INVALID)
//                    {
//                        dp[i][j] = -1;
//                    }
//                    System.out.printf("%7d", dp[i][j]);
//                }
//                System.out.println();
//            }
        }
    }

    private int go(int pos, int left, int total)
    {
        if (pos == n)
        {
            return 0;
        }
        if (dp[pos][left] != INVALID)
        {
            return dp[pos][left];
        }

        int res = 0;
        int aux1 = INVALID;
        int aux2 = INVALID;
        //Add to left//
        if (left + len[pos] <= L)
        {
            aux1 = 1 + go(pos + 1, left + len[pos], total + len[pos]);
        }
        //Add to right//
        int right = total - left;
        if (right + len[pos] <= L)
        {
            aux2 = 1 + go(pos + 1, left, total + len[pos]);
        }
        res = Math.max(res, aux1);
        res = Math.max(res, aux2);
        return dp[pos][left] = res;
    }

    private Integer[] readFerries(FastScanner in)
    {
        ArrayList<Integer> list = new ArrayList<>();
        while (true)
        {
            int num = in.nextInt();
            if (num == 0)
            {
                Integer[] a = new Integer[list.size()];
                list.toArray(a);
                return a;
            }
            num /= 100;
            list.add(num);
        }

    }
}
