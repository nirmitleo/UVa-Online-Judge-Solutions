package UVa.LittleRedRidingHood.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 25-05-2017.
 */
public class Main
{
    private int row;
    private int col;
    private long[][] dp;
    private boolean[][] map;
    private final static long DESTROYED = (long) 1e17;
    private Stack<Pair> stack;
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
        while (true)
        {
            st = new StringTokenizer(in.readLine());
            row = Integer.parseInt(st.nextToken()) + 1;
            col = Integer.parseInt(st.nextToken()) + 1;
            if (row == 1 && col == 1)
            {
                return;
            }

            dp = new long[row][col];
            map = new boolean[row][col];
            int w = Integer.parseInt(in.readLine());
            while (w-- > 0)
            {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
                dp[x][y] = DESTROYED;
            }

            int sx = 0;
            int sy = 0;

            int ex = row - 1;
            int ey = col - 1;
            stack = new Stack<Pair>();
            dfs(sx, sy, ex, ey);

            while (!stack.isEmpty())
            {
                Pair p = stack.pop();
                int x = p.x;
                int y = p.y;
                dp[x][y] = Math.max(1, dp[x][y]);
                if (x + 1 < row && dp[x + 1][y] != DESTROYED)
                {
                    dp[x + 1][y] += dp[x][y];
                }
                if (y + 1 < col && dp[x][y + 1] != DESTROYED)
                {
                    dp[x][y + 1] += dp[x][y];
                }
            }

            long result = dp[row - 1][col - 1];
            if (result == 0)
            {
                System.out.println("There is no path.");
            } else if (result == 1)
            {
                System.out.println("There is one path from Little Red Riding Hood's house to her grandmother's house.");
            } else
            {
                System.out.println("There are " + result + " paths from Little Red Riding Hood's house to her grandmother's house.");
            }

        }

    }

    public void dfs(int x, int y, int ex, int ey)
    {
        map[x][y] = true;
        if (x == ex && y == ey)
        {
            return;
        } else
        {
            if (x + 1 < row && !map[x + 1][y])
            {
                dfs(x + 1, y, ex, ey);
            }
            if (y + 1 < col && !map[x][y + 1])
            {
                dfs(x, y + 1, ex, ey);
            }
        }
        stack.push(new Pair(x, y));
    }

    class Pair
    {
        int x;
        int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
