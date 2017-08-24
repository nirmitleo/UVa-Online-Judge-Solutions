package UVa.BasicWallMaze.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.HashSet;

public class BasicWallMaze
{
    private int N = 6;
    private int M = 4;
    private boolean[][][] map;
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            map = new boolean[N][N][M];
            int sy = in.nextInt() - 1;
            int sx = in.nextInt() - 1;
            if (sy == -1 && sx == -1)
            {
                return;
            }
            Point source = new Point(sx, sy);

            int ey = in.nextInt() - 1;
            int ex = in.nextInt() - 1;
            Point sink = new Point(ex, ey);

            for (int i = 1; i <= 3; i++)
            {
                int y1 = in.nextInt();
                int x1 = in.nextInt();

                int y2 = in.nextInt();
                int x2 = in.nextInt();

                if (isHorizontal(x1, x2))
                {
                    int start = Math.min(y1, y2);
                    int end = Math.max(y1, y2);
                    for (int y = start; y < end; y++)
                    {
                        if (isValid(x1, N) && isValid(y, N))
                        {
                            map[x1][y][0] = true;
                        }
                        if (isValid(x1 - 1, N) && isValid(y, N))
                        {
                            map[x1 - 1][y][2] = true;
                        }
                    }
                } else
                {
                    int start = Math.min(x1, x2);
                    int end = Math.max(x1, x2);
                    for (int x = start; x < end; x++)
                    {
                        if (isValid(y1, N) && isValid(x, N))
                        {
                            map[x][y1][3] = true;
                        }
                        if (isValid(y1 - 1, N) && isValid(x, N))
                        {
                            map[x][y1 - 1][1] = true;
                        }
                    }
                }
            }
            String path = bfs(source, sink);
            out.println(path);
        }
    }

    public String bfs(Point source, Point sink)
    {
        Point[] q = new Point[N * N + 10];
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
                Point now = U;
                String s = "";
                while (!now.equals(source))
                {
                    s = getDirectionName(now.d) + s;
                    now = now.prev;
                }
                return s;
            }

            for (int i = 0; i < M; i++)
            {
                if (map[U.x][U.y][i])
                {
                    continue;
                }
                int x = U.x + dx[i];
                int y = U.y + dy[i];
                Point p = new Point(x, y);
                if (isValid(x, N) && isValid(y, N) && !was.contains(p))
                {
                    p.d = i;
                    p.prev = U;
                    was.add(p);
                    q[qh++] = p;
                    if (p.equals(sink))
                    {
                        Point now = p;
                        String s = "";
                        while (!now.equals(source))
                        {
                            s = getDirectionName(now.d) + s;
                            now = now.prev;
                        }
                        return s;
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    public boolean isValid(int x, int X)
    {
        return x >= 0 && x < X;
    }

    public boolean isHorizontal(int x1, int x2)
    {
        return x1 == x2;
    }

    public char getDirectionName(int d)
    {
        switch (d)
        {
            case 0:
                return 'N';
            case 1:
                return 'E';
            case 2:
                return 'S';
            case 3:
                return 'W';
        }
        throw new RuntimeException();
    }

    class Point
    {
        int x;
        int y;
        Point prev;
        int d;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, Point prev, int d)
        {
            this.x = x;
            this.y = y;
            this.prev = prev;
            this.d = d;
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
