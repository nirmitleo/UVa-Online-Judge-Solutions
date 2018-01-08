package UVa.FleaCircus.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.GraphUtils.Graphs.IntegerGraph;

import java.util.ArrayList;

public class FleaCircus
{
    private int L;
    private int N;
    private int timer;

    private int[][] P;
    private int[] depth;
    private int[] timeIn;
    private int[] timeOut;
    private boolean[] was;
    private IntegerGraph g;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            N = in.nextInt();
            if (N == 0)
            {
                return;
            }

            g = new IntegerGraph(N, 0);
            for (int i = 0; i < N - 1; i++)
            {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                g.addEdge(from, to, true);
            }
            build();
            StringBuilder sb = new StringBuilder("");
            int Q = in.nextInt();
            while (Q-- > 0)
            {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                if (depth[from] < depth[to])
                {
                    int temp = from;
                    from = to;
                    to = temp;
                }
                int d = dist(from, to);
                if (d % 2 == 0)
                {
                    d /= 2;
                    int w = getKthAncestor(from, d);
                    sb.append("The fleas meet at " + (w + 1) + ".\n");
                } else
                {
                    d /= 2;
                    int x = getKthAncestor(from, d);
                    int y = P[x][0];
                    if (x > y)
                    {
                        int temp = x;
                        x = y;
                        y = temp;
                    }
                    sb.append("The fleas jump forever between " + (x + 1) + " and " + (y + 1) + ".\n");
                }
            }
            out.print(sb);
        }

    }

    private int getKthAncestor(int u, int k)
    {
        while (k > 0)
        {
            int j = Integer.numberOfTrailingZeros(Integer.highestOneBit(k));
            u = P[u][j];
            k -= (1 << j);
        }
        return u;
    }

    private void build()
    {
        timer = 0;
        L = Integer.numberOfTrailingZeros(Integer.highestOneBit(N)) + 1;

        depth = new int[N];
        timeIn = new int[N];
        timeOut = new int[N];
        was = new boolean[N];
        P = new int[N][L + 1];

        dfs(0, 0);
    }

    private int dist(int a, int b)
    {
        return depth[a] + depth[b] - (depth[getLCA(a, b)] << 1);
    }

    private int getLCA(int a, int b)
    {
        int diff = depth[a] - depth[b];
        if (diff < 0)
        {
            int temp = a;
            a = b;
            b = temp;
            diff = -diff;
        }

        for (int i = 0; i < L; i++)
        {
            if ((diff & (1 << i)) > 0)
            {
                a = P[a][i];
            }
        }
        if (a != b)
        {
            for (int j = L; j >= 0; j--)
            {
                if (P[a][j] != P[b][j])
                {
                    a = P[a][j];
                    b = P[b][j];
                }
            }
            a = P[a][0];
        }
        return a;
    }

    private void dfs(int now, int prev)
    {
        was[now] = true;
        timeIn[now] = timer++;
        P[now][0] = prev;
        for (int i = 1; i <= L; i++)
        {
            P[now][i] = P[P[now][i - 1]][i - 1];
        }

        ArrayList<Integer> next = g.internalGraph[now];
        for (int i = 0; i < next.size(); i++)
        {
            int v = next.get(i);
            if (!was[v])
            {
                depth[v] = depth[now] + 1;
                dfs(v, now);
            }
        }
        timeOut[now] = timer++;
    }
}
