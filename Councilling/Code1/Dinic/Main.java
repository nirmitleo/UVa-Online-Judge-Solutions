package UVa.Councilling.Code1.Dinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nirmit on 30-05-2017.
 */
public class Main
{
    private int V;
    private ArrayList<Edge>[] g;
    private int[] dist;
    private int[] current;
    private final static int INF = (int) 1e9;
    private TreeMap<String, Integer> persons;
    private TreeMap<Integer, String> personsInverse;
    private TreeMap<String, Integer> parties;
    private TreeMap<Integer, String> partiesInverse;
    private TreeMap<String, Integer> clubs;
    private TreeMap<Integer, String> clubsInverse;

    private ArrayList<String> input;
    private int personCount;
    private int partiesCount;
    private int clubsCount;


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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        in.readLine();
        for (int t = 1; t <= test; t++)
        {
            personCount = 0;
            partiesCount = 0;
            clubsCount = 0;
            persons = new TreeMap<String, Integer>();
            parties = new TreeMap<String, Integer>();
            clubs = new TreeMap<String, Integer>();
            personsInverse = new TreeMap<Integer, String>();
            partiesInverse = new TreeMap<Integer, String>();
            clubsInverse = new TreeMap<Integer, String>();

            input = new ArrayList<>();

            while (true)
            {
                line = in.readLine();
                if (line == null)
                {
                    return;
                }
                if (line.trim().length() == 0)
                {
                    break;
                }
                input.add(line);
                st = new StringTokenizer(line);
                String p = st.nextToken();
                personCount = Math.max(personCount, add(persons, personsInverse, personCount, p));

                String pp = st.nextToken();
                partiesCount = Math.max(partiesCount, add(parties, partiesInverse, partiesCount, pp));

                while (st.hasMoreTokens())
                {
                    String cb = st.nextToken();
                    clubsCount = Math.max(clubsCount, add(clubs, clubsInverse, clubsCount, cb));
                }
            }

            V = 2 + partiesCount + personCount + clubsCount;
            int source = 0;
            int cStart = source + 1;
            int cEnd = cStart + clubsCount - 1;
            int pStart = cEnd + 1;
            int pEnd = pStart + personCount - 1;
            int polStart = pEnd + 1;
            int polEnd = polStart + partiesCount - 1;
            int sink = polEnd + 1;
            if (V != sink + 1)
            {
                throw new RuntimeException();
            }

            g = createGraph(V);
            for (int i = cStart; i <= cEnd; i++)
            {
                addEdge(source, i, 1);
            }

            int max = (clubsCount + 1) / 2;
            max -= 1;
            for (int i = polStart; i <= polEnd; i++)
            {
                addEdge(i, sink, max);
            }

            for (int i = 0; i < input.size(); i++)
            {
                line = input.get(i);
                st = new StringTokenizer(line);

                int p = persons.get(st.nextToken()) + pStart;

                int par = parties.get(st.nextToken()) + polStart;

                addEdge(p, par, 1);

                while (st.hasMoreTokens())
                {
                    int c = clubs.get(st.nextToken()) + cStart;
                    addEdge(c, p, 1);
                }
            }
            //printGraph();
            long flow = maxFlow(source, sink);
            String result = "";
            if (flow == clubsCount)
            {
                for (int i = pStart; i <= pEnd; i++)
                {
                    for (Edge e : g[i])
                    {
                        if (e.to >= cStart && e.to <= cEnd && e.flow == -1)
                        {
                            result += personsInverse.get(i - pStart) + " " + clubsInverse.get(e.to - cStart) + "\n";
                            break;
                        }
                    }
                }
                result = result.substring(0, result.length() - 1);
            } else
            {
                //System.out.println(flow);
                result = "Impossible.";
            }
            if (t == 1)
            {
                System.out.println(result);
            } else
            {
                System.out.println("\n" + result);
            }
        }
    }

    public void printGraph()
    {
        for (int i = 0; i < V; i++)
        {
            System.out.print(i + ": ");
            for (Edge e : g[i])
            {
                System.out.print(e.to + " (" + e.flow + "/" + e.cap + ") ");
            }
            System.out.println();
        }
    }

    public int add(TreeMap<String, Integer> map, TreeMap<Integer, String> inverse, int currentMaxValue, String key)
    {
        Integer value = map.get(key);
        if (value == null)
        {
            map.put(key, currentMaxValue);
            inverse.put(currentMaxValue, key);
            return currentMaxValue + 1;
        }
        return value;
    }


    public long maxFlow(int source, int sink)
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

    public boolean bfs(int source, int sink)
    {
        Arrays.fill(dist, INF);
        LinkedList<Integer> q = new LinkedList<>();

        q.add(source);
        dist[source] = 0;

        while (!q.isEmpty())
        {
            int u = q.poll();
            for (Edge e : g[u])
            {
                if (dist[e.to] == INF && e.cap - e.flow > 0)
                {
                    q.add(e.to);
                    dist[e.to] = dist[u] + 1;
                    if (e.to == sink)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int dfs(int source, int sink, int minEdge)
    {
        if (source == sink)
        {
            return minEdge;
        }
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
        return 0;
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
}
