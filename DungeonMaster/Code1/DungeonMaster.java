package UVa.DungeonMaster.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class DungeonMaster
{
    private int X;
    private int Y;
    private int Z;
    private boolean[][][] map;
    private int[] dx = {1, -1, 0, 0, 0, 0};
    private int[] dy = {0, 0, 1, -1, 0, 0};
    private int[] dz = {0, 0, 0, 0, 1, -1};


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            X = in.nextInt();
            Y = in.nextInt();
            Z = in.nextInt();
            if (X + Y + Z == 0)
            {
                return;
            }

            int sx = -1;
            int sy = -1;
            int sz = -1;

            int ex = -1;
            int ey = -1;
            int ez = -1;

            map = new boolean[X][Y][Z];
            for (int i = 0; i < X; i++)
            {
                for (int j = 0; j < Y; j++)
                {
                    String line = in.next();
                    for (int k = 0; k < Z; k++)
                    {
                        char ch = line.charAt(k);
                        switch (ch)
                        {
                            case 'S':
                                sx = i;
                                sy = j;
                                sz = k;
                                map[i][j][k] = true;
                                break;
                            case 'E':
                                ex = i;
                                ey = j;
                                ez = k;
                                map[i][j][k] = true;
                                break;
                            case '.':
                                map[i][j][k] = true;
                                break;
                        }
                    }
                }
//                in.next();
            }

            Cell source = new Cell(sx, sy, sz);
            Cell sink = new Cell(ex, ey, ez);
            String result = bfs(source, sink);
            out.println(result);
        }
    }

    public String bfs(Cell source, Cell sink)
    {
        Cell[] q = new Cell[X * Y * Z];
        int qh = 1;
        int qt = 0;

        boolean[][][] was = new boolean[X][Y][Z];

        q[0] = source;
        was[source.x][source.y][source.z] = true;

        while (qt < qh)
        {
            Cell U = q[qt++];
            if (U.equals(sink))
            {
                return "Escaped in " + U.dist + " minute(s).";
            }

            for (int i = 0; i < dx.length; i++)
            {
                int x = U.x + dx[i];
                int y = U.y + dy[i];
                int z = U.z + dz[i];

                if (isValid(x, X) && isValid(y, Y) && isValid(z, Z) && !was[x][y][z] && map[x][y][z])
                {
                    Cell v = new Cell(x, y, z, U.dist + 1);
                    if (v.equals(sink))
                    {
                        return "Escaped in " + v.dist + " minute(s).";
                    }
                    was[x][y][z] = true;
                    q[qh++] = v;
                }
            }
        }
        return "Trapped!";
    }

    public boolean isValid(int h, int H)
    {
        return h >= 0 && h < H;
    }

    class Cell
    {
        int x;
        int y;
        int z;
        int dist;

        public Cell(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Cell(int x, int y, int z, int dist)
        {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (x != cell.x) return false;
            if (y != cell.y) return false;
            return z == cell.z;
        }

        @Override
        public int hashCode()
        {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }

        public String toString()
        {
            return "X = " + x + " Y = " + y + " Z = " + z + " dist = " + dist;
        }
    }
}
