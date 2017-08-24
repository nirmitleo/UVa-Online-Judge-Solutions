package UVa.GalacticImport.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.*;

public class GalacticImport
{
    private int V;
    private int vIndex;
    private ArrayList[] g;
    private TreeMap<Character, Integer> map;
    private TreeMap<Integer, Vertex> vertices;


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String s = in.next();
            if (s == null)
            {
                return;
            }
            V = Integer.parseInt(s) + 1;

            vIndex = 1;
            g = createGraph(V);
            map = new TreeMap<>();
            vertices = new TreeMap<>();

            Vertex earth = new Vertex(0, 0);
            earth.dist = 100;
            vertices.put(0, earth);


            for (int i = 1; i < V; i++)
            {
                char name = in.next().charAt(0);
                double score = in.nextDouble();
                String next = in.next();

                int from = getVertex(name);
                vertices.put(from, new Vertex(name, from, score));

                for (int j = 0; j < next.length(); j++)
                {
                    char ch = next.charAt(j);
                    if (ch == '*')
                    {
                        addEdge(from, 0);
                    } else
                    {
                        int to = getVertex(ch);
                        addEdge(from, to);
                    }
                }
            }

            bfs(0);
            Vertex[] a = new Vertex[V];
            for (Map.Entry<Integer, Vertex> entry : vertices.entrySet())
            {
                Vertex v = entry.getValue();
                a[v.vertex] = v;
            }

            Arrays.sort(a, new Comparator<Vertex>()
            {
                @Override
                public int compare(Vertex o1, Vertex o2)
                {
                    int wantedDiff = Double.compare(o2.wanted, o1.wanted);
                    return wantedDiff != 0 ? wantedDiff : Character.compare(o1.name, o2.name);
                }
            });

            out.println("Import from " + a[0].name);
        }
    }

    public void bfs(int source)
    {
        int[] q = new int[V];
        int qh = 1;
        int qt = 0;

        boolean[] was = new boolean[V];

        q[0] = source;
        was[source] = true;
        while (qt < qh)
        {
            int u = q[qt++];
            Vertex x = vertices.get(u);
            ArrayList<Integer> next = g[u];
            for (Integer v : next)
            {
                if (!was[v])
                {
                    was[v] = true;
                    q[qh++] = v;
                    Vertex y = vertices.get(v);
                    y.dist = 0.95 * x.dist;
                    y.wanted = y.score * y.dist;
                }
            }
        }
    }

    public ArrayList[] createGraph(int V)
    {
        ArrayList[] g = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList();
        }
        return g;
    }

    public void addEdge(int from, int to)
    {
        g[from].add(to);
        g[to].add(from);
    }

    public int getVertex(char name)
    {
        Integer v = map.get(name);
        if (v == null)
        {
            map.put(name, vIndex);
            vIndex++;
            return vIndex - 1;
        }
        return v;
    }

    class Vertex
    {
        char name;
        int vertex;
        double dist;
        double score;
        double wanted;

        public Vertex(char name, int vertex, double score)
        {
            this.name = name;
            this.vertex = vertex;
            this.score = score;
        }

        public Vertex(int vertex, double score)
        {
            this.vertex = vertex;
            this.score = score;
        }

    }


}
