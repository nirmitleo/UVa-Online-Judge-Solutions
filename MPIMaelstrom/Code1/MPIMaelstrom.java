package UVa.MPIMaelstrom.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;

public class MPIMaelstrom
{
    private final static int INF = ((int) 1e7);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String line = in.nextLine();
            if (line == null)
            {
                return;
            }

            int n = Integer.parseInt(line);
            int[][] g = new int[n][n];
            for (int i = 0; i < n; i++)
            {
                Arrays.fill(g[i], INF);
                g[i][i] = 0;
            }

            for (int i = 1; i < n; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    String next = in.next();
                    if (next.contains("x"))
                    {
                        continue;
                    }
                    int cost = Integer.parseInt(next);
                    g[j][i] = g[i][j] = cost;
                }
            }

            for (int k = 0; k < n; k++)
            {
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < n; j++)
                    {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
                }
            }
            int res = 0;
            for (int i = 1; i < n; i++)
            {
                res = Math.max(res, g[0][i]);
            }
            out.println(res);
        }
    }
}
