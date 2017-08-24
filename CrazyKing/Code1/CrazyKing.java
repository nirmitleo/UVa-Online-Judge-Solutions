package UVa.CrazyKing.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.TreeSet;

public class CrazyKing
{
    private int row;
    private int col;
    private boolean[][] map;
    private int[] dx = {-1, -1, 0, +1, +1, +1, 0, -1};
    private int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            row = in.nextInt();
            col = in.nextInt();
            map = new boolean[row][col];

            Point source = null;
            Point sink = null;
            TreeSet<Point> horse = new TreeSet<>();
            for (int i = 0; i < row; i++)
            {
                char[] a = in.next().toCharArray();
                for (int j = 0; j < col; j++)
                {
                    switch (a[j])
                    {
                        case 'A':
                            source = new Point(i, j);
                            map[i][j] = true;
                            break;
                        case 'B':
                            sink = new Point(i, j);
                            map[i][j] = true;
                            break;
                        case '.':
                            map[i][j] = true;
                            break;
                        case 'Z':
                            horse.add(new Point(i, j));
                            break;
                    }
                }
            }
            while (!horse.isEmpty())
            {
                Point p = horse.pollFirst();
                if (p.compareTo(source) == 0 || p.compareTo(sink) == 0)
                {
                    continue;
                }
                int x = p.x;
                int y = p.y;
                for (int i = -2; i <= 2; i++)
                {
                    for (int j = -2; j <= 2; j++)
                    {
                        if (Math.abs(i * j) == 2)
                        {
                            int x1 = x + i;
                            int y1 = y + j;
                            Point q = new Point(x1, y1);
                            if (q.compareTo(source) == 0 || q.compareTo(sink) == 0)
                            {
                                continue;
                            }
                            if (isValid(x1, row) && isValid(y1, col))
                            {
                                map[x1][y1] = false;
                            }
                        }
                    }
                }
            }
            int dist = bfs(source, sink);
            if (dist < 0)
            {
                out.print("King Peter, you can't go now!\n");
            } else
            {
                out.print("Minimal possible length of a trip is " + dist + "\n");
            }
        }
    }

    public int bfs(Point source, Point sink)
    {
        Point[] q = new Point[row * col + 5];
        int qh = 1;
        int qt = 0;

        TreeSet<Point> was = new TreeSet<>();
        q[0] = source;
        was.add(source);

        while (qt < qh)
        {
            Point U = q[qt++];
            if (U.compareTo(sink) == 0)
            {
                return U.dist;
            }
            for (int i = 0; i < dx.length; i++)
            {
                int x = U.x + dx[i];
                int y = U.y + dy[i];
                if (isValid(x, row) && isValid(y, col) && map[x][y])
                {
                    Point V = new Point(x, y);
                    if (!was.contains(V))
                    {
                        V.dist = U.dist + 1;
                        was.add(V);
                        q[qh++] = V;
                        if (V.compareTo(sink) == 0)
                        {
                            return V.dist;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public boolean isValid(int h, int H)
    {
        return h >= 0 && h < H;
    }

    class Point implements Comparable<Point>
    {
        int x;
        int y;
        int dist;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point that)
        {
            int xDiff = Integer.compare(this.x, that.x);
            return xDiff != 0 ? xDiff : Integer.compare(this.y, that.y);
        }
    }
}
