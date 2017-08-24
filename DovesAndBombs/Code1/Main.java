package UVa.DovesAndBombs.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nirmit on 19-05-2017.
 */
public class Main
{
    private int V;
    private int time;
    private int[] dfsNum;
    private int[] dfsLow;
    private int[] dfsParent;
    private int[] count;
    private int root;
    private int rootChild;
    private boolean[] articulationVertex;
    private final static int UNVISITED = -1;
    private TreeMap<Integer, ArrayList<Integer>> g;

    private String line;
    private String tokens[];
    private StringTokenizer st;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while (true)
        {
            line = br.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);

            V = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (V == 0 && m == 0)
            {
                return;
            }

            time = 0;
            g = new TreeMap<Integer, ArrayList<Integer>>();
            for (int i = 0; i < V; i++)
            {
                g.put(i, new ArrayList<Integer>());
            }

            dfsNum = new int[V];
            dfsLow = new int[V];
            dfsParent = new int[V];
            count = new int[V];
            articulationVertex = new boolean[V];
            Arrays.fill(dfsNum, -1);

            while (true)
            {
                line = br.readLine();
                st = new StringTokenizer(line);
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (from == -1 && to == -1)
                {
                    break;
                }
                g.get(from).add(to);
                g.get(to).add(from);
            }

            for (int i = 0; i < V; i++)
            {
                root = i;
                rootChild = 0;
                dfs(i);
                articulationVertex[rootChild] = rootChild > 1;
            }

            TreeSet<Pair> result = new TreeSet<Pair>();
            for (int i = 0; i < V; i++)
            {
                result.add(new Pair(i, count[i]));
            }

            while (!result.isEmpty() && m-- > 0)
            {
                Pair p = result.pollFirst();
                System.out.println(p.node + " " + p.value);
            }
            System.out.println();
        }
    }

    public void dfs(int u)
    {
        dfsNum[u] = dfsLow[u] = time++;
        ArrayList<Integer> next = g.get(u);
        for (int i = 0; i < next.size(); i++)
        {
            int v = next.get(i);
            if (dfsNum[v] == UNVISITED)
            {
                dfsParent[v] = u;
                dfs(v);
                if (u == root)
                {
                    rootChild++;
                }
                if (dfsNum[u] <= dfsLow[v])
                {
                    articulationVertex[u] = true;
                    count[u]++;
                }
                dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
            } else if (v != dfsParent[u])
            {
                dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);
            }
        }
    }

    class Pair implements Comparable<Pair>
    {
        int node;
        int value;

        public Pair(int node, int value)
        {
            this.node = node;
            this.value = value;
        }

        public int compareTo(Pair that)
        {
            int valueDiff = Integer.compare(that.value, this.value);
            return valueDiff != 0 ? valueDiff : Integer.compare(this.node, that.node);
        }
    }
}

