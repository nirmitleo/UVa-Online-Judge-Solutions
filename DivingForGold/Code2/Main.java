package UVa.DivingForGold.Code2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/06/2017.
 */
public class Main
{
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
        for (int t = 1; ; t++)
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            if (line.trim().length() == 0)
            {
                continue;
            }
            st = new StringTokenizer(line);
            int left = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] time = new int[n + 1];
            int[] value = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                st = new StringTokenizer(in.readLine());
                time[i] = 3 * w * Integer.parseInt(st.nextToken());
                value[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n + 1][left + 1];
            int[][] now = new int[n + 1][left + 1];
            for (int i = 0; i < n + 1; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }

            dp[0][0] = 0;
            now[0][0] = 0;
            for (int i = 0; i <= n - 1; i++)
            {
                for (int j = 0; j <= left; j++)
                {
                    if (dp[i][j] != INVALID)
                    {
                        if (dp[i + 1][j] < dp[i][j])
                        {
                            dp[i + 1][j] = dp[i][j];
                            now[i + 1][j] = j;
                        }
                        if (j + time[i + 1] <= left)
                        {
                            if (dp[i + 1][j + time[i + 1]] < dp[i][j] + value[i + 1])
                            {
                                dp[i + 1][j + time[i + 1]] = dp[i][j] + value[i + 1];
                                now[i + 1][j + time[i + 1]] = j;
                            }
                        }
                    }
                }
            }
            int best = 0;
            int r = n;
            int c = -1;
            for (int i = 0; i <= left; i++)
            {
                if (best < dp[n][i])
                {
                    best = dp[n][i];
                    r = n;
                    c = i;
                }
            }
            int count = 0;
            String result = "";
            for (int i = r, j = c; i > 0; i--)
            {
                if (now[i][j] != j)
                {
                    count++;
                    result = (time[i] / 3 / w) + " " + value[i] + "\n" + result;
                }
                j = now[i][j];
            }
            if (t == 1)
            {
                System.out.println(best);
                System.out.println(count);
                System.out.print(result);
            } else
            {
                System.out.println("\n" + best);
                System.out.println(count);
                System.out.print(result);
            }
        }

    }
}
