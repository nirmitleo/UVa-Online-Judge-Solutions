package UVa.InterstarTransport.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;

public class InterstarTransport
{
    private final static int N = 26;
    private final static int INF = ((int) 1e8);
    private int[][] g;
    private int[][] p;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String line = in.next();
            if (line == null)
            {
                return;
            }
            g = new int[N][N];
            p = new int[N][N];
            for (int i = 0; i < N; i++)
            {
                Arrays.fill(g[i], INF);
                Arrays.fill(p[i], i);
            }

            int e = in.nextInt();
            while (e-- > 0)
            {
                int from = getVertex(in);
                int to = getVertex(in);
                int w = in.nextInt();
                g[to][from] = g[from][to] = w;
            }

            for (int k = 0; k < N; k++)
            {
                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < N; j++)
                    {
                        if (g[i][j] > g[i][k] + g[k][j])
                        {
                            g[i][j] = g[i][k] + g[k][j];
                            p[i][j] = p[k][j];
                        }
                    }
                }
            }

            int q = in.nextInt();
            while (q-- > 0)
            {
                int from = getVertex(in);
                int to = getVertex(in);
                StringBuilder sb = new StringBuilder("");
                while (to != from)
                {
                    sb.insert(0, getName(to) + " ");
                    to = p[from][to];
                }
                sb.insert(0, getName(to) + " ");
                out.println(sb.toString().trim());
            }
        }

    }

    private char getName(int id)
    {
        return ((char) ('A' + id));
    }

    private int getVertex(FastScanner in)
    {
        return in.next().charAt(0) - 'A';
    }
}

