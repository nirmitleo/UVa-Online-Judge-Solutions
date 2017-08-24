package UVa.DoomsDay.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/07/2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }

    public void test()
    {
        int N = 7;
        for (int i = 1; i <= N; i++)
        {
            for (int j = i; j <= N; j++)
            {
                int row = pow3(i);
                int col = pow3(j);
                int[][] now = new int[row][col];
                for (int ii = 0, k = 1; ii < row; ii++)
                {
                    for (int jj = 0; jj < col; jj++)
                    {
                        now[ii][jj] = k;
                        k++;
                    }
                }

                int count = 0;
//                print(now);
                do
                {
                    now = transpose(now);
//                    System.out.println();
//                    System.out.println();
//                    print(now);
                    count++;
//                    if (count > 5)
//                    {
//                        throw new RuntimeException();
//                    }
                } while (!check(now));
                System.out.println("Answer for (" + i + " " + j + ") = " + count + "     ADD = " + (i + j) + "       GCD = " + gcd(i, j) + "        LCM = " + lcm(i, j));
//                System.out.println();
//                System.out.println();
            }
        }
    }

    public long lcm(long a, long b)
    {
        return a / gcd(a, b) * b;
    }

    public long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public void print(int[][] map)
    {
        int row = map.length;
        int col = map[0].length;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] transpose(int[][] now)
    {
        int row = now.length;
        int col = now[0].length;
        int[][] next = new int[row][col];
        int x = 0;
        int y = 0;
        int count = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                x = count / row;
                y = count % row;
                next[y][x] = now[i][j];
                count++;
            }
        }
        return next;
    }

    public boolean check(int[][] map)
    {
        int row = map.length;
        int col = map[0].length;
        for (int i = 0, k = 1; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (map[i][j] != k)
                {
                    return false;
                }
                k++;
            }
        }
        return true;
    }

    public int pow3(int e)
    {
        int base = 1;
        for (int i = 1; i <= e; i++)
        {
            base *= 3;
        }
        return base;
    }

    public void solve() throws IOException
    {
        while (true)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                continue;
            }
            break;
        }
        st = new StringTokenizer(line);
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            long m = -1;
            long n = -1;
            int count = 0;
            while (count < 2)
            {
                if (st.hasMoreTokens())
                {
                    count++;
                    if (count == 1)
                    {
                        m = Long.parseLong(st.nextToken());
                    } else if (count == 2)
                    {
                        n = Long.parseLong(st.nextToken());
                        break;
                    }
                } else
                {
                    st = new StringTokenizer(in.readLine());
                }
            }
            long result = m + n;
            result /= gcd(m, n);
            System.out.println("Case " + t + ": " + result);
        }

    }
}
