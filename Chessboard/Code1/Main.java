package UVa.Chessboard.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 01/07/2017.
 */
public class Main
{
    private double result;
    private String path;
    private int n;
    private int bestS;
    private int bestD;
    public boolean[][] map;

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
        //demo.test1();
    }

    public void test()
    {
        for (int i = 2; i <= 7; i++)
        {
            n = i;
            result = 0;
            path = "";
            map = new boolean[n][n];
            map[0][0] = true;
            bestS = 0;
            bestD = 0;
            solve(0, 0, n * n, 0, 0, "(0, 0) -> ");
            System.out.println("For n = " + i);
            System.out.println(result);
            System.out.println(bestS + " " + bestD);
            System.out.println(path);
        }
    }

    public void solve(int x, int y, int left, int s, int d, String p)
    {
        if (left == 1)
        {
            if (x == 1 && y == 1)
            {
                d++;
                //System.out.println(s + " " + d);
                double dist = s + Math.sqrt(2) * d;
                if (result < dist)
                {
                    bestS = s;
                    bestD = d;
                    result = dist;
                    path = p;
                }

            } else if (x + y == 1)
            {
                s++;
                double dist = s + Math.sqrt(2) * d;
                if (result < dist)
                {
                    bestS = s;
                    bestD = d;
                    result = dist;
                    path = p;
                }
            }
        } else
        {
            for (int dx = -1; dx <= 1; dx++)
            {
                for (int dy = -1; dy <= 1; dy++)
                {
                    if (check(x + dx, y + dy) && !map[x + dx][y + dy] && !(map[x][y + dy] && map[x + dx][y]))
                    {
                        map[x + dx][y + dy] = true;
                        if (x + dx != x && y + dy != y)
                        {
                            solve(x + dx, y + dy, left - 1, s, d + 1, p + " (" + (x + dx) + ", " + (y + dy) + ") -D> ");
                        } else
                        {
                            solve(x + dx, y + dy, left - 1, s + 1, d, p + " (" + (x + dx) + ", " + (y + dy) + ") -S> ");
                        }
                        map[x + dx][y + dy] = false;
                    }
                }
            }
        }
    }

    public boolean check(int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < n;
    }


    public void solve() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            in.readLine();
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            double result = 0;
            if (n > 1)
            {
                long S = 4 * (n - 1);
                long D = (n - 2) * (n - 2);
                result = S + Math.sqrt(2) * D;
            }
            if (t == 1)
            {
                System.out.println(String.format("%.3f", result));
            } else
            {
                System.out.println();
                System.out.println(String.format("%.3f", result));
            }
        }
    }

}
