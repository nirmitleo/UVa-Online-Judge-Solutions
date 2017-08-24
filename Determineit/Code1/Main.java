package UVa.Determineit.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 08/06/2017.
 */
public class Main
{
    private int n;
    private int size;
    private long[][] dp;
    private final static int INVALID = -1;
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

            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }

            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            size = n + 1;
            dp = new long[size][size];
            for (int i = 0; i < size; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }

            dp[n][1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    if (dp[i][j] == INVALID)
                    {
                        solve(i, j);
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }


    public long solve(int i, int j)
    {
        if (dp[i][j] != INVALID)
        {
            return dp[i][j];
        }
        if (i >= j)
        {
            long max1 = 0;
            if (i < n)
            {
                for (int k = i + 1; k <= n; k++)
                {
                    max1 = Math.max(max1, solve(k, 1) + solve(k, j));
                }
            }

            long max2 = 0;
            if (j > 0)
            {
                for (int k = 1; k < j; k++)
                {
                    max2 = Math.max(max2, solve(i, k) + solve(n, k));
                }
            }

            return dp[i][j] = max1 + max2;
        } else
        {
            long max = 0;
            for (int k = i; k < j; k++)
            {
                max = Math.max(max, solve(i, k) + solve(k + 1, j));
            }
            return dp[i][j] = max;
        }
    }
}
