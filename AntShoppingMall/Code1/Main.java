package UVa.AntShoppingMall.Code1;

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
    private int[][] map;

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
            map = new int[row][col];
            for (int i = 0; i < row; i++)
            {
                line = in.readLine();
                for (int j = 0; j < col; j++)
                {
                    int num = line.charAt(j) - '0';
                    map[i][j] = num;
                }
            }
            int best = Integer.MAX_VALUE;
            outer:
            for (int c = 0; c < col; c++)
            {
                int moves = 0;
                for (int r = 0; r < row; r++)
                {
                    if (map[r][c] == 1)
                    {
                        int m = getMoves(r, c);
                        if (m == Integer.MAX_VALUE)
                        {
                            continue outer;
                        }
                        moves += m;
                    }
                }
                best = Math.min(moves, best);
            }
            if (best == Integer.MAX_VALUE)
            {
                System.out.println("Case " + t + ": " + -1);
            } else
            {
                System.out.println("Case " + t + ": " + best);
            }
        }

    }

    public int getMoves(int r, int c)
    {
        int moves = Integer.MAX_VALUE;
        for (int i = c + 1; i < col; i++)
        {
            if (map[r][i] == 0)
            {
                moves = Math.min(moves, i - c);
                break;
            }
        }
        for (int i = c - 1; i >= 0; i--)
        {
            if (map[r][i] == 0)
            {
                moves = Math.min(moves, c - i);
                break;
            }
        }
        return moves;
    }
}
