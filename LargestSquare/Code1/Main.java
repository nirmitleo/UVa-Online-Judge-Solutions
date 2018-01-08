package UVa.LargestSquare.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 18/07/2017.
 */
public class Main
{
    private int row;
    private int col;
    private char[][] map;
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            map = new char[row][col];
            for (int i = 0; i < row; i++)
            {
                line = in.readLine();
                map[i] = line.toCharArray();
            }

            System.out.println(row + " " + col + " " + Q);
            for (int q = 1; q <= Q; q++)
            {
                st = new StringTokenizer(in.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                int low = 0;
                int high = Math.max(row, col);
                while (high - low > 1)
                {
                    int mid = low + (high - low) / 2;
                    if (check(map[r][c], r, c, mid))
                    {
                        low = mid;
                    } else
                    {
                        high = mid;
                    }
                }
                System.out.println(low * 2 + 1);
            }
        }


    }

    public boolean check(char ch, int r, int c, int d)
    {
        int startRow = r - d;
        int startCol = c - d;
        int endRow = r + d;
        int endCol = c + d;
        if (startRow < 0 || startRow >= row || endRow < 0 || endRow >= row || startCol < 0 || startCol >= col || endCol < 0 || endCol >= col)
        {
            return false;
        }
        for (int i = startRow; i <= endRow; i++)
        {
            for (int j = startCol; j <= endCol; j++)
            {
                if (map[i][j] != ch)
                {
                    return false;
                }
            }
        }
        return true;

    }
}
