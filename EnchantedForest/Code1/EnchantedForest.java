package UVa.EnchantedForest.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.HashSet;

public class EnchantedForest
{
    private int row;
    private int col;
    private boolean[][] map;
    private final static int INF = Integer.MAX_VALUE;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            row = in.nextInt();
            col = in.nextInt();
            if (row + col == 0 && row == 0)
            {
                return;
            }

            map = new boolean[row][col];

            int B = in.nextInt();
            for (int i = 0; i < B; i++)
            {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                map[x][y] = true;
            }

            int J = in.nextInt();
            for (int i = 0; i < J; i++)
            {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                int L = in.nextInt();
                for (int x1 = x - L; x1 <= x + L; x1++)
                {
                    for (int y1 = y - L; y1 <= y + L; y1++)
                    {
                        if (isValid(x1, row) && isValid(y1, col))
                        {
                            int d1 = dist(x1, y1, x, y);
                            if (d1 <= L * L)
                            {
                                map[x1][y1] = true;
                            }
                        }
                    }
                }
            }
            Point source = new Point(0, 0, 0);
            Point sink = new Point(row - 1, col - 1);
            int dist = bfs(source, sink);
            if (dist < 0)
            {
                out.println("Impossible.");
            } else
            {
                out.println(dist);
            }
        }
    }

    public int bfs(Point source, Point sink)
    {
        Point[] q = new Point[row * col + 10];
        int qh = 1;
        int qt = 0;

        HashSet<Point> was = new HashSet<>();

        q[0] = source;
        was.add(source);

        while (qt < qh)
        {
            Point U = q[qt++];
            if (U.equals(sink))
            {
                return U.dist;
            }
            int x = U.x;
            int y = U.y;
            for (int dx = -1; dx <= 1; dx++)
            {
                for (int dy = -1; dy <= 1; dy++)
                {
                    if (Math.abs(dx * dy) == 0)
                    {
                        Point p = new Point(x + dx, y + dy, U.dist + 1);
                        if (p.equals(sink))
                        {
                            return p.dist;
                        }
                        if (isValid(p.x, row) && isValid(p.y, col) && !map[p.x][p.y] && !was.contains(p))
                        {
                            q[qh++] = p;
                            was.add(p);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int dist(int x1, int y1, int x2, int y2)
    {
        return sq(x1 - x2) + sq(y1 - y2);
    }

    public int sq(int x)
    {
        return x * x;
    }

    public boolean isValid(int x, int X)
    {
        return x >= 0 && x < X;
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

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode()
        {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
