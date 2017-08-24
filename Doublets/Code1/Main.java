package UVa.Doublets.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nirmit on 23/08/2017.
 */
public class Main
{
    private int V;
    private int vId;
    private ArrayList[] g;
    private TreeMap<String, Integer> map;
    private TreeMap<Integer, String> reverseMap;

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
        for (; ; )
        {
            vId = 0;
            map = new TreeMap<>();
            reverseMap = new TreeMap<>();
            TreeSet<String> set = new TreeSet<>();
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
                String name = line.trim();
                getVertex(name);
                set.add(name);
            }

            V = map.size();
            g = createGraph(V);
            String[] names = new String[V];
            for (int i = 0; i < V; i++)
            {
                names[i] = set.pollFirst();
            }

            for (int i = 0; i < V; i++)
            {
                int from = getVertex(names[i]);
                for (int j = i + 1; j < V; j++)
                {
                    if (check(names[i], names[j]))
                    {
                        int to = getVertex(names[j]);
                        addEdge(from, to);
                    }
                }
            }

            int t = 1;
            while (true)
            {
                line = in.readLine();
                if (line == null || line.trim().length() == 0)
                {
                    return;
                }
                String name1 = "";
                String name2 = "";

                st = new StringTokenizer(line);
                name1 = st.nextToken();
                if (!st.hasMoreTokens())
                {
                    st = new StringTokenizer(in.readLine());
                }
                name2 = st.nextToken();
                int from = getVertex(name1);
                int to = getVertex(name2);
                String path = bfs(from, to);
                if (t == 1)
                {
                    System.out.print(path);
                } else
                {
                    System.out.print("\n" + path);
                }
                t++;
            }
        }
    }

    public String bfs(int source, int sink)
    {
        LinkedList<Vertex> q = new LinkedList<>();

        HashSet<Integer> was = new HashSet<>();

        q.add(new Vertex(source, null));
        was.add(source);

        while (!q.isEmpty())
        {
            Vertex U = q.pollFirst();
            if (U.vertex == sink)
            {
                Vertex now = U;
                String path = "";
                while (now != null)
                {
                    path = reverseMap.get(now.vertex) + "\n" + path;
                    now = now.from;
                }
                return path;
            }
            if (U.vertex >= V)
            {
                return "No solution.\n";
            }
            ArrayList<Integer> next = g[U.vertex];
            for (Integer v : next)
            {
                if (!was.contains(v))
                {
                    Vertex V = new Vertex(v, U);
                    q.add(V);
                    was.add(v);
                    if (v == sink)
                    {
                        Vertex now = V;
                        String path = "";
                        while (now != null)
                        {
                            path = reverseMap.get(now.vertex) + "\n" + path;
                            now = now.from;
                        }
                        return path;
                    }
                }
            }
        }
        return "No solution.\n";
    }

    class Vertex
    {
        int vertex;
        Vertex from;

        public Vertex(int vertex, Vertex from)
        {
            this.vertex = vertex;
            this.from = from;
        }
    }

    public void addEdge(int from, int to)
    {
        g[from].add(to);
        g[to].add(from);
    }

    public boolean check(String s1, String s2)
    {
        int count = 0;
        if (s1.length() != s2.length())
        {
            return false;
        }
        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) != s2.charAt(i))
            {
                count++;
                if (count > 1)
                {
                    return false;
                }
            }
        }
        return true;
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

    public int getVertex(String name)
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
}
