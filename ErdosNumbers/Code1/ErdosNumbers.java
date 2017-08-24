package UVa.ErdosNumbers.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class ErdosNumbers
{
    private int vId;
    private int V;
    private ArrayList[] g;
    private TreeMap<String, Integer> map;
    private final static String ERDOS = "Erdos, P.";
    private int[] dist;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            vId = 0;
            map = new TreeMap<>();
            int P = in.nextInt();
            int N = in.nextInt();
            TreeSet<Edge> edges = new TreeSet<>();
            for (int i = 0; i < P; i++)
            {
                try
                {
                    String line = in.br.readLine().trim();
                    int colon = line.indexOf(":");
                    line = line.substring(0, colon) + ",";
                    TreeSet<Integer> set = new TreeSet<>();
                    while (line.contains(","))
                    {
                        int comma = line.indexOf(",");
                        comma = line.indexOf(",", comma + 1);
                        String name = "";
                        if (comma == -1)
                        {
                            name = line.substring(0, line.indexOf(","));
                            line = line.substring(line.indexOf(",") + 1);
                        } else
                        {
                            name = line.substring(0, comma);
                            line = line.substring(comma + 1);
                        }
//                        System.out.println("**" + name.trim() + "**");
                        set.add(getVertexID(name.trim()));
                    }
                    int n = set.size();
                    int[] v = new int[n];
                    for (int j = 0; !set.isEmpty(); j++)
                    {
                        v[j] = set.pollFirst();
                    }
                    for (int v1 = 0; v1 < n; v1++)
                    {
                        for (int v2 = v1 + 1; v2 < n; v2++)
                        {
                            edges.add(new Edge(v[v1], v[v2]));
                        }
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            V = map.size();
            g = createGraph(V);
            while (!edges.isEmpty())
            {
                Edge e = edges.pollFirst();
                addEdge(e.from, e.to);
            }
            bfs(getVertexID(ERDOS));
            StringBuilder sb = new StringBuilder("Scenario " + t + "\n");
            for (int i = 0; i < N; i++)
            {
                try
                {
                    String name = in.br.readLine().trim();
                    int v = getVertexID(name);
                    if (v < 0 || v >= V || dist[v] == -1)
                    {
                        sb.append(name + " infinity\n");
                    } else
                    {
                        sb.append(name + " " + dist[v] + "\n");
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            out.print(sb);
        }
    }

    public void bfs(int source)
    {
        int[] q = new int[V + V];
        int qh = 1;
        int qt = 0;

        dist = new int[V];
        Arrays.fill(dist, -1);

        q[0] = source;
        dist[source] = 0;

        while (qt < qh)
        {
            int u = q[qt++];
            ArrayList<Integer> next = g[u];
            for (Integer v : next)
            {
                if (dist[v] == -1)
                {
                    dist[v] = dist[u] + 1;
                    q[qh++] = v;
                }
            }
        }
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

    public void addEdge(int from, int to)
    {
        g[from].add(to);
        g[to].add(from);
    }

    public int getVertexID(String name)
    {
        Integer id = map.get(name);
        if (id == null)
        {
            map.put(name, vId);
            vId++;
            return vId - 1;
        }
        return id;
    }

    class Edge implements Comparable<Edge>
    {
        int from;
        int to;

        public Edge(int from, int to)
        {
            this.from = from;
            this.to = to;
        }

        public int compareTo(Edge that)
        {
            int fromDiff = Integer.compare(this.from, that.from);
            return fromDiff != 0 ? fromDiff : Integer.compare(this.to, that.to);
        }
    }
}
