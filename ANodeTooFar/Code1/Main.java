package UVa.ANodeTooFar.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by Nirmit on 20/08/2017.
 */
public class Main
{
    private int V;
    private int E;
    private ArrayList[] g;

    private int vIndex;
    private TreeMap<Integer, Integer> vertices;

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        outer:
        for (int t = 1; ; )
        {
            vIndex = 0;
            V = 50;
            E = nextInt();
            if (E == 0)
            {
                return;
            }

            g = createGraph(V);
            vertices = new TreeMap<>();

            for (int e = 1; e <= E; e++)
            {
                int x = nextInt();
                int y = nextInt();

                int from = getVertex(x);
                int to = getVertex(y);
                addEdge(from, to);
            }
            V = vertices.size();

            for (; ; )
            {
                int vertex = nextInt();
                int dist = nextInt();
                if (vertex == 0 && dist == 0)
                {
                    continue outer;
                }

                int source = getVertex(vertex);
                int left = bfs(source, dist);
                System.out.println("Case " + t + ": " + left + " nodes not reachable from node " + vertex + " with TTL = " + dist + ".");
                t++;
            }
        }
    }

    public void addEdge(int from, int to)
    {
        g[from].add(to);
        g[to].add(from);
    }

    public int getVertex(int vertex)
    {
        Integer u = vertices.get(vertex);
        if (u == null)
        {
            vertices.put(vertex, vIndex);
            vIndex++;
            return vIndex - 1;
        }
        return u;
    }

    public ArrayList[] createGraph(int V)
    {
        ArrayList[] g = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList<Integer>();
        }
        return g;
    }

    class Vertex
    {
        int vertex;
        int dist;

        public Vertex(int vertex, int dist)
        {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public int bfs(int source, int dist)
    {
        int left = vertices.size();

        HashSet<Integer> was = new HashSet<Integer>();
        Vertex[] q = new Vertex[V];
        int qh = 1;
        int qt = 0;

        was.add(source);
        q[0] = new Vertex(source, 0);
        left--;

        while (qt < qh)
        {
            Vertex u = q[qt++];
            if (u.dist == dist)
            {
                return left;
            }
            ArrayList<Integer> next = g[u.vertex];
            for (Integer v : next)
            {
                if (!was.contains(v))
                {
                    was.add(v);
                    left--;
                    q[qh++] = new Vertex(v, u.dist + 1);
                }
            }
        }
        return left;
    }

    public int nextInt() throws IOException
    {
        String s = next();
        if (s == null)
        {
            throw new RuntimeException();
        }
        return Integer.parseInt(s);
    }

    public long nextLong() throws IOException
    {
        String s = next();
        if (s == null)
        {
            throw new RuntimeException();
        }
        return Long.parseLong(st.nextToken());
    }

    public String next() throws IOException
    {
        if (st != null && st.hasMoreTokens())
        {
            return st.nextToken();
        } else
        {
            while (true)
            {
                line = in.readLine();
                if (line == null)
                {
                    return null;
                }
                if (line.trim().length() == 0)
                {
                    continue;
                }
                st = new StringTokenizer(line);
                return st.nextToken();
            }
        }
    }


}
