package UVa.Minefield.Code1;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.io.StringWriter;
import java.util.*;

public class MinefieldTestCase
{
    private Random r = new Random();

    @TestCase
    public Collection<Test> createTests()
    {
        int T = 0;
        ArrayList<Test> tests = new ArrayList<>();
        StringWriter sw = new StringWriter();
        StringWriter result = new StringWriter();
        for (int t = 1; t <= T; t++)
        {
            int w = getInteger(2, 5);
            int h = getInteger(2, 5);
            int n = getInteger(2, 10);
            sw.append(w + " " + h + "\n");
            sw.append(n + "\n");
            double[] xx = new double[n];
            double[] yy = new double[n];
            for (int i = 0; i < n; i++)
            {
                double x = getDouble(0, w);
                double y = getDouble(0, h);
                sw.append(x + " " + y + "\n");
                xx[i] = x;
                yy[i] = y;
            }
            double d = getDouble(0, ((int) (Math.max(w, h) * 5.5)));
            sw.append(d + "\n");
            result.append(slow(w, h, n, xx, yy, d));
        }
        if (T > 0)
        {
            sw.append("*\n");
            tests.add(new Test(sw.toString(), result.toString()));
        }
        return tests;
    }

    public int getInteger(int min, int max)
    {
        return r.nextInt(max - min + 1) + min;
    }

    public double getDouble(int min, int max)
    {
        min = 100 * min;
        max = 100 * max;
        int num = r.nextInt(max - min + 1) + min;
        return Double.parseDouble(String.format("%.2f", (num / 100.0)));
    }


    static final int INF = 1000000000;
    static ArrayList<Pair>[] adjList;
    static double d;
    static int N;
    static double[][] pos;

    static boolean dijkstra()
    {
        double[] dist = new double[N];
        Arrays.fill(dist, INF);
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        dist[0] = 0;
        q.add(new Pair(0, 0));
        while (!q.isEmpty())
        {
            Pair cur = q.remove();
            if (cur.distance > dist[cur.point])
                continue;
            for (int i = 0, size = adjList[cur.point].size(); i < size; i++)
            {
                Pair v = adjList[cur.point].get(i);
                double totalDist = cur.distance + v.distance;
                if (totalDist < dist[v.point])
                {
                    dist[v.point] = totalDist;
                    q.add(new Pair(v.point, dist[v.point]));
                }
            }
        }
        if (dist[1] < d || Math.abs(dist[1] - d) < 10e-7)
            return true;
        return false;
    }

    public String slow(int w, int h, int n, double[] xx, double[] yy, double dd)
    {
        N = n;
        d = dd;
        pos = new double[N][2];
        pos[1][0] = w;
        pos[1][1] = h;
        for (int i = 2; i < N; i++)
        {
            pos[i][0] = xx[i - 2];
            pos[i][1] = yy[i - 2];
        }
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adjList[i] = new ArrayList<Pair>();
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
            {
                double a = pos[i][0] - pos[j][0];
                double b = pos[i][1] - pos[j][1];
                double x = Math.sqrt(a * a + b * b);
                if (x < 1.5 || Math.abs(x - 1.5) < 10e-7)
                {
                    adjList[i].add(new Pair(j, x));
                    adjList[j].add(new Pair(i, x));
                }
            }
        if (dijkstra())
            return "I am lucky!\n";
        else
            return "Boom!\n";
    }
}

class Pair implements Comparable<Pair>
{
    int point;
    double distance;

    Pair(int x, double y)
    {
        point = x;
        distance = y;
    }

    @Override
    public int compareTo(Pair o)
    {
        return this.distance - o.distance < 0 ? -1 : 1;
    }
}
