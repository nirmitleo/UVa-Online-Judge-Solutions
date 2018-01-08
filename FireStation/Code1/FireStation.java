package UVa.FireStation.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.io.IOException;
import java.util.*;

public class FireStation
{
    private int V;
    private ArrayList[] g;
    private ArrayList<Integer> sources;
    private HashSet<Integer> stations;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int F = in.nextInt();
            V = in.nextInt();
            g = createGraph(V);

            sources = new ArrayList<>();
            stations = new HashSet<>();
            for (int i = 0; i < F; i++)
            {
                int city = in.nextInt() - 1;
                if (stations.add(city))
                {
                    sources.add(city);
                }
            }

            for (; ; )
            {
                try
                {
                    String line = in.br.readLine();
                    if (line == null || line.trim().length() == 0)
                    {
                        break;
                    }
                    StringTokenizer st = new StringTokenizer(line);
                    int from = Integer.parseInt(st.nextToken()) - 1;
                    int to = Integer.parseInt(st.nextToken()) - 1;
                    int dist = Integer.parseInt(st.nextToken());
                    addEdge(from, to, dist);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            int dist = Integer.MAX_VALUE;
            int city = V;
            for (int i = 0; i < V; i++)
            {
                int d = dijkstra(i);
                if (d < dist)
                {
                    dist = d;
                    city = i + 1;
                }
            }
            if (t == 1)
            {
                out.println(city);
            } else
            {
                out.println("\n" + city);
            }
        }
    }

    public int dijkstra(int source)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);


        PriorityQueue<Vertex> q = new PriorityQueue<>();
        for (Integer s : sources)
        {
            dist[s] = 0;
            q.add(new Vertex(s, 0));
        }
        dist[source] = 0;
        q.add(new Vertex(source, 0));

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
                if (dist[e.from] + e.dist < dist[e.to])
                {
                    dist[e.to] = dist[e.from] + e.dist;
                    q.add(new Vertex(e.to, dist[e.to]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < V; i++)
        {
            max = Math.max(max, dist[i]);
        }
        return max;
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

    public void addEdge(int from, int to, int dist)
    {
        Edge ab = new Edge(from, to, dist);
        Edge ba = new Edge(to, from, dist);
        g[from].add(ab);
        g[to].add(ba);
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
}
