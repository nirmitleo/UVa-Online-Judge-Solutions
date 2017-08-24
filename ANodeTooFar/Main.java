package UVa.ANodeTooFar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 13-Feb-16.
 */
public class Main
{
    int n;
    int layer[];
    int queue[];
    boolean a[][];
    TreeMap<Integer, String> edges;
    TreeMap<String, Integer> nodes;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 0;
        while (true)
        {
            String l = br.readLine();
            if (l.trim().equals(""))
            {
                continue;
            }
            int edge = Integer.parseInt(l);
            if (edge == 0)
            {
                break;
            }
            int e = 0;
            int index = 0;
            int index2 = 0;
            nodes = new TreeMap<String, Integer>();
            edges = new TreeMap<Integer, String>();
            while (e != edge)
            {
                String tokens[] = br.readLine().split("[^0-9]+");
                for (int i = 0; i < tokens.length; i += 2, e++)
                {
                    if (nodes.get(tokens[i]) == null)
                    {
                        nodes.put(tokens[i], index++);
                    }
                    if (nodes.get(tokens[i + 1]) == null)
                    {
                        nodes.put(tokens[i + 1], index++);
                    }
                    edges.put(index2++, tokens[i] + " " + tokens[i + 1]);
                }
            }
            n = nodes.size();
            a = new boolean[n][n];
            for (Map.Entry<Integer, String> entry : edges.entrySet())
            {
                String tokens[] = entry.getValue().split(" ");
                int from = nodes.get(tokens[0]);
                int to = nodes.get(tokens[1]);
                a[to][from] = a[from][to] = true;
            }
            String line = "";
            while (true)
            {
                line = br.readLine();
                if (line.trim().length() == 0)
                {
                    break;
                }
                if (line.length() == 1 && line.charAt(0) == '0')
                {
                    System.exit(0);
                }
                String tokens[] = line.split("[^0-9]+");
                boolean isFinished = false;
                for (int i = 0; i < tokens.length; i += 2)
                {
                    Integer from = nodes.get(tokens[i]);
                    int max = Integer.parseInt(tokens[i + 1]);
                    if ((tokens[i].charAt(0) == '0') && max == 0)
                    {
                        isFinished = true;
                        break;
                    }
                    int count = from == null ? n : bfs(from, max + 1);
                    if (from == null)
                    {
                        System.out.println("Case " + (++test) + ": " + count + " nodes not reachable from node " + tokens[i] + " with TTL = " + max + ".");
                    }
                    else
                    {
                        System.out.println("Case " + (++test) + ": " + count + " nodes not reachable from node " + tokens[i] + " with TTL = " + max + ".");
                    }
                }
                if (isFinished)
                {
                    break;
                }
            }

        }
    }


    public int bfs(int start, int max)
    {
        int count = 1;
        int front = -1;
        int rear = -1;
        layer = new int[n];
        queue = new int[n];
        layer[start]++;
        queue[++rear] = start;
        while (start >= 0 && start < layer.length && front != rear)
        {
            start = queue[++front];
            for (int i = 0; i < n; i++)
            {
                if (i != start && a[start][i] && layer[i] == 0)
                {
                    if (layer[start] >= max)
                    {
                        return n - count;
                    }
                    count++;
                    queue[++rear] = i;
                    layer[i] = layer[start] + 1;
                }
            }
        }
        return n - count;
    }
}
