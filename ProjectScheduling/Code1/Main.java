package UVa.ProjectScheduling.Code1;

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

    private int n = 26;
    private int[] deg;
    private int[] time;
    private int[] depth;
    private int[] parent;
    private boolean[] was;
    private boolean[] isPresent;
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
        int test = Integer.parseInt(br.readLine());
        line = br.readLine();
        for (int t = 1; t <= test; t++)
        {
            time = new int[n];
            depth = new int[n];
            was = new boolean[n];
            deg = new int[n];
            parent = new int[n];
            g = new ArrayList[n];
            isPresent = new boolean[n];
            stack = new Stack<Integer>();

            for (int i = 0; i < n; i++)
            {
                parent[i] = i;
                g[i] = new ArrayList<Integer>();
            }

            while (true)
            {
                line = br.readLine();
                if (line == null || line.trim().length() == 0)
                {
                    break;
                }

                st = new StringTokenizer(line);
                int to = st.nextToken().charAt(0) - 'A';
                time[to] = Integer.parseInt(st.nextToken());
                isPresent[to] = true;

                if (st.hasMoreTokens())
                {
                    String s = st.nextToken();
                    for (int i = 0; i < s.length(); i++)
                    {
                        int from = s.charAt(i) - 'A';
                        isPresent[from] = true;
                        g[from].add(to);
                        deg[to]++;
                    }
                }
            }

            /*for (int i = 0; i < n; i++)
            {
                if (internalGraph[i].size() > 0)
                {
                    System.out.print(((char) (i + 'A')) + ": ");
                    for (int j = 0; j < internalGraph[i].size(); j++)
                    {
                        System.out.print(((char) (internalGraph[i].get(j) + 'A')) + " ");
                    }
                    System.out.println();
                }
            }*/

            //System.out.println("deg[] = " + Arrays.toString(deg));
            for (int i = 0; i < n; i++)
            {
                if (deg[i] == 0 && !was[i] && isPresent[i])
                {
                    dfs(i);
                }
            }

            int max = 0;
            while (!stack.isEmpty())
            {
                int u = stack.pop();
                //System.out.println(u);
                if (deg[u] == 0)
                {
                    depth[u] = Math.max(depth[u], time[u]);
                    max = Math.max(max, depth[u]);
                }
                for (int i = 0; i < g[u].size(); i++)
                {
                    int v = g[u].get(i);
                    if (depth[v] < depth[u] + time[v])
                    {
                        depth[v] = depth[u] + time[v];
                        max = Math.max(max, depth[v]);
                    }
                }
            }
            if (t == 1)
            {
                System.out.println(max);
            } else
            {
                System.out.println("\n" + max);
            }
        }
    }


    public void dfs(int u)
    {
        was[u] = true;
        //System.out.print(u + " -> ");
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

