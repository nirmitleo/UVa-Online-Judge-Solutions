package UVa.Checkers.Code1;

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
    private int n;
    private long[][] dp;
    private boolean[][] map;
    private Stack<Pair> stack;
    private final static long DESTROYED = (long) 1e17;
    private final static long MOD = 1000007;

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
        int test = Integer.parseInt(in.readLine());
        for (int t = 1; t <= test; t++)
        {
            n = Integer.parseInt(in.readLine());
            map = new boolean[n][n];
            dp = new long[n][n];

            int sx = -1;
            int sy = -1;
            for (int i = 0; i < n; i++)
            {
                line = in.readLine();
                for (int j = 0; j < line.length(); j++)
                {
                    char ch = line.charAt(j);
                    if (ch == '.')
                    {
                        //do nothing//
                    } else if (ch == 'W')
                    {
                        sx = i;
                        sy = j;
                    } else
                    {
                        map[i][j] = true;
                        dp[i][j] = DESTROYED;
                    }
                }
            }
            stack = new Stack<Pair>();
            dfs(sx, sy);

            while (!stack.isEmpty())
            {
                Pair p = stack.pop();
                int x = p.x;
                int y = p.y;
                dp[x][y] = Math.max(1, dp[x][y]);
                if (x - 1 >= 0 && y - 1 >= 0)
                {
                    if (dp[x - 1][y - 1] != DESTROYED)
                    {
                        dp[x - 1][y - 1] += dp[x][y];
                        dp[x - 1][y - 1] %= MOD;
                    } else
                    {
                        if (x - 2 >= 0 && y - 2 >= 0)
                        {
                            if (dp[x - 2][y - 2] != DESTROYED)
                            {
                                dp[x - 2][y - 2] += dp[x][y];
                                dp[x - 2][y - 2] %= MOD;
                            }
                        }
                    }
                }
                if (x - 1 >= 0 && y + 1 < n)
                {
                    if (dp[x - 1][y + 1] != DESTROYED)
                    {
                        dp[x - 1][y + 1] += dp[x][y];
                        dp[x - 1][y + 1] %= MOD;
                    } else
                    {
                        if (x - 2 >= 0 && y + 2 < n)
                        {
                            if (dp[x - 2][y + 2] != DESTROYED)
                            {
                                dp[x - 2][y + 2] += dp[x][y];
                                dp[x - 2][y + 2] %= MOD;
                            }
                        }
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i < n; i++)
            {
                if (dp[0][i] != DESTROYED)
                {
                    sum += dp[0][i];
                    sum %= MOD;
                }
            }
            if (t == 1)
            {
                System.out.print("Case " + t + ": " + sum);
            } else
            {
                System.out.print("\nCase " + t + ": " + sum);
            }
        }
        System.out.println();
    }

    public void dfs(int x, int y)
    {
        map[x][y] = true;
        if (y - 1 >= 0 && x - 1 >= 0)
        {
            if (map[x - 1][y - 1])
            {
                if (x - 2 >= 0 && y - 2 >= 0)
                {
                    if (!map[x - 2][y - 2])
                    {
                        dfs(x - 2, y - 2);
                    }
                }
            } else
            {
                dfs(x - 1, y - 1);
            }
        }
        if (y + 1 < n && x - 1 >= 0)
        {
            if (map[x - 1][y + 1])
            {
                if (x - 2 >= 0 && y + 2 < n)
                {
                    if (!map[x - 2][y + 2])
                    {
                        dfs(x - 2, y + 2);
                    }
                }
            } else
            {
                dfs(x - 1, y + 1);
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

