package UVa.BombsNoTheyAreMines.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;

public class BombsNoTheyAreMines
{
    private int row;
    private int col;
    private int[][] dist;
    private boolean[][] map;
    private final static int INF = Integer.MAX_VALUE;


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            row = in.nextInt();
            col = in.nextInt();

            if (row == col && row == 0)
            {
                return;
            }

            map = new boolean[row][col];
            dist = new int[row][col];
            for (int i = 0; i < row; i++)
            {
                Arrays.fill(map[i], true);
                Arrays.fill(dist[i], INF);
            }

            int N = in.nextInt();
            for (int i = 0; i < N; i++)
            {
                int r = in.nextInt();
                int M = in.nextInt();
                for (int j = 0; j < M; j++)
                {
                    int c = in.nextInt();
                    map[r][c] = false;
                }
            }

            int sx = in.nextInt();
            int sy = in.nextInt();
            Point source = new Point(sx, sy);
            source.dist = 0;

            int ex = in.nextInt();
            int ey = in.nextInt();
            Point sink = new Point(ex, ey);


            int d = bfs(source, sink);
            out.println(d);

        }
    }

    public int bfs(Point source, Point sink)
    {
        boolean[][] was = new boolean[row][col];
        Point[] q = new Point[row * col + 1];
        int qh = 1;
        int qt = 0;

        was[source.x][source.y] = true;
        q[0] = source;

        while (qt < qh)
        {
            Point U = q[qt++];
            int x = U.x;
            int y = U.y;

            if (x == sink.x && y == sink.y)
            {
                return U.dist;
            }
            if (x - 1 >= 0 && !was[x - 1][y] && map[x - 1][y])
            {
                was[x - 1][y] = true;
                q[qh++] = new Point(x - 1, y, U.dist + 1);
            }
            if (x + 1 < row && !was[x + 1][y] && map[x + 1][y])
            {
                was[x + 1][y] = true;
                q[qh++] = new Point(x + 1, y, U.dist + 1);
            }
            if (y - 1 >= 0 && !was[x][y - 1] && map[x][y - 1])
            {
                was[x][y - 1] = true;
                q[qh++] = new Point(x, y - 1, U.dist + 1);
            }
            if (y + 1 < col && !was[x][y + 1] && map[x][y + 1])
            {
                was[x][y + 1] = true;
                q[qh++] = new Point(x, y + 1, U.dist + 1);
            }


        }
        throw new RuntimeException();
    }

    class Point
    {
        int x;
        int y;
        int dist;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
