package UVa.LongestPath.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24-05-2017.
 */
public class Main
{

    private int n;
    private int[] depth;
    private int[] parent;
    private boolean[] was;
    private Stack<Integer> stack;
    private ArrayList<Integer>[] g;

    private String line;
    private StringTokenizer st;
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
            n = Integer.parseInt(br.readLine().trim());
            if (n == 0)
            {
                System.out.println();
                return;
            }

            depth = new int[n + 1];
            parent = new int[n + 1];
            was = new boolean[n + 1];
            g = new ArrayList[n + 1];
            stack = new Stack<Integer>();

            for (int i = 1; i <= n; i++)
            {
                parent[i] = i;
                g[i] = new ArrayList<Integer>();
            }

            int start = Integer.parseInt(br.readLine().trim());
            while (true)
            {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (from == 0 && to == 0)
                {
                    break;
                }
                g[from].add(to);
            }

            dfs(start);

            int max = 0;
            while (!stack.isEmpty())
            {
                int u = stack.pop();
                depth[u] = Math.max(depth[u], 0);
                max = Math.max(max, depth[u]);
                for (int i = 0; i < g[u].size(); i++)
                {
                    int v = g[u].get(i);
                    if (depth[u] + 1 > depth[v])
                    {
                        depth[v] = depth[u] + 1;
                        parent[v] = u;
                        max = Math.max(max, depth[v]);
                    }
                }
            }

            int end = -1;
            for (int i = 1; i <= n; i++)
            {
                if (max == depth[i])
                {
                    end = i;
                    break;
                }
            }
            if (test == 1)
            {
                System.out.println("Case " + test + ": The longest path from " + start + " has length " + max + ", finishing at " + end + ".");
            } else
            {
                System.out.print("\nCase " + test + ": The longest path from " + start + " has length " + max + ", finishing at " + end + ".");
                System.out.println();
            }
            test++;
        }


    }

    public void dfs(int u)
    {
        was[u] = true;
        for (int i = 0; i < g[u].size(); i++)
        {
            int v = g[u].get(i);
            if (!was[v])
            {
                dfs(v);
            }
        }
        stack.push(u);
    }
}

