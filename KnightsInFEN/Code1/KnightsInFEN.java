package UVa.KnightsInFEN.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.io.IOException;
import java.util.LinkedList;
import java.util.TreeSet;

public class KnightsInFEN
{
    private final static int SPACE = -1;
    private final static int WHITE = 0;
    private final static int BLACK = 1;
    private final static int N = 5;

    private final Board sink = new Board(new int[][]{
            {BLACK, BLACK, BLACK, BLACK, BLACK},
            {WHITE, BLACK, BLACK, BLACK, BLACK},
            {WHITE, WHITE, SPACE, BLACK, BLACK},
            {WHITE, WHITE, WHITE, WHITE, BLACK},
            {WHITE, WHITE, WHITE, WHITE, WHITE},
    }, -1);


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++)
            {
                try
                {
                    String s = in.br.readLine();
                    for (int j = 0; j < N; j++)
                    {
                        char ch = s.charAt(j);
                        if (ch == '1')
                        {
                            map[i][j] = BLACK;
                        } else if (ch == '0')
                        {
                            map[i][j] = WHITE;
                        } else
                        {
                            map[i][j] = SPACE;
                        }
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
//            for (int r = 0; r < N; r++)
//            {
//                for (int c = 0; c < N; c++)
//                {
//                    System.out.print(internalMap[r][c] + " ");
//                }
//                System.out.println();
//            }
            int dist = bfs(new Board(map, 0));
            if (dist == -1)
            {
                out.println("Unsolvable in less than 11 move(s).");
            } else
            {
                out.println("Solvable in " + dist + " move(s).");
            }
        }
    }

    public int bfs(Board start)
    {
        TreeSet<Board> was = new TreeSet<>();
        LinkedList<Board> q = new LinkedList<>();

        q.add(start);
        was.add(start);

        if (check(start.map, sink.map))
        {
            return 0;
        }

        while (!q.isEmpty())
        {
            Board U = q.pollFirst();
            if (U.dist >= 10)
            {
                continue;
            }
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (U.map[i][j] != SPACE)
                    {
                        for (int x = -2; x <= 2; x++)
                        {
                            for (int y = -2; y <= 2; y++)
                            {
                                if (Math.abs(x * y) == 2)
                                {
                                    if (i + x >= 0 && i + x < N && j + y >= 0 && j + y < N && U.map[i + x][j + y] == SPACE)
                                    {
                                        int[][] anotherMap = getCopy(U.map);
                                        int temp = anotherMap[i][j];
                                        anotherMap[i][j] = anotherMap[i + x][j + y];
                                        anotherMap[i + x][j + y] = temp;
                                        Board V = new Board(anotherMap, U.dist + 1);

                                        if (!was.contains(V))
                                        {
                                            if (check(anotherMap, sink.map))
                                            {
                                                return U.dist + 1;
                                            }
                                            was.add(V);
                                            q.add(new Board(anotherMap, U.dist + 1));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public boolean check(int[][] map1, int[][] map2)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (map1[i][j] != map2[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getCopy(int[][] map)
    {
        int anotherMap[][] = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                anotherMap[i][j] = map[i][j];
            }
        }
        return anotherMap;
    }


    class Board implements Comparable<Board>
    {
        int dist;
        int[][] map;

        public Board(int[][] map, int dist)
        {
            this.map = map;
            this.dist = dist;
        }

        public int compareTo(Board that)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    int diff = Integer.compare(this.map[i][j], that.map[i][j]);
                    if (diff != 0)
                    {
                        return diff;
                    }
                }
            }
            return 0;
        }


    }
}
