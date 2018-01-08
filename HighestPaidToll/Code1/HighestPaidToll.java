package UVa.HighestPaidToll.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HighestPaidToll
{
    private int V;
    private int E;
    private ArrayList[] g;
    private int[] forward;
    private int[] backward;
    private final static int INF = ((int) 1e9);


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            V = in.nextInt();
            E = in.nextInt();
            int source = in.nextInt();
            int sink = in.nextInt();
            int p = in.nextInt();

            g = createGraph(V + 1);
            for (int i = 0; i < E; i++)
            {
                int from = in.nextInt();
                int to = in.nextInt();
                int dist = in.nextInt();
                addEdge(from, to, dist);
            }

            forward = new int[V + 1];
            backward = new int[V + 1];
            dijkstra(source, p, forward, true);
            dijkstra(sink, p, backward, false);
            int best = -1;
            for (int from = 1; from <= V; from++)
            {
                ArrayList<Edge> next = g[from];
                for (Edge e : next)
                {
                    if (e.isFront)
                    {
                        int to = e.to;
                        if (forward[from] + e.dist + backward[to] <= p)
                        {
                            best = Math.max(best, e.dist);
                        }
                    }
                }
            }
            out.println(best);
        }
    }

    public void dijkstra(int source, int p, int[] dist, boolean isFront)
    {
        Arrays.fill(dist, INF);
        PriorityQueue<Vertex> q = new PriorityQueue<>();

        dist[source] = 0;
        q.add(new Vertex(source, 0, 0));

        while (!q.isEmpty())
        {
            Vertex U = q.poll();
            if (U.dist > dist[U.id])
            {
                continue;
            }
            ArrayList<Edge> next = g[U.id];
            for (Edge e : next)
            {
                if (e.isFront == isFront)
                {
                    int nextDist = dist[U.id] + e.dist;
                    if (nextDist < dist[e.to] && nextDist <= p)
                    {
                        dist[e.to] = dist[U.id] + e.dist;
                        Vertex V = new Vertex(e.to, dist[e.to], Math.max(e.dist, U.best));
                        q.add(V);
                    }
                }
            }
        }
    }

    public void addEdge(int from, int to, int dist)
    {
        Edge ab = new Edge(from, to, dist, true);
        g[from].add(ab);

        Edge ba = new Edge(to, from, dist, false);
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
        boolean isFront;

        public Edge(int from, int to, int dist, boolean isFront)
        {
            this.from = from;
            this.to = to;
            this.dist = dist;
            this.isFront = isFront;
        }
    }

    class Vertex implements Comparable<Vertex>
    {
        int id;
        int best;
        int dist;

        public Vertex(int id, int dist, int best)
        {
            this.id = id;
            this.dist = dist;
            this.best = best;
        }

        public int compareTo(Vertex that)
        {
            int distDiff = Integer.compare(this.dist, that.dist);
            return distDiff;
        }
    }
}
