package UVa.PickUpSticks.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.GraphUtils.Graphs.IntegerGraph;

import java.util.ArrayList;
import java.util.Stack;

public class PickUpSticks
{
    private int V;
    private int E;
    private int[] deg;
    private int[] was;
    private IntegerGraph g;
    private Stack<Integer> route;
    private final static int VISITED = 1;
    private final static int RELAXED = 2;
    private final static int UNVISITED = 0;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        outer:
        for (; ; )
        {
            V = in.nextInt();
            E = in.nextInt();
            if (V == 0 && E == 0)
            {
                return;
            }
            was = new int[V];
            deg = new int[V];
            route = new Stack<>();
            g = new IntegerGraph(V, 0);
            for (int i = 0; i < E; i++)
            {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                g.addEdge(from, to, false);
            }

            boolean res = true;
            for (int i = 0; i < V; i++)
            {
                if (was[i] == UNVISITED)
                {
                    res &= dfs(i);
                    if (!res)
                    {
                        out.println("IMPOSSIBLE");
                        continue outer;
                    }
                }
            }
            StringBuilder sb = new StringBuilder("");
            while (!route.isEmpty())
            {
                sb.append((route.pop() + 1) + "\n");
            }
            out.print(sb);
        }
    }

    private boolean dfs(int u)
    {
        was[u] = VISITED;
        boolean res = true;
        ArrayList<Integer> next = g.internalGraph[u];
        for (int i = 0; i < next.size() && res; i++)
        {
            int v = next.get(i);
            if (was[v] == VISITED)
            {
                return false;
            }
            if (was[v] == UNVISITED)
            {
                res &= dfs(v);
            }
        }
        route.push(u);
        was[u] = RELAXED;
        return res;
    }
}
