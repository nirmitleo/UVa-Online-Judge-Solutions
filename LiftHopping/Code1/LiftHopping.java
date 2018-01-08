package UVa.LiftHopping.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.io.IOException;
import java.util.*;

public class LiftHopping
{
    private int V = 100;
    private int n;
    private ArrayList[] g;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String s = in.next();
            if (s == null)
            {
                return;
            }
            n = Integer.parseInt(s);
            int sink = in.nextInt();

            g = createGraph(V);
            int[] speed = new int[n];
            for (int i = 0; i < n; i++)
            {
                speed[i] = in.nextInt();
            }
            TreeSet<Vertex> sources = new TreeSet<>();
            for (int i = 0; i < n; i++)
            {
                try
                {
                    String line = in.br.readLine().trim();
                    StringTokenizer st = new StringTokenizer(line);
                    int from = -1;
                    int to = -1;
                    while (st.hasMoreTokens())
                    {
                        from = to;
                        to = Integer.parseInt(st.nextToken());
                        if (from == -1)
                        {
                            continue;
                        }
                        addEdge(from, to, speed[i], i);
                        if (Math.min(from, to) == 0)
                        {
                            sources.add(new Vertex(0, 0, i));
                        }
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            int dist = dijkstra(sources, sink);
            if (dist == -1)
            {
                out.println("IMPOSSIBLE");
            } else
            {
                out.println(dist);
            }
        }
    }

    public int dijkstra(TreeSet<Vertex> sources, int sink)
    {
        int[][] dist = new int[V][n];
        for (int i = 0; i < V; i++)
        {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Vertex> q = new PriorityQueue<>();

        while (!sources.isEmpty())
        {
            Vertex source = sources.pollFirst();
            dist[source.id][source.elevator] = source.dist;
            q.add(source);
        }

        while (!q.isEmpty())
        {
            Vertex U = q.poll();
            if (U.dist > dist[U.id][U.elevator])
            {
                continue;
            }
            ArrayList<Edge> next = g[U.id];
            for (Edge e : next)
            {
                if (e.elevator == U.elevator)
                {
                    if (dist[e.to][e.elevator] > dist[e.from][e.elevator] + e.dist)
                    {
                        dist[e.to][e.elevator] = dist[e.from][e.elevator] + e.dist;
                        Vertex V = new Vertex(e.to, dist[e.to][e.elevator], e.elevator);
                        q.add(V);
                    }
                } else
                {
                    if (dist[e.to][e.elevator] > U.dist + e.dist + 60)
                    {
                        dist[e.to][e.elevator] = U.dist + e.dist + 60;
                        Vertex V = new Vertex(e.to, dist[e.to][e.elevator], e.elevator);
                        q.add(V);
                    }
                }
            }
        }
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            best = Math.min(best, dist[sink][i]);
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    public void addEdge(int from, int to, int speed, int type)
    {
        int cost = Math.abs(from - to) * speed;
        Edge ab = new Edge(from, to, cost, type);
        Edge ba = new Edge(to, from, cost, type);
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

    class Vertex implements Comparable<Vertex>
    {
        int id;
        int dist;
        int elevator;

        public Vertex(int id, int dist, int elevator)
        {
            this.id = id;
            this.dist = dist;
            this.elevator = elevator;
        }

        public int compareTo(Vertex that)
        {
            int distDiff = Integer.compare(this.dist, that.dist);
            if (distDiff == 0)
            {
                int idDiff = Integer.compare(this.id, that.id);
                return idDiff != 0 ? idDiff : Integer.compare(this.dist, that.dist);
            }
            return distDiff;
        }

        public String toString()
        {
            return "ID = " + id + " dist = " + dist + " elevator = " + elevator;
        }
    }

    class Edge
    {
        int from;
        int to;
        int dist;
        int elevator;

        public Edge(int from, int to, int dist, int elevator)
        {
            this.from = from;
            this.to = to;
            this.dist = dist;
            this.elevator = elevator;
        }

        public String toString()
        {
            return "from = " + from + " to = " + to + " dist = " + dist + " type = " + elevator;
        }

    }
}
