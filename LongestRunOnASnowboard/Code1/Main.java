package UVa.LongestRunOnASnowboard.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24-05-2017.
 */
public class Main
{
    private int row;
    private int col;
    private int[][] land;
    private int[][] depth;
    private boolean[][] was;
    private String line;
    private StringTokenizer st;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine().trim());
        while (test-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            land = new int[row][col];
            depth = new int[row][col];
            was = new boolean[row][col];

            for (int i = 0; i < row; i++)
            {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++)
                {
                    land[i][j] = Integer.parseInt(st.nextToken());
                    depth[i][j] = -1;
                }
            }

            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (depth[i][j] == -1)
                    {
                        dfs(i, j, 1);
                    }
                }
            }

            int ex = 0;
            int ey = 0;
            int result = 0;
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (result < depth[i][j])
                    {
                        result = depth[i][j];
                    }
                    result = Math.max(result, depth[i][j]);
                }
            }
            System.out.println(name + ": " + result);
        }
    }

    public void dfs(int x, int y, int dist)
    {
        if (x >= 0 && x < row && y >= 0 && y < col)
        {
            depth[x][y] = dist;
            if (x + 1 < row && land[x][y] > land[x + 1][y] && depth[x + 1][y] < dist + 1)
            {
                dfs(x + 1, y, dist + 1);
            }
            if (x - 1 >= 0 && land[x][y] > land[x - 1][y] && depth[x - 1][y] < dist + 1)
            {
                dfs(x - 1, y, dist + 1);
            }
            if (y + 1 < col && land[x][y] > land[x][y + 1] && depth[x][y + 1] < dist + 1)
            {
                dfs(x, y + 1, dist + 1);
            }
            if (y - 1 >= 0 && land[x][y] > land[x][y - 1] && depth[x][y - 1] < dist + 1)
            {
                dfs(x, y - 1, dist + 1);
            }
        }
    }
}

