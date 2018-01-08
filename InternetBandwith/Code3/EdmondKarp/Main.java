package UVa.InternetBandwith.Code3.EdmondKarp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 28-05-2017.
 */
public class Main
{
    private int V;
    private int E;
    private ArrayList<Edge>[] g;
    private final static int INF = (int) 1e9;

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
        for (int t = 1; ; t++)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;

            }
            st = new StringTokenizer(line);
            V = Integer.parseInt(st.nextToken()) + 1;
            if (V == 1)
            {
                System.out.println();
                return;
            }
            g = createGraph(V);

            st = new StringTokenizer(in.readLine());
            int source = Integer.parseInt(st.nextToken());
            int sink = Integer.parseInt(st.nextToken());

            E = Integer.parseInt(st.nextToken());
            for (int i = 0; i < E; i++)
            {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cap = Integer.parseInt(st.nextToken());
                addEdge(from, to, cap);
            }

            //printGraph();

            int flow = maxFlow(source, sink);

            if (t == 1)
            {
                System.out.println("Network " + t);
                System.out.println("The bandwidth is " + flow + ".");
            } else
            {
                System.out.print("\nNetwork " + t);
                System.out.println("\nThe bandwidth is " + flow + ".");
            }
        }


    }

    public void printGraph()
    {
        for (int i = 0; i < V; i++)
        {
            System.out.print(i + ": ");
            for (int j = 0; j < g[i].size(); j++)
            {
                System.out.print(g[i].get(j).to + "(" + g[i].get(j).cap + ")");
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
            LinkedList<Integer> q = new LinkedList<Integer>();

            q.add(source);

            outer:
            while (!q.isEmpty())
            {
                int u = q.poll();
                for (Edge e : g[u])
                {
                    if (parent[e.to] == null && e.cap - e.flow > 0)
                    {
                        q.push(e.to);
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
                Edge e = parent[u];
                e.flow += delta;
                e.rev.flow -= delta;
            }
            //System.out.println(delta);
            flow += delta;
        }
    }

    public ArrayList<Edge>[] createGraph(int v)
    {
        ArrayList<Edge>[] g = new ArrayList[v];
        for (int i = 0; i < v; i++)
        {
            g[i] = new ArrayList<Edge>();
        }
        return g;
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

    class Edge
    {
        int from;
        int to;
        int cap;
        Edge rev;
        int flow;

        public Edge(int from, int to, int cap)
        {
            this.from = from;
            this.to = to;
            this.cap = cap;
        }
    }
}
