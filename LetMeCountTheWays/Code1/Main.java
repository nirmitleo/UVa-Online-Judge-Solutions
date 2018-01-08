package UVa.LetMeCountTheWays.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/06/2017.
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
        int N = 5;
        int[] coins = new int[]{1, 5, 10, 25, 50};
        int V = 300 * 100 + 10;

        long[] dp = new long[V];
        dp[0] = 1;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < V; j++)
            {
                if (j + coins[i] < V)
                {
                    dp[j + coins[i]] += dp[j];
                }
            }
        }

        while (true)
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            if (dp[n] == 1)
            {
                System.out.println("There is only 1 way to produce " + n + " cents change.");
            } else
            {
                System.out.println("There are " + dp[n] + " ways to produce " + n + " cents change.");
            }

        }

    }
}
