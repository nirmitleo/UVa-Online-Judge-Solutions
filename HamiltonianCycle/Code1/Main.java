package UVa.HamiltonianCycle.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/06/2017.
 */
public class Main
{
    private int V;
    private ArrayList<Integer>[] g;
    private boolean[] was;


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
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            V = Integer.parseInt(st.nextToken());
            g = createGraph(V);
            was = new boolean[V + 1];
            for (; ; )
            {
                st = new StringTokenizer(in.readLine());
                String s = st.nextToken();
                if (s.contains("%"))
                {
                    break;
                }
                int from = Integer.parseInt(s);
                int to = Integer.parseInt(st.nextToken());
                g[from].add(to);
                g[to].add(from);
            }
//            bfs(1);


        }

    }


    public ArrayList<Integer>[] createGraph(int V)
    {
        ArrayList<Integer>[] g = new ArrayList[V];
        for (int i = 1; i <= V; i++)
        {
            g[i] = new ArrayList<Integer>();
        }
        return g;
    }
}
