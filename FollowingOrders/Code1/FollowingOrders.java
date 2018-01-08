package UVa.FollowingOrders.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.DataStructuresUtil.TreeMapUtils.TwoWayMap.NameMap.NameMap;
import Spark.GraphUtils.Graphs.IntegerGraph;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class FollowingOrders
{
    private int V;
    private int[] deg;
    private boolean[] was;
    private IntegerGraph g;
    private NameMap<String> map;
    private TreeSet<String> set;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (int t = 1; ; t++)
        {
            String line = in.nextLine();
            if (line == null)
            {
                return;
            }
            map = new NameMap<String>(true);

            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens())
            {
                String name = st.nextToken();
                map.put(name);
            }

            V = map.size();
            g = new IntegerGraph(V, 0);
            deg = new int[V];
            was = new boolean[V];

            line = in.nextLine();
            st = new StringTokenizer(line);
            while (st.hasMoreTokens())
            {
                int from = map.getByName(st.nextToken());
                int to = map.getByName(st.nextToken());
                g.addEdge(from, to, false);
                deg[to]++;
            }
            set = new TreeSet<>();
            go(0, "");
            if (t > 1)
            {
                out.println();
            }
            while (!set.isEmpty())
            {
                out.println(set.pollFirst());
            }
        }
    }

    private void go(int pos, String p)
    {
        if (pos == V)
        {
            set.add(p);
        } else
        {
            for (int i = 0; i < V; i++)
            {
                if (deg[i] == 0 && !was[i])
                {
                    was[i] = true;
                    ArrayList<Integer> next = g.internalGraph[i];
                    for (int j = 0; j < next.size(); j++)
                    {
                        int v = next.get(j);
                        deg[v]--;
                    }

                    go(pos + 1, p + map.getByID(i));

                    for (int j = 0; j < next.size(); j++)
                    {
                        int v = next.get(j);
                        deg[v]++;
                    }
                    was[i] = false;
                }
            }
        }
    }
}
