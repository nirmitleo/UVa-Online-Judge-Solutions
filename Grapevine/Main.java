package UVa.Grapevine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 26-05-2017.
 */
public class Main
{
    private int n;
    private int m;
    private int[][] map;


    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 1;
        while (true)
        {
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0)
            {
                //out.println();
                out.flush();
                out.close();
                return;
            }

            map = new int[n][m];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < m; j++)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int q = Integer.parseInt(in.readLine());
            while (q-- > 0)
            {
                int max = -1;
                st = new StringTokenizer(in.readLine());
                int low = Integer.parseInt(st.nextToken());
                int high = Integer.parseInt(st.nextToken());


                for (int i = 0; i < n; i++)
                {
                    int cLow = lowerBound(true, i, low, -1, m);
                    int sizeLow = 0;
                    int sizeHigh = Math.max(n + n, m + m);
                    if (n - i < max)
                    {
                        break;
                    }
                    while (sizeHigh - sizeLow > 1)
                    {
                        int size = sizeLow + (sizeHigh - sizeLow) / 2;
                        if (check(i, cLow, size, low, high))
                        {
                            sizeLow = size;
                        } else
                        {
                            sizeHigh = size;
                        }
                    }
                    max = Math.max(max, sizeLow);
                }

                /*for (int i = 0; i < m; i++)
                {
                    int rLow = lowerBound(false, i, low, -1, n);
                    int sizeLow = 0;
                    int sizeHigh = (int) 1e9;
                    while (sizeHigh - sizeLow > 1)
                    {
                        int size = sizeLow + (sizeHigh - sizeLow) / 2;
                        if (check(rLow, i, size, low, high))
                        {
                            sizeLow = size;
                        } else
                        {
                            sizeHigh = size;
                        }
                    }
                    max = Math.max(max, sizeLow);
                }*/
                out.println(max);
            }
            out.println("-");
        }
    }

    public boolean check(int x, int y, int size, int low, int high)
    {
        boolean b1 = isValid(x, y, low, high);
        boolean b2 = isValid(x + size - 1, y, low, high);
        boolean b3 = isValid(x + size - 1, y + size - 1, low, high);
        boolean b4 = isValid(x, y + size - 1, low, high);
        return b1 && b2 && b3 && b4;
    }

    public boolean isValid(int x, int y, int low, int high)
    {
        return x >= 0 && x < n && y >= 0 && y < m && map[x][y] >= low && map[x][y] <= high;
    }

    public int lowerBound(boolean isRow, int row, int value, int left, int right)
    {
        int low = left;
        int high = right;
        while (high - low > 1)
        {
            int mid = low + (high - low) / 2;

            if (isRow)
            {
                if (map[row][mid] >= value)
                {
                    high = mid;
                } else
                {
                    low = mid;
                }
            } else
            {
                if (map[mid][row] >= value)
                {
                    high = mid;
                } else
                {
                    low = mid;
                }
            }
        }
        return high;
    }

    public int higherBound(boolean isRow, int row, int value, int left, int right)
    {
        int low = left;
        int high = right;
        while (high - low > 1)
        {
            int mid = low + (high - low) / 2;
            if (isRow)
            {
                if (map[row][mid] <= value)
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            } else
            {
                if (map[mid][row] <= value)
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
        }
        return low;
    }
}
