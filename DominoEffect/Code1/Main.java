package UVa.DominoEffect.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by DELL on 16-Jun-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private int nodes;
    private int edges;
    private int graph[][];

    private int layer[];
    private boolean visited[];
    private int costs[];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int count = 0;
        while (true)
        {
            tokens = br.readLine().trim().split("[ ]+");
            nodes = Integer.parseInt(tokens[0]);
            edges = Integer.parseInt(tokens[1]);

            if (nodes == 0 && edges == 0)
            {
                return;
            }

            graph = new int[nodes][nodes];
            visited = new boolean[nodes];
            costs = new int[nodes];
            layer = new int[nodes];
            for (int i = 0; i < nodes; i++)
            {
                Arrays.fill(graph[i], Integer.MAX_VALUE);
            }


            while (edges-- > 0)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int from = Integer.parseInt(tokens[0]) - 1;
                int to = Integer.parseInt(tokens[1]) - 1;
                int cost = Integer.parseInt(tokens[2]);
                graph[from][to] = graph[to][from] = cost;
            }

            bfs(0);
            int lastLayer = 0;
            for (int i = 0; i < nodes; i++)
            {
                lastLayer = Math.max(lastLayer, layer[i]);
            }

            int maxCost = 0;
            for (int i = 0; i < nodes; i++)
            {
                if (layer[i] == lastLayer)
                {
                    maxCost = Math.max(costs[i], maxCost);
                }
            }

            TreeSet<Integer> result = new TreeSet<Integer>();
            for (int i = 0; i < nodes; i++)
            {
                if (costs[i] == maxCost && layer[i] == lastLayer)
                {
                    result.add(i);
                }
            }

            if (count != 0)
            {
                System.out.println();
            }
            if (result.size() >= 2)
            {
                int from = result.pollFirst();
                int to = result.pollFirst();
                double time = maxCost + graph[from][to] / 2.0;
                System.out.printf("System #%d\nThe last domino falls after %.1f seconds, between key dominoes %d and %d.", count + 1, time, from + 1, to + 1);
            } else
            {
                double time = maxCost;
                System.out.printf("System #%d\nThe last domino falls after %.1f seconds, at key domino %d.", count + 1, time, result.pollFirst() + 1);

            }
            System.out.println();
            count++;
        }
    }

    public void bfs(int start)
    {
        visited[start] = true;
        costs[start] = 0;

        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(start);

        while (!q.isEmpty())
        {
            start = q.pollFirst();
            for (int i = 0; i < nodes; i++)
            {
                if (graph[start][i] != Integer.MAX_VALUE && !visited[i])
                {
                    visited[i] = true;
                    q.add(i);
                    costs[i] = costs[start] + graph[start][i];
                    layer[i] = layer[start] + 1;
                }
            }
        }
    }
}

