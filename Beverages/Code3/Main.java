package UVa.Beverages.Code3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by DELL on 16-Oct-16.
 */
public class Main
{
    private TreeMap<String, Integer> wineMapping;
    private int nodes;
    private boolean g[][];
    private int inDeg[];
    private boolean visited[];
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
        int test = 1;
        while (true)
        {
            String line = br.readLine();
            if (line == null || line.trim().length() == 0)
            {
                System.out.println();
                return;
            }
            nodes = Integer.parseInt(line.trim());
            g = new boolean[nodes][nodes];
            inDeg = new int[nodes];
            visited = new boolean[nodes];
            wineMapping = new TreeMap<String, Integer>();

            for (int i = 0; i < nodes; i++)
            {
                line = br.readLine().trim();
                wineMapping.put(line, i);
            }

            int edges = Integer.parseInt(br.readLine().trim());
            while (edges-- > 0)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int from = wineMapping.get(tokens[0]);
                int to = wineMapping.get(tokens[1]);
                if (!g[from][to])
                {
                    g[from][to] = true;
                    inDeg[to]++;
                }
            }

            String result = "";
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for (int i = 0; i < nodes; i++)
            {
                if (inDeg[i] == 0)
                {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty())
            {
                int u = queue.poll();
                visited[u] = true;
                result += getIndexForWine(u) + " ";
                for (int j = 0; j < nodes; j++)
                {
                    if (g[u][j])
                    {
                        inDeg[j]--;
                        if (inDeg[j] == 0)
                        {
                            queue.add(j);
                        }
                    }
                }
            }


            result = result.trim() + ".";
            if (test == 1)

            {
                System.out.println("Case #" + test + ": Dilbert should drink beverages in this order: " + result);

            } else

            {
                System.out.println("\nCase #" + test + ": Dilbert should drink beverages in this order: " + result);
            }
            test++;
            line = br.readLine();
        }

    }

    public String getIndexForWine(int index)
    {
        for (Map.Entry<String, Integer> entry : wineMapping.entrySet())
        {
            String wines = entry.getKey();
            int i = entry.getValue();
            if (i == index)
            {
                return wines;
            }
        }
        return "";
    }
}
