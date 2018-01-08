package UVa.RareOrder.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.DataStructuresUtil.TreeMapUtils.TwoWayMap.NameMap.NameMap;
import Spark.GraphUtils.Graphs.IntegerGraph;

import java.util.ArrayList;

public class RareOrder
{
    private int V;
    private int[] deg;
    private boolean[] was;
    private IntegerGraph g;
    private NameMap<Character> map;
    private ArrayList<Integer> route;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            map = new NameMap<Character>(true);
            ArrayList<String> list = new ArrayList<>();
            for (; ; )
            {
                String line = in.nextLine();
                if (line == null)
                {
                    return;
                }
                if (line.startsWith("#"))
                {
                    break;
                }
                for (int i = 0; i < line.length(); i++)
                {
                    char ch = line.charAt(i);
                    map.put(ch);
                }
                list.add(line);
            }
            V = map.size();
            deg = new int[V];
            was = new boolean[V];
            route = new ArrayList<>();
            g = new IntegerGraph(V, 0);

            for (int i = 1; i < list.size(); i++)
            {
                String from = list.get(i - 1);
                String to = list.get(i);

                int n = Math.min(from.length(), to.length());
                for (int j = 0; j < n; j++)
                {
                    char u = from.charAt(j);
                    char v = to.charAt(j);

                    if (u == v)
                    {
                        continue;
                    }
                    int f = map.getByName(u);
                    int t = map.getByName(v);

                    deg[t]++;
                    g.addEdge(f, t, false);
                    break;
                }
            }

            for (int i = 0; i < V; i++)
            {
                if (deg[i] == 0 && !was[i])
                {
                    dfs(i);
                }
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = route.size() - 1; i >= 0; i--)
            {
                sb.append(map.getByID(route.get(i)));
            }
            out.println(sb);
        }
    }

    private void dfs(int u)
    {
        was[u] = true;
        ArrayList<Integer> next = g.internalGraph[u];
        for (int i = 0; i < next.size(); i++)
        {
            int v = next.get(i);
            if (!was[v])
            {
                dfs(v);
            }
        }
        route.add(u);
    }
}
