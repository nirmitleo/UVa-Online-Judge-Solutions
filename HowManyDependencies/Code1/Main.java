package UVa.HowManyDependencies.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 25-05-2017.
 */
public class Main
{
    private int n;
    private long[] count;
    private boolean[] was;
    private int[] deg;
    private Stack<Integer> stack;
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
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            count = new long[n];
            was = new boolean[n];
            g = new ArrayList[n];
            deg = new int[n];
            stack = new Stack<Integer>();
            for (int i = 0; i < n; i++)
            {
                g[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < n; i++)
            {
                int to = i;
                st = new StringTokenizer(in.readLine());
                int t = Integer.parseInt(st.nextToken());
                while (t-- > 0)
                {
                    int from = Integer.parseInt(st.nextToken()) - 1;
                    g[from].add(to);
                    deg[to]++;
                }
            }

            for (int i = 0; i < n; i++)
            {
                if (!was[i])
                {
                    dfs(i);
                }
            }

            while (!stack.isEmpty())
            {
                int u = stack.pop();
                count[u] = Math.max(1, count[u]);
                for (int i = 0; i < g[u].size(); i++)
                {
                    int v = g[u].get(i);
                    count[v] = Math.max(count[v], count[u] + 1);
                }
            }

            long max = 0;
            int result = -1;
            for (int i = 0; i < n; ++i)
            {
                if (max < count[i])
                {
                    max = count[i];
                    result = (i + 1);
                }
            }
            /*if (test1 == 0)
            {
                System.out.print(result);
            } else
            {
                System.out.print("\n" + result);
            }*/
            System.out.println(result);
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


