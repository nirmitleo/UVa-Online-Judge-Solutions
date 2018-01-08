package UVa.MarcusHelp.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/06/2017.
 */
public class Main
{
    private int row;
    private int col;
    private char[][] map;
    private boolean[][] was;
    private String ok = "IEHOVA#";
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
            map = new char[row][col];
            was = new boolean[row][col];
            for (int i = 0; i < row; i++)
            {
                map[i] = in.readLine().trim().toCharArray();
            }

            int sx = -1;
            int sy = -1;
            int ex = -1;
            int ey = -1;
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (map[i][j] == '@')
                    {
                        sx = i;
                        sy = j;
                    }
                    if (map[i][j] == '#')
                    {
                        ex = i;
                        ey = j;
                    }
                }
            }
            go(sx, sy, ex, ey, "");
        }
    }

    public void go(int x, int y, int ex, int ey, String path)
    {
        if (x == ex && y == ey)
        {
            System.out.println(path.substring(1));
        } else
        {
            was[x][y] = true;
            if (x - 1 >= 0 && ok.contains(map[x - 1][y] + "") && !was[x - 1][y])
            {
                go(x - 1, y, ex, ey, path + " forth");
            }
            if (y - 1 >= 0 && ok.contains(map[x][y - 1] + "") && !was[x][y - 1])
            {
                go(x, y - 1, ex, ey, path + " left");
            }
            if (y + 1 < col && ok.contains(map[x][y + 1] + "") && !was[x][y + 1])
            {
                go(x, y + 1, ex, ey, path + " right");
            }
        }
    }
}
