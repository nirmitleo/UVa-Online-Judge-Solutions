package UVa.AllRoadsLeadWhere.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class AllRoadsLeadWhere
{
    private int V;
    private int E;
    private ArrayList[] g;
    private int vId;
    private TreeMap<Character, Integer> map;
    private TreeMap<Integer, Character> reverseMap;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            vId = 0;
            map = new TreeMap<>();
            reverseMap = new TreeMap<>();

            E = in.nextInt();
            int Q = in.nextInt();
            TreeSet<Edge> edges = new TreeSet<>();
            for (int i = 0; i < E; i++)
            {
                String name1 = in.next();
                String name2 = in.next();

                int from = getVertex(name1.charAt(0));
                int to = getVertex(name2.charAt(0));
                edges.add(new Edge(from, to));
            }
            V = map.size();
            g = createGraph(V);
            while (!edges.isEmpty())
            {
                Edge e = edges.pollFirst();
                addEdge(e.from, e.to);
            }

            String result = "";
            for (int q = 1; q <= Q; q++)
            {
                String name1 = in.next();
                String name2 = in.next();
                int source = getVertex(name1.charAt(0));
                int sink = getVertex(name2.charAt(0));
                String path = bfs(source, sink);
                result = result + path + "\n";
            }
            if (t == 1)
            {
                out.println(result.trim());
            } else
            {
                out.println("\n" + result.trim());
            }
        }
    }

    public String bfs(int source, int sink)
    {
        int[] q = new int[V];
        int qh = 1;
        int qt = 0;

        boolean[] was = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        q[0] = source;
        was[source] = true;
        parent[source] = source;

        while (qt < qh)
        {
            int u = q[qt++];
            ArrayList<Integer> next = g[u];
            for (Integer v : next)
            {
                if (!was[v])
                {
                    was[v] = true;
                    parent[v] = u;
                    if (v == sink)
                    {
                        String path = "";
                        int to = v;
                        int from = parent[v];
                        while (from != to)
                        {
                            path = reverseMap.get(to) + "" + path;
                            to = from;
                            from = parent[from];
                        }
                        return reverseMap.get(source) + path;
                    }
                    q[qh++] = v;
                }
            }
        }
        throw new RuntimeException();

    }

    public int getVertex(char name)
    {
        Integer v = map.get(name);
        if (v == null)
        {
            map.put(name, vId);
            reverseMap.put(vId, name);
            vId++;
            return vId - 1;
        }
        return v;
    }

    private ArrayList[] createGraph(int V)
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
