package UVa.PickUpSticks.Code3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by DELL on 16-Oct-16.
 */
public class Main
{
    private int index = 0;
    private int edges;
    private int nodes;
    private boolean g[][];
    private int inDeg[];

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
        while (true)
        {
            index = 0;
            line = br.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            tokens = line.trim().split("[ ]+");
            nodes = Integer.parseInt(tokens[0]);
            edges = Integer.parseInt(tokens[1]);
            if (nodes == 0 && edges == 0)
            {
                return;
            }
            g = new boolean[nodes + 10][nodes + 10];
            inDeg = new int[nodes + 10];
            while (edges-- > 0)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int from = Integer.parseInt(tokens[0]);
                int to = Integer.parseInt(tokens[1]);
                if (!g[from][to])
                {
                    g[from][to] = true;
                    inDeg[to]++;
                }
            }

            LinkedList<Integer> queue = new LinkedList<Integer>();
            for (int i = 1; i < nodes; i++)
            {
                if (inDeg[i] == 0)
                {
                    queue.add(i);
                }
            }

            String result = "";
            while (!queue.isEmpty())
            {
                int u = queue.pollFirst();
                result += u + "\n";
                for (int i = 0; i < nodes; i++)
                {
                    if (g[u][i])
                    {
                        inDeg[i]--;
                        if (inDeg[i] == 0)
                        {
                            queue.add(i);
                        }
                    }
                }
            }
            for (int i = 1; i < inDeg.length; i++)
            {
                if (inDeg[i] != 0)
                {
                    System.out.println("Indeg = " + inDeg[i]);
                    result = "IMPOSSIBLE\n";
                    break;
                }
            }
            System.out.print(result);
        }

    }

}


