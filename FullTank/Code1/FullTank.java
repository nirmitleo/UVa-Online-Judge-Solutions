package UVa.FullTank.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class FullTank
{
    private int V;
    private int E;
    private ArrayList[] g;
    private int[] prices;
    private final static int INF = ((int) 1e9);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        V = in.nextInt();
        E = in.nextInt();
        g = createGraph(V);
        prices = new int[V];
        for (int i = 0; i < V; i++)
        {
            prices[i] = in.nextInt();
        }

        for (int i = 0; i < E; i++)
        {
            int from = in.nextInt();
            int to = in.nextInt();
            int dist = in.nextInt();
            addEdge(from, to, dist);
        }

        int Q = in.nextInt();
        while (Q-- > 0)
        {
            int cap = in.nextInt();
            int source = in.nextInt();
            int sink = in.nextInt();
            int dist = dijkstra(source, sink, cap);
            if (dist == INF)
            {
                out.println("impossible");
            } else
            {
                out.println(dist);
            }
        }
    }

    public int dijkstra(int source, int sink, int cap)
    {
        int[][] cost = new int[V][cap + 1];
        for (int i = 0; i < V; i++)
        {
            Arrays.fill(cost[i], INF);
        }

        PriorityQueue<Vertex> q = new PriorityQueue<>();

        cost[source][0] = 0;
        q.add(new Vertex(source, 0, 0));

        int best = INF;
        while (!q.isEmpty())
        {
            Vertex U = q.remove();
            if (U.cost > cost[U.id][U.fuel])
            {
                continue;
            }
            if (U.id == sink)
            {
                best = Math.min(best, U.cost);
            }
            ArrayList<Edge> next = g[U.id];
            int left = U.fuel;
            for (Edge e : next)
            {
//                IntegerEdge e = next.get(i);
                if (e.dist <= left && cost[e.to][left - e.dist] > U.cost)
                {
                    cost[e.to][left - e.dist] = U.cost;
                    Vertex V = new Vertex(e.to, left - e.dist, U.cost);
                    q.add(V);
                }
            }
            if (left + 1 <= cap)
            {
                int c = U.cost + prices[U.id];
                if (cost[U.id][left + 1] > c)
                {
                    cost[U.id][left + 1] = c;
                    Vertex V = new Vertex(U.id, left + 1, c);
                    q.add(V);
                }
            }
        }
        return best;
    }

    public void addEdge(int from, int to, int dist)
    {
        Edge ab = new Edge(from, to, dist);
        Edge ba = new Edge(to, from, dist);
        g[from].add(ab);
        g[to].add(ba);
    }

    public ArrayList[] createGraph(int V)
    {
        ArrayList[] g = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList<Edge>();
        }
        return g;
    }

    class Edge
    {
        int from;
        int to;
        int dist;

        public Edge(int from, int to, int dist)
        {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    class Vertex implements Comparable<Vertex>
    {
        int id;
        int fuel;
        int cost;

        public Vertex(int id, int fuel, int cost)
        {
            this.id = id;
            this.fuel = fuel;
            this.cost = cost;
        }

        public int compareTo(Vertex that)
        {
            int costDiff = Integer.compare(this.cost, that.cost);
//            if (costDiff == 0)
//            {
//                int fuelDiff = Integer.compare(that.fuel, this.fuel);
//                return fuelDiff != 0 ? fuelDiff : Integer.compare(this.id, that.id);
////                int idDiff = Integer.compare(this.id, that.id);
////                return idDiff != 0 ? idDiff : Integer.compare(this.fuel, that.fuel);
//            }
            return costDiff;
        }

    }
}
