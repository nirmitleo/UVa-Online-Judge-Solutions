package UVa.ManyPathsOneDestination.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 25-05-2017.
 */
public class Main
{
    private int n;
    private long[] dp;
    private boolean[] was;
    private Stack<Integer> stack;
    private TreeSet<Integer> death;
    private ArrayList<Integer>[] g;


    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

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
            line = in.readLine();
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            was = new boolean[n + 1];
            dp = new long[n + 1];
            g = new ArrayList[n + 1];
            stack = new Stack<Integer>();
            for (int i = 0; i < n + 1; i++)
            {
                g[i] = new ArrayList<Integer>();
            }

            death = new TreeSet<Integer>();
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int mm = Integer.parseInt(st.nextToken());
                if (mm == 0)
                {
                    death.add(i);
                } else
                {
                    for (int j = 0; j < mm; j++)
                    {
                        int to = Integer.parseInt(st.nextToken());
                        g[i].add(to);
                    }
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < g[i].size(); j++)
                {
                    int v = g[i].get(j);
                    if (death.contains(v))
                    {
                        g[i].remove(j);
                        g[i].add(n);
                    }
                }
            }

            dfs(0);

            while (!stack.isEmpty())
            {
                int u = stack.pop();
                dp[u] = Math.max(1, dp[u]);
                for (int i = 0; i < g[u].size(); i++)
                {
                    int v = g[u].get(i);
                    dp[v] += dp[u];
                }
            }
            if (test == 0)
            {
                System.out.println(dp[n]);
            } else
            {
                System.out.println("\n" + dp[n]);
            }
            line = in.readLine();
            if (line == null)
            {
                return;
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

