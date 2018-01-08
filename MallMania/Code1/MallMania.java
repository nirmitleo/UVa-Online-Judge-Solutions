package UVa.MallMania.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;
import java.util.HashSet;

public class MallMania
{
    private int N = 2005;
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int qh;
    private int qt;
    private int[] q;
    private int[] dist;
    private HashSet<Integer> set;


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            qh = 0;
            qt = 0;
            q = new int[N * N + 1];
            dist = new int[N * N + 1];
            Arrays.fill(dist, -1);
            set = new HashSet<>();

            int p = in.nextInt();
            if (p == 0)
            {
                return;
            }
            for (int i = 0; i < p; i++)
            {
                int x = in.nextInt();
                int y = in.nextInt();
                int id = getCell(x, y);
                q[qh++] = id;
                dist[id] = 0;
            }

            p = in.nextInt();
            for (int i = 0; i < p; i++)
            {
                int x = in.nextInt();
                int y = in.nextInt();
                set.add(getCell(x, y));
            }

            int dist = bfs();
            out.println(dist);
        }
    }

    public int getCell(int x, int y)
    {
        return x * N + y;
    }

    public int bfs()
    {
        while (qt < qh)
        {
            int U = q[qt++];
            if (set.contains(U))
            {
                return dist[U];
            }

            int x1 = U / N;
            int y1 = U % N;
            for (int i = 0; i < dx.length; i++)
            {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];
                if (isValid(x2) && isValid(y2))
                {
                    int V = getCell(x2, y2);
                    if (dist[V] == -1)
                    {
                        dist[V] = dist[U] + 1;
                        q[qh++] = V;
                        if (set.contains(V))
                        {
                            return dist[V];
                        }
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    public boolean isValid(int x)
    {
        return x >= 0 && x < N;
    }
}
