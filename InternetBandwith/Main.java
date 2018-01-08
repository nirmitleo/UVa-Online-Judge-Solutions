package UVa.InternetBandwith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by DELL on 10-Oct-16.
 */
public class Main
{
    private int maxFlow;
    private int flow;
    private int start;
    private int end;
    private int nodes;
    private int edges;
    private int g[][] = new int[101][101];
    private int dist[] = new int[101];
    private int parent[] = new int[101];
    private TreeMap<Integer, Integer> nodeMapping = new TreeMap<Integer, Integer>();
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 0;
        while (!(line = br.readLine().trim()).startsWith("0"))
        {
            nodes = Integer.parseInt(line);
            g = new int[101][101];
            tokens = br.readLine().trim().split("[ ]+");
            start = Integer.parseInt(tokens[0]);
            end = Integer.parseInt(tokens[1]);
            edges = Integer.parseInt(tokens[2]);
            while (edges-- > 0)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int from = Integer.parseInt(tokens[0]);
                int to = Integer.parseInt(tokens[1]);
                int cap = Integer.parseInt(tokens[2]);
                g[from][to] += cap;
                g[to][from] = g[from][to];
            }
            maxFlow = 0;
            while (true)
            {
                flow = 0;
                LinkedList<Integer> queue = new LinkedList<Integer>();
                Arrays.fill(dist, Integer.MAX_VALUE);
                Arrays.fill(parent, -1);
                dist[start] = 0;
                queue.add(start);
                while (!queue.isEmpty())
                {
                    int u = queue.pollFirst();
                    if (u == end)
                    {
                        break;
                    }
                    for (int i = 0; i < 101; i++)
                    {
                        if (g[u][i] > 0 && dist[i] == Integer.MAX_VALUE)
                        {
                            dist[i] = dist[u] + 1;
                            parent[i] = u;
                            queue.add(i);
                        }
                    }
                }
                augment(end, Integer.MAX_VALUE);
                //System.out.println("Flow = " + flow);
                if (flow == 0)
                {
                    break;
                }
                maxFlow += flow;
            }
            test++;
            System.out.println("Network " + test);
            System.out.println("The bandwidth is " + maxFlow + ".\n");
        }
    }

    public void augment(int v, int minEdge)
    {
        if (v == start)
        {
            flow = minEdge;
        } else if (parent[v] != -1)
        {
            augment(parent[v], Math.min(minEdge, g[parent[v]][v]));
            g[parent[v]][v] -= flow;
            g[v][parent[v]] += flow;
        }
    }
}

