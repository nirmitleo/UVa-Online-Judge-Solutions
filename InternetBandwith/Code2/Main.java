package UVa.InternetBandwith.Code2;

import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * some cheeky quote
 */

public class Main
{
    private FastScanner in;
    private PrintWriter out;
    private TreeMap<Integer, TreeMap<Integer, Integer>> g;
    private TreeMap<Integer, Integer> parent;
    private TreeMap<Integer, Integer> dist;
    private int flow;
    private int maxFlow;
    private int n;
    private int S;
    private int T;
    private int test = 1;
    private int INF = Integer.MAX_VALUE;


    public void solve() throws IOException
    {
        String tokens = null;
        while (true)
        {
            tokens = in.next();
            n = Integer.parseInt(tokens);
            if (n == 0)
            {
                //out.println();
                return;
            }
            init();
            S = in.nextInt();
            T = in.nextInt();
            int E = in.nextInt();
            for (int i = 0; i < E; i++)
            {
                int from = in.nextInt();
                int to = in.nextInt();
                int cost = in.nextInt();
                addEdge(from, to, cost);
                addEdge(to, from, cost);
            }
            maxFlow();
            System.out.println("Network " + test);
            System.out.println("The bandwidth is " + maxFlow + ".\n");
            test++;
        }

    }

    public void addEdge(int from, int to, int value)
    {
        if (g == null)
        {
            g = new TreeMap<Integer, TreeMap<Integer, Integer>>();
        }
        if (g.containsKey(from))
        {
            TreeMap<Integer, Integer> next = g.get(from);
            if (next.containsKey(to))
            {
                next.put(to, next.get(to) + value);
            } else
            {
                next.put(to, value);
            }
        } else
        {
            TreeMap<Integer, Integer> next = new TreeMap<Integer, Integer>();
            next.put(to, value);
            g.put(from, next);
        }
    }

    public void init()
    {
        g = new TreeMap<Integer, TreeMap<Integer, Integer>>();
        /*for (int i = 0; i < 101; i++)
        {
            internalGraph.put(i, new TreeMap<Integer, Integer>());
        }*/
        maxFlow = 0;
        flow = 0;
    }

    public void maxFlow()
    {
        while (true)
        {
            flow = 0;
            dist = new TreeMap<Integer, Integer>();
            parent = new TreeMap<Integer, Integer>();

            dist.put(S, 0);
            parent.put(S, -1);

            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(S);

            while (!queue.isEmpty())
            {
                int from = queue.pollFirst();
                if (from == T)
                {
                    break;
                }
                TreeMap<Integer, Integer> next = g.get(from);
                for (Map.Entry<Integer, Integer> entry : next.entrySet())
                {
                    int to = entry.getKey();
                    int value = entry.getValue();
                    Integer d = dist.get(to);
                    if (d == null && value > 0)
                    {
                        dist.put(to, dist.get(from) + 1);
                        parent.put(to, from);
                        queue.add(to);
                    }
                }
            }
            augment(T, INF);
            if (flow == 0)
            {
                break;
            }
            maxFlow += flow;
        }
    }

    public void augment(int v, int minEdge)
    {
        if (v == S)
        {
            flow = minEdge;
            return;
        }
        Integer p = parent.get(v);
        if (p != null && p != -1)
        {
            Integer value = g.get(p).get(v);
            if (value != null)
            {
                augment(p, Math.min(minEdge, value));
            }

            value = g.get(p).get(v);
            if (value != null)
            {
                g.get(p).put(v, value - flow);
            }
            value = g.get(v).get(p);
            if (value != null)
            {
                g.get(v).put(p, value + flow);
            }
        }
    }

    public void run()
    {
        try
        {
            in = new FastScanner();
            //in = new FastScanner(".\\UVa\\InternetBandwith\\KadaneAlgorithm\\Input.in");
            //out = new PrintWriter(System.out, true);
            solve();
            //out.flush();
            //out.close();
            System.exit(0);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;

        FastScanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        FastScanner(String name)
        {
            try
            {
                br = new BufferedReader(new FileReader(new File(name)));
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        String next()
        {
            while (st == null || !st.hasMoreTokens())
            {
                try
                {
                    String line = br.readLine();
                    if (line.length() == 0)
                    {
                        return line;
                    } else
                    {
                        st = new StringTokenizer(line);
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

    }

    public static void main(String[] arg)
    {
        new Main().run();
    }
}

