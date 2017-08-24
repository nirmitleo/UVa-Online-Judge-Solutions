package UVa.CleverNamingPatterns.Code1.EdmondKarp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 29-05-2017.
 */
public class Main
{
    private int V;
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
        System.out.println("flow = " + flow);
    }

    public void solve() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());

            V = n + 2 + 26;
            int source = 0;
            int sink = V - 1;
            int pStart = source + 1;
            int pEnd = pStart + n - 1;
            int catStart = pEnd + 1;
            int catEnd = sink - 1;

            g = createGraph(V);

            for (int i = catStart; i <= catEnd; i++)
            {
                addEdge(i, sink, 1);
            }

            Pair[] count = new Pair[n];
            ArrayList<String>[] map = new ArrayList[n];
            for (int i = 0; i < n; i++)
            {
                map[i] = new ArrayList<String>();
            }

            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken());

                count[i] = new Pair(i, c);

                while (st.hasMoreTokens())
                {
                    String s = st.nextToken();
                    map[i].add(s.toUpperCase());
                }
            }

            Arrays.sort(count);

            //System.out.println(Arrays.toString(count));


            for (int i = 0; i < n; i++)
            {
                Pair p = count[i];
                addEdge(source, i + pStart, 1);

                for (String s : map[p.index])
                {
                    int v = ((s.charAt(0) - 'A') + catStart);
                    addEdge(i + pStart, v, INF);
                }
            }
//            printGraph();
            int flow = maxFlow(source, sink);
            if (flow != n)
            {
                System.out.println("Flow = " + flow);
                throw new RuntimeException();
            }
            //printGraph();
            String result = "";
            outer:
            for (int i = catStart; i <= catEnd; i++)
            {
                String s = "" + (char) ((i - catStart) + 'A');
                for (Edge e : g[i])
                {
                    if (e.to >= pStart && e.to <= pEnd && e.flow == -1)
                    {
                        ArrayList<String> list = map[count[e.to - pStart].index];
                        for (String ss : list)
                        {
                            if (ss.indexOf(s) == 0)
                            {
                                result += ss.charAt(0) + ss.substring(1).toLowerCase() + "\n";
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

    public void printGraph()
    {
        for (int i = 0; i < V; i++)
        {
            System.out.print(i + ": ");
            for (Edge e : g[i])
            {
                System.out.print(e.to + "(" + e.cap + "/" + e.flow + ")");
            }
            System.out.println();
        }
    }

    public int maxFlow(int source, int sink)
    {
        int flow = 0;
        while (true)
        {
            Edge[] parent = new Edge[V];
            LinkedList<Integer> q = new LinkedList<>();

            q.add(source);
            outer:
            while (!q.isEmpty())
            {
                int u = q.poll();
                for (Edge e : g[u])
                {
                    if (parent[e.to] == null && e.cap - e.flow > 0)
                    {
                        q.add(e.to);
                        parent[e.to] = e;
                        if (e.to == sink)
                        {
                            break outer;
                        }
                    }
                }
            }

            if (parent[sink] == null)
            {
                return flow;
            }

            int delta = INF;
            for (int u = sink; u != source; u = parent[u].from)
            {
                delta = Math.min(delta, parent[u].cap - parent[u].flow);
            }
            for (int u = sink; u != source; u = parent[u].from)
            {
                parent[u].flow += delta;
                parent[u].rev.flow -= delta;
            }

            flow += delta;

        }
    }

    public ArrayList<Edge>[] createGraph(int V)
    {
        g = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList<Edge>();
        }
        return g;
    }

    public void addEdge(int from, int to, int cap)
    {
        Edge ab = new Edge(from, to, cap);
        Edge ba = new Edge(to, from, 0);

        ab.rev = ba;
        ba.rev = ab;

        g[from].add(ab);
        g[to].add(ba);
    }

    class Edge
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

    class Pair implements Comparable<Pair>
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

        public String toString()
        {
            return "index = " + index + " count = " + count + "\n";
        }
    }
}
