package UVa.GettingInLine.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 07/06/2017.
 */
public class Main
{
    private final static int MAX = (int) 1e9;
    private int n;
    private double[][] dist;
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
        for (int t = 1; true; t++)
        {
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
//            int[][] dist = new int[n][n];
//            for (int i = 0; i < n; i++)
//            {
//                st = new StringTokenizer(in.readLine());
//                for (int j = 0; j < n; j++)
//                {
//                    dist[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
            Pair[] a = new Pair[n];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[i] = new Pair(x, y);
            }

            Arrays.sort(a);
            dist = new double[n][n];

            for (int i = 0; i < n; i++)
            {
                Pair u = a[i];
                for (int j = i + 1; j < n; j++)
                {
                    Pair v = a[j];
                    dist[i][j] = dist(u.x, u.y, v.x, v.y) + 16;
                    dist[j][i] = dist[i][j];
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    System.out.print(dist[i][j] + " ");
                }
                System.out.println();
            }

            double[][] dp = new double[n][1 << n];
            int[][] now = new int[n][1 << n];
            int[][] prev = new int[n][1 << n];
            for (int i = 0; i < n; i++)
            {
                Arrays.fill(dp[i], MAX);
            }


            dp[0][1] = 0;
            now[0][1] = 0;
            prev[0][1] = -1;
            for (int i = 0; i < n - 1; i++)
            {
                for (int j = 0; j < (1 << n); j++)
                {
                    if (dp[i][j] != MAX)
                    {
                        for (int k = 0; k < n; k++)
                        {
                            if (now[i][j] != k && (j & (1 << k)) == 0)
                            {
                                if (dp[i + 1][j | (1 << k)] > dp[i][j] + dist[now[i][j]][k])
                                {
                                    dp[i + 1][j | (1 << k)] = dp[i][j] + dist[now[i][j]][k];
                                    now[i + 1][j | (1 << k)] = k;
                                    prev[i + 1][j | (1 << k)] = now[i][j];
                                }
                            }
                        }
                    }
                }
            }
            double best = dp[n - 1][(1 << n) - 1];
            String result = "";
            for (int i = n - 1, j = (1 << n) - 1; i >= 0 && j >= 0; )
            {
                int u = prev[i][j];
                int v = now[i][j];
                result = "Cable requirement to connect (" + a[u].x + "," + a[u].y + ") to (" + a[v].x + "," + a[v].y + ") is " + dist[u][v] + " feet.\n" + result;
                j = (j & (~(1 << u)));
                i = i - 1;
            }

            System.out.println(result);
            System.out.println(best);

            System.out.println("*************");
            best = go(0, 1);
            System.out.println(best);

        }

    }

    public double go(int pos, int was)
    {
        if (was == (1 << n) - 1)
        {
            return 0;
        }
        double d = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            if ((was & (1 << i)) == 0)
            {
                d = Math.min(d, dist[pos][i] + go(i, was | (1 << i)));
            }
        }
        return d;
    }

    public double dist(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }

    class Pair implements Comparable<Pair>
    {
        int x;
        int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair that)
        {
            int xDiff = Integer.compare(this.x, that.x);
            return xDiff != 0 ? xDiff : Integer.compare(this.y, that.y);
        }
    }
}
