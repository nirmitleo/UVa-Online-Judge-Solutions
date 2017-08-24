package UVa.ChineseCheckers.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.TreeSet;

public class ChineseCheckers
{
    private int row;
    private int col;
    private boolean[][] map;
    private TreeSet<Point> set;
    private int[] dx = {0, 2, 2, 2, 0};
    private int[] dy = {2, 2, 0, -2, -2};
    private int[] ddx = {0, 1, 1, 1, 0};
    private int[] ddy = {1, 1, 0, -1, -1};


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (int t = 1; ; t++)
        {
            String s = in.next();
            if (s == null)
            {
                return;
            }
            row = Integer.parseInt(s);
            col = in.nextInt();
            map = new boolean[row][col];
//            out.println("row = " + row + " col = " + col);

            for (int i = 0; i < 4 * col; i++)
            {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                map[x][y] = true;
            }

            int sx = in.nextInt() - 1;
            int sy = in.nextInt() - 1;
            Point source = new Point(sx, sy, 0);
//            out.println("sx  = " + (sx + 1) + " sy = " + (sy + 1));
            bfs(source);
            StringBuilder sb = new StringBuilder("");
            while (!set.isEmpty())
            {
                sb.append(set.pollFirst() + "\n");
            }
            if (t == 1)
            {
                out.print(sb);
            } else
            {
                out.print("\n" + sb);
            }
        }
    }

    public void bfs(Point source)
    {
        Point[] q = new Point[row * col + 10];
        int qh = 1;
        int qt = 0;
        set = new TreeSet<>();
        boolean[][] was = new boolean[row][col];

        was[source.x][source.y] = true;
        q[0] = source;

        int x = source.x;
        int y = source.y;
        if (x + 1 < row && !map[x + 1][y])
        {
            set.add(new Point(x + 1, y, 1));
        }
        if (y + 1 < col && !map[x][y + 1])
        {
            set.add(new Point(x, y + 1, 1));
        }
        if (y - 1 >= 0 && !map[x][y - 1])
        {
            set.add(new Point(x, y - 1, 1));
        }

        while (qt < qh)
        {
            Point U = q[qt++];
            for (int i = 0; i < dx.length; i++)
            {
                x = U.x;
                y = U.y;
                if (isValid(x + dx[i], row) && isValid(y + dy[i], col))
                {
                    if (map[x + ddx[i]][y + ddy[i]] && !map[x + dx[i]][y + dy[i]] && !was[x + dx[i]][y + dy[i]])
                    {
                        Point p = new Point(x + dx[i], y + dy[i], U.dist + 1);
                        was[p.x][p.y] = true;
                        q[qh++] = p;
                        set.add(p);
                    }
                }
            }
        }
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

        public Point(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Point that)
        {
            int xDiff = Integer.compare(that.x, this.x);
            return xDiff != 0 ? xDiff : Integer.compare(this.y, that.y);
        }

        public String toString()
        {
            return (x + 1) + " " + (y + 1) + " " + dist;
        }
    }
}
