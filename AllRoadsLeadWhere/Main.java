package UVa.AllRoadsLeadWhere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 16-Feb-16.
 */
public class Main
{

    int index = 0;
    int previous[];
    int queue[];
    boolean a[][];
    boolean visited[];
    TreeMap<Character, Integer> nodes;
    String edges[];
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ra[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++)
        {
            br.readLine();
            tokens = br.readLine().split(" ");
            int e = Integer.parseInt(tokens[0]);
            int q = Integer.parseInt(tokens[1]);
            index = 0;
            edges = new String[e];
            nodes = new TreeMap<Character, Integer>();
            for (int i = 0; i < edges.length; i++)
            {
                tokens = br.readLine().split(" ");
                char from = tokens[0].charAt(0);
                char to = tokens[1].charAt(0);
                //System.out.println("From = " + from + " To = " + to);
                putMap(from);
                putMap(to);
                edges[i] = from + " " + to;
            }
            a = new boolean[nodes.size()][nodes.size()];
            for (int i = 0; i < edges.length; i++)
            {
                tokens = edges[i].split(" ");
                int from = nodes.get(tokens[0].charAt(0));
                int to = nodes.get(tokens[1].charAt(0));
                a[from][to] = a[to][from] = true;
            }

            for (int i = 0; i < q; i++)
            {
                tokens = br.readLine().split(" ");
                int from = nodes.get(tokens[0].charAt(0));
                int to = nodes.get(tokens[1].charAt(0));
                bfs(from, to);
                if (t == 1 && i == 0)
                {
                    System.out.print(printPath(from, to));
                }
                else
                {
                    System.out.print("\n" + printPath(from, to));
                }
            }
            System.out.println();
        }
    }

    public String printPath(int from, int to)
    {
        int p = to;
        String path = "";
        while (p != from)
        {
            path = getKey(p) + path;
            p = previous[p];
        }
        return getKey(from) + path;
    }

    public char getKey(int value)
    {
        for (Map.Entry<Character, Integer> entry : nodes.entrySet())
        {
            if (entry.getValue() == value)
            {
                return entry.getKey();
            }
        }
        return '\u0000';
    }

    public void putMap(char ch)
    {
        if (nodes.get(ch) == null)
        {
            nodes.put(ch, index++);
        }
    }

    public void bfs(int start, int end)
    {
        queue = new int[nodes.size()];
        visited = new boolean[nodes.size()];
        previous = new int[nodes.size()];
        for (int i = 0; i < previous.length; i++)
        {
            previous[i] = i;
        }
        int front = -1;
        int rear = -1;
        queue[++rear] = start;
        visited[start] = true;
        while (rear != front)
        {
            start = queue[++front];
            for (int i = 0; i < visited.length; i++)
            {
                if (i != start && a[start][i] && !visited[i])
                {
                    previous[i] = (previous[i] == i) ? start : previous[i];
                    queue[++rear] = i;
                    visited[i] = true;
                    if (i == end)
                    {
                        return;
                    }
                }
            }
        }

    }
}
