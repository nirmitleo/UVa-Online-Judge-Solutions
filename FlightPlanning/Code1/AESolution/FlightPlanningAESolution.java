package UVa.FlightPlanning.Code1.AESolution;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;
import Spark.GraphUtils.Graphs.IntegerGraph;

import java.util.ArrayList;

public class FlightPlanningAESolution
{
    private int V;
    private IntegerGraph g;
    private int minDiameter;
    private int uOld;
    private int vOld;
    private int uNew;
    private int vNew;

    private int[][] down;
    private int[][] up;

    private int[][] downX;
    private int[] upX;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            V = in.nextInt();
            g = new IntegerGraph(V, 0);
            for (int i = 0; i < V - 1; i++)
            {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                g.addEdge(from, to, true);
            }

            go();
        }
    }

    private void go()
    {
        down = new int[V][3];
        up = new int[V][3];

        downX = new int[V][2];
        upX = new int[V];

        minDiameter = V;
        dfs1(0, -1);
    }

    private void swap(int[][] x, int u, int i, int j)
    {
        int temp = x[u][i];
        x[u][i] = x[u][j];
        x[u][j] = temp;
    }

    private void dfs1(int u, int prev)
    {
        ArrayList<Integer> next = g.internalGraph[u];
        for (int i = 0; i < next.size(); i++)
        {
            int v = next.get(i);
            if (v == prev)
            {
                continue;
            }
            dfs1(v, u);

            if (down[v][0] + 1 > down[u][2])
            {
                down[u][2] = down[v][0] + 1;
                if (down[u][2] > down[u][1])
                {
                    swap(down, u, 1, 2);
                }
                if (down[u][1] > down[u][0])
                {
                    swap(down, u, 0, 1);
                }
            }

            int x = Math.max(downX[v][0], down[v][0] + down[v][1]);
            if (x > downX[u][1])
            {
                downX[u][1] = x;
                if (downX[u][1] > downX[u][0])
                {
                    swap(downX, u, 0, 1);
                }
            }
        }
    }
}
