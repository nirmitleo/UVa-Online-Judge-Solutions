package UVa.IsItATree.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.DataStructuresUtil.TreeMapUtils.TwoWayMap.NameMap.NameMap;
import Spark.GraphUtils.Graphs.IntegerGraph;
import Spark.GraphUtils.IntegerEdge;

import java.util.ArrayList;

public class IsItATree
{
    private int[] deg;
    private boolean[] was;
    private IntegerGraph g;
    private NameMap<Integer> map;
    private ArrayList<IntegerEdge> edges;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (int t = 1; ; t++)
        {
            edges = new ArrayList<>();
            map = new NameMap<Integer>(false);
            while (true)
            {
                int from = readVertex(in);
                int to = readVertex(in);
                if (from == -2 && to == -2)
                {
                    return;
                }
                if (from == -1 && to == -1)
                {
                    break;
                }
                edges.add(new IntegerEdge(from, to));
            }
            if (edges.isEmpty() || isTree())
            {
                out.println("Case " + t + " is a tree.");
            } else
            {
                out.println("Case " + t + " is not a tree.");
            }
        }
    }

    private int readVertex(FastScanner in)
    {
        int v = in.nextInt();
        if (v < 0)
        {
            return -2;
        }
        if (v == 0)
        {
            return -1;
        }
        return map.put(v);
    }

    private boolean isTree()
    {
        int V = map.size();
        deg = new int[V];
        was = new boolean[V];
        g = new IntegerGraph(V, 0);

        int left = V;
        for (int i = 0; i < edges.size(); i++)
        {
            IntegerEdge e = edges.get(i);
            deg[e.to]++;
            if (deg[e.to] == 1)
            {
                left--;
            }
            if (deg[e.to] > 1)
            {
                return false;
            }
            g.addEdge(e.from, e.to, false);
        }
        if (left != 1)
        {
            return false;
        }
        for (int i = 0; i < V; i++)
        {
            if (deg[i] == 0)
            {
                dfs(i);
                break;
            }
        }
        for (int i = 0; i < V; i++)
        {
            if (!was[i])
            {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int u)
    {
        was[u] = true;
        boolean res = true;
        ArrayList<Integer> next = g.internalGraph[u];
        for (int i = 0; i < next.size() && res; i++)
        {
            int v = next.get(i);
            if (was[v])
            {
                return false;
            }
            res &= dfs(v);
        }
        return res;
    }
}
