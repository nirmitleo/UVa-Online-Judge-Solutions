package UVa.HomerSimpson.Code1;

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
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int[] dp = new int[t + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 0; i <= t; i++)
            {
                if (dp[i] != -1)
                {
                    if (i + m <= t)
                    {
                        dp[i + m] = Math.max(dp[i + m], dp[i] + 1);
                    }
                    if (i + n <= t)
                    {
                        dp[i + n] = Math.max(dp[i + n], dp[i] + 1);
                    }
                }
            }

            for (int i = t; i >= 0; i--)
            {
                if (dp[i] != -1)
                {
                    if (i == t)
                    {
                        System.out.println(dp[i]);
                    } else
                    {
                        System.out.println(dp[i] + " " + (t - i));
                    }
                    break;
                }
            }
        }

    }
}
