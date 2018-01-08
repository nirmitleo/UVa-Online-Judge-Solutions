package UVa.FlightPlanning.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.GraphUtils.Graphs.IntegerGraph;

import java.util.ArrayList;

public class FlightPlanning
{
    private int V;
    private int[] dist;
    private int[] path;
    private IntegerGraph g;
    private final static int INF = ((int) 1e7);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            V = in.nextInt();
            dist = new int[V];
            path = new int[V];
            g = new IntegerGraph(V, 0);
            for (int i = 0; i < V - 1; i++)
            {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                g.addEdge(from, to, true);
            }


            int best = Integer.MAX_VALUE;
            int R1 = -1;
            int R2 = -1;
            int A1 = -1;
            int A2 = -1;

            DiameterPair pair = getDiameterPair(0);
            ArrayList<Integer> route = getRoute(pair.u, pair.v);

            int n = route.size();
            for (int i = 1; i < n; i++)
            {
                int r1 = route.get(i - 1);
                int r2 = route.get(i);

                g.removeEdge(r1, r2, true);

                DiameterPair t1 = getDiameterPair(r1);
                ArrayList<Integer> p1 = getRoute(t1.u, t1.v);

                DiameterPair t2 = getDiameterPair(r2);
                ArrayList<Integer> p2 = getRoute(t2.u, t2.v);

                int d = ((int) Math.ceil(t1.dist / 2.0)) + ((int) Math.ceil(t2.dist / 2.0)) + 1;
                d = Math.max(d, t1.dist);
                d = Math.max(d, t2.dist);

                int a1 = p1.get(p1.size() / 2);
                int a2 = p2.get(p2.size() / 2);
                if (d < best)
                {
                    best = d;
                    A1 = a1;
                    A2 = a2;
                    R1 = r1;
                    R2 = r2;
                }
                g.addEdge(r1, r2, true);
            }
            out.println(best);
            out.println((R1 + 1) + " " + (R2 + 1));
            out.println((A1 + 1) + " " + (A2 + 1));
        }
    }

    private DiameterPair getDiameterPair(int source)
    {
        int d = -INF;
        int u = -1;

        init(source);
        dfs(source);
        for (int i = 0; i < V; i++)
        {
            if (d < dist[i] && dist[i] != INF)
            {
                d = dist[i];
                u = i;
            }
        }

        d = -INF;
        int v = -1;
        init(u);
        dfs(u);
        for (int i = 0; i < V; i++)
        {
            if (d < dist[i] && dist[i] != INF)
            {
                d = dist[i];
                v = i;
            }
        }
        return new DiameterPair(u, v, d);
    }

    private ArrayList<Integer> getRoute(int source, int sink)
    {
        ArrayList<Integer> route = new ArrayList<>();
        while (sink != source)
        {
            route.add(sink);
            sink = path[sink];
        }
        route.add(sink);
        return route;
    }

    private void init(int source)
    {
        dist = new int[V];
        path = new int[V];
        for (int i = 0; i < V; i++)
        {
            dist[i] = INF;
            path[i] = i;
        }
        dist[source] = 0;
    }

    private void dfs(int u)
    {
        ArrayList<Integer> next = g.internalGraph[u];
        for (int i = 0; i < next.size(); i++)
        {
            int v = next.get(i);
            if (dist[v] == INF)
            {
                dist[v] = dist[u] + 1;
                path[v] = u;
                dfs(v);
            }
        }
    }

    private class DiameterPair
    {
        int u;
        int v;
        int dist;

        public DiameterPair(int u, int v, int dist)
        {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        public String toString()
        {
            return "Source = " + u + " Sink = " + v + " Dist = " + dist;
        }


    }
}
