package UVa.DivingForGold.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 03/06/2017.
 */
public class Main
{
    private int n;
    private int T;
    private int[] t;
    private int[] v;
    private int[][] dp;
    private int[][] prev;

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
        boolean first = true;
        while (true)
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            if (line.length() == 0)
            {
                continue;
            }
            st = new StringTokenizer(line);
            int left = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            t = new int[n + 1];
            v = new int[n + 1];

            for (int i = 1; i <= n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int d = Integer.parseInt(st.nextToken());
                t[i] = 3 * w * d;
                v[i] = Integer.parseInt(st.nextToken());
            }
            T = left;

            dp = new int[n + 1][T + 1];
            prev = new int[n + 1][T + 1];
            for (int i = 0; i < n + 1; i++)
            {
                for (int j = 0; j < T + 1; j++)
                {
                    prev[i][j] = -1;
                    dp[i][j] = -1;
                }
            }
            prev[0][0] = -1;
            dp[0][0] = 0;
            for (int i = 0; i <= n - 1; i++)
            {
                for (int j = 0; j < T + 1; j++)
                {
                    if (dp[i][j] != -1)
                    {
                        if (dp[i + 1][j] < dp[i][j])
                        {
                            dp[i + 1][j] = dp[i][j];
                            prev[i + 1][j] = j;
                        }
                        if (j + t[i + 1] <= T && dp[i + 1][j + t[i + 1]] < dp[i][j] + v[i + 1])
                        {
                            dp[i + 1][j + t[i + 1]] = dp[i][j] + v[i + 1];
                            prev[i + 1][j + t[i + 1]] = j;
                        }
                    }
                }
            }

            int row = -1;
            int col = -1;
            int best = -1;
            for (int j = 0; j < T + 1; j++)
            {
                if (best < dp[n][j])
                {
                    best = dp[n][j];
                    row = n;
                    col = j;
                }
            }


            int count = 0;
            String result = "";
            for (int i = row, j = col; j > 0; )
            {
                if (prev[i][j] != j)
                {
                    count++;
                    result = ((t[i] / 3 / w) + " " + v[i]) + "\n" + result;
                }
                j = prev[i][j];
                i = i - 1;
            }
            if (first)
            {
                System.out.println(best);
                System.out.println(count);
                System.out.println(result.substring(0, result.length() - 1));
                first = false;
            }else
            {
                System.out.println("\n" + best);
                System.out.println(count);
                System.out.println(result.substring(0, result.length() - 1));
            }
            //in.readLine();
        }
    }
}
