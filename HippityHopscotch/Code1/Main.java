package UVa.HippityHopscotch.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24-05-2017.
 */
public class Main
{
    private int row;
    private int col;
    private int k;
    private int[][] c;
    private int[][] dp;
    private boolean[][] was;
    private Stack<Pair> stack;

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
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++)
        {
            br.readLine();
            st = new StringTokenizer(br.readLine());

            col = row = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            c = new int[row][col];
            dp = new int[row][col];
            was = new boolean[row][col];
            stack = new Stack<Pair>();

            for (int i = 0; i < row; i++)
            {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++)
                {
                    c[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0);
            while (!stack.isEmpty())
            {
                Pair p = stack.pop();
                int x = p.x;
                int y = p.y;
                dp[x][y] = Math.max(dp[x][y], c[x][y]);
                for (int i = 1; i <= k; i++)
                {
                    if (x - i >= 0 && c[x][y] < c[x - i][y])
                    {
                        dp[x - i][y] = Math.max(dp[x - i][y], dp[x][y] + c[x - i][y]);
                    }
                    if (x + i < row && c[x][y] < c[x + i][y])
                    {
                        dp[x + i][y] = Math.max(dp[x + i][y], dp[x][y] + c[x + i][y]);
                    }
                    if (y - i >= 0 && c[x][y] < c[x][y - i])
                    {
                        dp[x][y - i] = Math.max(dp[x][y - i], dp[x][y] + c[x][y - i]);
                    }
                    if (y + i < col && c[x][y] < c[x][y + i])
                    {
                        dp[x][y + i] = Math.max(dp[x][y + i], dp[x][y] + c[x][y + i]);
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    max = Math.max(max, dp[i][j]);
                }
            }
            if (t == 1)
            {
                System.out.println(max);
            } else
            {
                System.out.println("\n" + max);
            }
        }

    }

    public void dfs(int x, int y)
    {
        was[x][y] = true;
        for (int i = 1; i <= k; i++)
        {
            if (x + i < row && !was[x + i][y] && c[x][y] < c[x + i][y])
            {
                dfs(x + i, y);
            }
            if (x - i >= 0 && !was[x - i][y] && c[x][y] < c[x - i][y])
            {
                dfs(x - i, y);
            }
            if (y + i < col && !was[x][y + i] && c[x][y] < c[x][y + i])
            {
                dfs(x, y + i);
            }
            if (y - i >= 0 && !was[x][y - i] && c[x][y] < c[x][y - i])
            {
                dfs(x, y - i);
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

