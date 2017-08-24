package UVa.CollectorsProblem.Code1.Dinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nirmit on 29-05-2017.
 */
public class Main
{
    private int source;
    private int nos;
    private int personStart;
    private int personEnd;
    private int pSet;
    private int pEnd;
    private int bSet;
    private int bEnd;
    private int sink;
    private TreeSet<Integer> valid = new TreeSet<>();

    private int V;
    private ArrayList<Edge>[] g;
    private int[] dist;
    private int[] current;
    private Edge[][] list;
    private Edge[] bobList;
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

    public void solve() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            valid.add(0);
            valid.add(1);
            valid.add(2);
            valid.add(3);
            valid.add(4);
            valid.add(5);
            valid.add(6);
            valid.add(28);
            valid.add(29);
            valid.add(53);
            source = 0;
            nos = n - 1;
            personStart = source + 1;
            personEnd = personStart + nos - 1;
            pSet = personEnd + 1;
            pEnd = pSet + 25 - 1;
            bSet = pEnd + 1;
            bEnd = bSet + 25 - 1;
            sink = bEnd + 1;
            V = sink + 1;

//            System.out.println("source = " + source);
//            System.out.println("No of people(without bob) = " + nos);
//            System.out.println("No of people (start index) = " + personStart);
//            System.out.println("No of people (end index) = " + personEnd);
//            System.out.println("Person problem start index = " + pSet);
//            System.out.println("Person problem end index = " + pEnd);
//            System.out.println("Bob problem start index = " + bSet);
//            System.out.println("Bob problem end index = " + bEnd);
//            System.out.println("sink = " + sink);
//            System.out.println("Total V = " + V);

            g = createGraph(V);

            for (int i = personStart; i <= personEnd; i++)
            {
                addEdge(source, i, INF);
            }
            for (int i = pSet, u = 1; i <= pEnd; i++, u++)
            {
                for (int j = bSet, v = 1; j <= bEnd; j++, v++)
                {
                    if (u != v)
                    {
                        //System.out.println("edge between person's " + u + " to bob's " + v);
                        addEdge(i, j, INF);
                    }
                }
            }


            list = new Edge[n][26];
            bobList = new Edge[26];

            for (int i = 1; i < bobList.length; i++)
            {
                Edge e = addEdge(bSet + i - 1, sink, -1);
                bobList[i] = e;
            }


            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int count = Integer.parseInt(st.nextToken());
                while (st.hasMoreTokens())
                {
                    int k = Integer.parseInt(st.nextToken());
                    Edge e = null;
                    if (i == 0)
                    {
                        bobList[k].count++;
                        increaseFlow(bobList[k]);
                    } else
                    {
                        if (list[i][k] == null)
                        {
                            e = addEdge(i, k + pSet - 1, 0);
                            list[i][k] = e;
                        } else
                        {
                            increaseFlow(list[i][k]);
                        }
                    }
                }
            }

            //printGraph();

            int flow = maxFlow(source, sink);

            int result = 0;
            for (int i = 1; i < bobList.length; i++)
            {
                if (bobList[i].count > 0)
                {
                    result++;
                }
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }

    public void printGraph()
    {
        for (int i = 0; i < V; i++)
        {
            if (valid.contains(i))
            {
                System.out.print(i + ": ");
                for (int j = 0; j < g[i].size(); j++)
                {
                    Edge e = g[i].get(j);
                    if (valid.contains(e.to))
                    {
                        System.out.print(g[i].get(j).to + "(" + g[i].get(j).flow + "/" + g[i].get(j).cap + ") ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void increaseFlow(Edge edge)
    {
        edge.cap++;
    }

    public int maxFlow(int source, int sink)
    {
        dist = new int[V];
        current = new int[V];

        int flow = 0;
        while (bfs(source, sink))
        {
            Arrays.fill(current, 0);
            while (true)
            {
                int add = dfs(source, sink, INF);
                if (add == 0)
                {
                    break;
                }
                flow += add;
            }
        }
        return flow;
    }

    public int dfs(int source, int sink, int minEdge)
    {
        //System.out.println("hi");
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
                        if (e.from >= bSet && e.from <= bEnd)
                        {
                            //System.out.println("Reduce flow = " + (e.from - bSet + 1));
                            e.count++;
                        }
                        if (e.to >= pSet && e.to <= pEnd)
                        {
                            int k = e.to - pSet + 1;
                            increaseFlow(bobList[k]);
                            bobList[k].count++;
                            //System.out.println("Increase flow = " + k);
                        }
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
        LinkedList<Integer> q = new LinkedList<>();

        dist[source] = 0;
        q.add(source);
        //System.out.println("hi");
        while (!q.isEmpty())
        {
            int u = q.poll();
            for (Edge e : g[u])
            {
                if (dist[e.to] == INF && e.cap - e.flow > 0)
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

    public ArrayList<Edge>[] createGraph(int V)
    {
        ArrayList<Edge>[] g = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList<Edge>();
        }
        return g;
    }

    public Edge addEdge(int from, int to, int cap)
    {
        Edge ab = new Edge(from, to, cap);
        Edge ba = new Edge(to, from, 0);

        ab.rev = ba;
        ba.rev = ab;
        g[from].add(ab);
        g[to].add(ba);

        return ab;
    }

    class Edge
    {
        int from;
        int to;
        Edge rev;
        int cap;
        int flow;
        int count;

        public Edge(int from, int to, int cap)
        {
            this.from = from;
            this.to = to;
            this.cap = cap;
        }

    }
}
