package UVa.LiftlessEME.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24-05-2017.
 */
public class Main
{
    private int n;
    private int hole;
    private int floor;
    private int[] dp;
    private int[] time;
    private boolean[] was;

    private Stack<Integer> stack;
    private ArrayList<Vertex>[] g;


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
        while (true)
        {
            line = br.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }

            String name = line;
            st = new StringTokenizer(br.readLine());
            floor = Integer.parseInt(st.nextToken());
            hole = Integer.parseInt(st.nextToken());

            n = floor * hole;
            dp = new int[n];
            time = new int[n];
            was = new boolean[n];
            g = new ArrayList[n];
            stack = new Stack<Integer>();

            for (int i = 0; i < n; i++)
            {
                g[i] = new ArrayList<Vertex>();
            }

            int base = 0;
            for (int i = 0, from = 0; i < hole * (floor - 1); i++, from++)
            {
                //System.out.print("From = " + from + ": ");
                base = (i / hole) * hole;
                st = new StringTokenizer(br.readLine());
                for (int j = 0, to = base + hole; j < hole; j++, to++)
                {
                    int t = Integer.parseInt(st.nextToken());
                    g[from].add(new Vertex(to, t));
                   //System.out.print(to + " ");
                }
                //System.out.println();
            }

            for (int i = 0; i < hole; i++)
            {
                dfs(i);
            }
            Arrays.fill(dp, Integer.MAX_VALUE);
            while (!stack.isEmpty())
            {
                int u = stack.pop();
                if (dp[u] == Integer.MAX_VALUE)
                {
                    dp[u] = 0;
                }
                for (int i = 0; i < g[u].size(); i++)
                {
                    Vertex vv = g[u].get(i);
                    if (dp[u] + vv.value + 2 < dp[vv.id])
                    {
                        dp[vv.id] = dp[u] + vv.value + 2;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = n - hole; i < n; i++)
            {
                min = Math.min(min, dp[i]);
            }
            System.out.println(name);
            System.out.println(min);

        }

    }

    public void dfs(int u)
    {
        was[u] = true;
        for (int i = 0; i < g[u].size(); i++)
        {
            Vertex v = g[u].get(i);
            if (!was[v.id])
            {
                dfs(v.id);
            }
        }
        stack.push(u);
    }

    class Vertex
    {
        int id;
        int value;

        public Vertex(int id, int value)
        {
            this.id = id;
            this.value = value;
        }
    }
}

