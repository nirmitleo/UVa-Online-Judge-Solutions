package UVa.Getaway.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Getaway
{
    private int row;
    private int col;

    private int V;
    private int[] dist;
    private TreeSet[] vertexTime;

    HashSet<Edge> excludeEdge;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String s = in.next();
            if (s == null)
            {
                return;
            }
            col = Integer.parseInt(s);
            row = in.nextInt();

            V = row * col;
//            V = 100 * 100;
            dist = new int[V];
            vertexTime = new TreeSet[V];
            excludeEdge = new HashSet<>();
            for (int i = 0; i < V; i++)
            {
                dist[i] = -1;
                vertexTime[i] = new TreeSet<Integer>();
            }

            int R = in.nextInt();
            for (int i = 0; i < R; i++)
            {
                int y1 = in.nextInt();
                int x1 = in.nextInt();
                int from = getVertexID(y1, x1);

                int y2 = in.nextInt();
                int x2 = in.nextInt();
                int to = getVertexID(y2, x2);

                Edge e = new Edge(from, to);
                excludeEdge.add(e);
            }

            int M = in.nextInt();
            for (int i = 0; i < M; i++)
            {
                int time = in.nextInt();
                int y = in.nextInt();
                int x = in.nextInt();
                int v = getVertexID(y, x);
                if (v >= 0 && v < V)
                {
                    vertexTime[v].add(time);
                }
            }

            int time = bfs(0, V - 1);
//            System.out.println(time);
            out.println(time);
        }
    }

    public int bfs(int source, int sink)
    {
        LinkedList<Integer> q = new LinkedList<>();

        q.add(source);
        dist[source] = 0;
        while (!q.isEmpty())
        {
            int u = q.pollFirst();
            if (u == sink)
            {
                return dist[u];
            }

            for (int i = 0; i < 4; i++)
            {
                int v = -1;
                switch (i)
                {
                    case 0:
                        v = u + 1;
                        break;
                    case 1:
                        v = u + 1;
                        break;
                    case 2:
                        v = u + col;
                        break;
                    case 3:
                        v = u - col;
                        break;
                }
                if (v < 0 || v >= V)
                {
                    continue;
                }
                Edge e = new Edge(u, v);
                if (!excludeEdge.contains(e))
                {
                    //Not visited//
                    if (dist[v] == -1)
                    {
                        if (vertexTime[v].contains(dist[u] + 1))
                        {
                            q.add(u);
                            dist[u]++;
                        } else
                        {
                            q.add(v);
                            dist[v] = dist[u] + 1;
                        }
                    }
                }

            }
//            q.add(u);
//            dist[u]++;
        }
        throw new RuntimeException();
    }

    public int getVertexID(int x, int y)
    {
        return y * row + x;
    }

    class Edge
    {
        int from;
        int to;

        public Edge(int from, int to)
        {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (from != edge.from) return false;
            return to == edge.to;
        }

        @Override
        public int hashCode()
        {
            int result = from;
            result = 31 * result + to;
            return result;
        }
    }
}
