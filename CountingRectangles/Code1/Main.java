package UVa.CountingRectangles.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 18/07/2017.
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
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int row = Integer.parseInt(st.nextToken());
            if (row == 0)
            {
                return;
            }
            st = new StringTokenizer(in.readLine());
            int col = Integer.parseInt(st.nextToken());
            int[][] a = new int[row][col];
            for (int i = 0; i < row; i++)
            {
                line = in.readLine();
                for (int j = 0; j < col; j++)
                {
                    int num = line.charAt(j) - '0';
                    a[i][j] = num;
                    if (i > 0)
                    {
                        a[i][j] += a[i - 1][j];
                    }
                    if (j > 0)
                    {
                        a[i][j] += a[i][j - 1];
                    }
                    if (i > 0 && j > 0)
                    {
                        a[i][j] -= a[i - 1][j - 1];
                    }
                }
            }
            int count = 0;
            for (int r1 = 0; r1 < row; r1++)
            {
                for (int c1 = 0; c1 < col; c1++)
                {
                    for (int r2 = 0; r2 < row; r2++)
                    {
                        for (int c2 = 0; c2 < col; c2++)
                        {
                            if (r2 >= r1 && c2 >= c1)
                            {
                                int sum = a[r2][c2];
                                if (c1 - 1 >= 0)
                                {
                                    sum -= a[r2][c1 - 1];
                                }
                                if (r1 - 1 >= 0)
                                {
                                    sum -= a[r1 - 1][c2];
                                }
                                if (r1 > 0 && c1 > 0)
                                {
                                    sum += a[r1 - 1][c1 - 1];
                                }
                                int r = Math.abs(r1 - r2) + 1;
                                int c = Math.abs(c1 - c2) + 1;
                                if (sum == r * c)
                                {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }
}
