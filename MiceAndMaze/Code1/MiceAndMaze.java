package UVa.MiceAndMaze.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MiceAndMaze
{
    private int V;
    private int E;
    private int T;
    private ArrayList[] g;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            V = in.nextInt();
            Vertex source = new Vertex(in.nextInt() - 1, 0);
            T = in.nextInt();

            g = createGraph(V);

            E = in.nextInt();
            for (int i = 0; i < E; i++)
            {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                int cap = in.nextInt();
                addEdge(to, from, cap);
            }

            int left = dijkstra(source);
            if (t == 1)
            {
                out.println(left);
            } else
            {
                out.println("\n" + left);
            }
        }

    }

    public int dijkstra(Vertex source)
    {
        PriorityQueue<Vertex> q = new PriorityQueue<>();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(source);
        dist[source.id] = 0;

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
                int from = e.from;
                int to = e.to;
                if (dist[to] > dist[from] + e.cap && dist[from] + e.cap <= T)
                {
                    dist[to] = dist[from] + e.cap;
                    Vertex V = new Vertex(e.to, dist[to]);
                    q.add(V);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < V; i++)
        {
            if (dist[i] <= T)
            {
                count++;
            }
        }
        return count;
    }

    public void addEdge(int from, int to, int cap)
    {
        Edge e = new Edge(from, to, cap);
        g[from].add(e);
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

    class Vertex implements Comparable<Vertex>
    {
        int id;
        int dist;

        public Vertex(int id, int dist)
        {
            this.id = id;
            this.dist = dist;
        }

        public int compareTo(Vertex that)
        {
            int distDiff = Integer.compare(this.dist, that.dist);
            return distDiff != 0 ? distDiff : Integer.compare(this.id, that.id);
        }
    }

    class Edge
    {
        int from;
        int to;
        int cap;

        public Edge(int from, int to, int cap)
        {
            this.from = from;
            this.to = to;
            this.cap = cap;
        }
    }
}
