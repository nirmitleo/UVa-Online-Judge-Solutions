package UVa.CleverNamingPatterns.Code1.Dinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 28-05-2017.
 */
public class Main
{
    private int V;
    private int[] dist;
    private int[] current;

    private ArrayList<Edge>[] g;
    private final static int INF = (int) 1e9;

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
        //demo.test1();
    }

    public void test() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        g = createGraph(V);

        for (int i = 0; i < E; i++)
        {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cap = Integer.parseInt(st.nextToken());

            addEdge(from, to, cap);
        }

        st = new StringTokenizer(in.readLine());
        int source = Integer.parseInt(st.nextToken());
        int sink = Integer.parseInt(st.nextToken());

        int flow = maxFlow(source, sink);
        System.out.println("Flow = " + flow);

    }

    public void printGraph()
    {
        for (int i = 0; i < V; i++)
        {
            System.out.print(i + ": ");
            for (int j = 0; j < g[i].size(); j++)
            {
                System.out.print(g[i].get(j).to + "(" + g[i].get(j).cap + ") ");
            }
            System.out.println();
        }
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(in.readLine());
        for (int t = 1; t <= test; t++)
        {
            V = 0;
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());

            V += n;
            V += 2;
            V += 26;

            g = createGraph(V);

            int source = 0;
            int sink = V - 1;
            int pStart = source + 1;
            int pEnd = pStart + n - 1;
            int catStart = pEnd + 1;
            int catEnd = sink - 1;

            for (int i = catStart; i <= catEnd; i++)
            {
                addEdge(i, sink, 1);
            }

            Pair[] problems = new Pair[n];
            ArrayList<String>[] map = new ArrayList[n];
            for (int i = 0; i < n; i++)
            {
                map[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken());
                problems[i] = new Pair(i, c);
                while (st.hasMoreTokens())
                {
                    map[i].add(st.nextToken().toUpperCase());
                }
            }

            Arrays.sort(problems);

            for (int i = 0; i < n; i++)
            {
                Pair p = problems[i];
                addEdge(source, pStart + i, 1);
                for (String s : map[p.index])
                {
                    int v = (s.charAt(0) - 'A') + catStart;
                    addEdge(pStart + i, v, INF);
                }
            }

            //printGraph();
            int flow = maxFlow(source, sink);
            //System.out.println("flow = " + flow);
            if (flow != n)
            {
                System.out.println(flow);
                throw new RuntimeException();
            }
            String result = "";
            outer:
            for (int i = catStart; i <= catEnd; i++)
            {
                String p = "" + ((char) ((i - catStart) + 'A'));
                for (Edge e : g[i])
                {
                    if (e.to >= pStart && e.to <= pEnd && e.flow == -1)
                    {
                        ArrayList<String> list = map[problems[e.to - pStart].index];
                        for (String s : list)
                        {
                            if (s.indexOf(p) == 0)
                            {
                                result += s.charAt(0) + s.substring(1).toLowerCase() + "\n";
                                continue outer;
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + t + ":");
            System.out.print(result);
        }

    }

    public ArrayList<Edge>[] createGraph(int V)
    {
        ArrayList<Edge>[] g = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList<Edge>();
        }
        return g;
    }

    public int maxFlow(int source, int sink)
    {
        int flow = 0;
        dist = new int[V];
        current = new int[V];
        outer:
        while (bfs(source, sink))
        {
            Arrays.fill(current, 0);
            while (true)
            {
                int add = dfs(source, sink, INF);
                if (add == 0)
                {
                    continue outer;
                }
                flow += add;
            }
        }
        return flow;
    }

    public int dfs(int source, int sink, int minEdge)
    {
        if (source == sink)
        {
            return minEdge;
        } else
        {
            for (int i = current[source]; i < g[source].size(); current[source] = ++i)
            {
                Edge e = g[source].get(i);
                if (dist[e.to] == dist[source] + 1 && e.cap - e.flow > 0)
                {
                    int add = dfs(e.to, sink, Math.min(minEdge, e.cap - e.flow));
                    if (add != 0)
                    {
                        e.flow += add;
                        e.rev.flow -= add;
                        return add;
                    }
                }
            }
        }
        return 0;
    }

    public boolean bfs(int source, int sink)
    {
        Arrays.fill(dist, INF);
        LinkedList<Integer> q = new LinkedList<Integer>();

        q.add(source);
        dist[source] = 0;
        while (!q.isEmpty())
        {
            int u = q.poll();
            for (Edge e : g[u])
            {
                if (dist[e.to] == INF && e.cap > e.flow)
                {
                    dist[e.to] = dist[u] + 1;
                    q.add(e.to);
                    if (e.to == sink)
                    {
                        return true;
                    }
                }
            }
        }
        return dist[sink] != INF;
    }


    public void addEdge(int from, int to, int cap)
    {
        Edge ab = new Edge(from, to, cap);
        Edge ba = new Edge(to, from, cap);

        ab.rev = ba;
        ba.rev = ab;

        g[from].add(ab);
        g[to].add(ba);
    }

    public class Edge
    {
        int from;
        int to;
        Edge rev;
        int cap;
        int flow;

        public Edge(int from, int to, int cap)
        {
            this.from = from;
            this.to = to;
            this.cap = cap;
        }
    }

    public class Pair implements Comparable<Pair>
    {
        int index;
        int count;

        public Pair(int index, int count)
        {
            this.index = index;
            this.count = count;
        }

        public int compareTo(Pair that)
        {
            int countDiff = Integer.compare(this.count, that.count);
            return countDiff != 0 ? countDiff : Integer.compare(this.index, that.index);
        }
    }
}
