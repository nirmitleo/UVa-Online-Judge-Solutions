package UVa.CuttingSticks.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 07/06/2017.
 */
public class Main
{
    private int L;
    private int n;
    private int[] cuts;
    private int[][] dp;

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
            st = new StringTokenizer(in.readLine());
            L = Integer.parseInt(st.nextToken());
            if (L == 0)
            {
                return;
            }

            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            dp = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++)
            {
                Arrays.fill(dp[i], -1);
            }

            st = new StringTokenizer(in.readLine());
            cuts = new int[n + 2];
            for (int i = 1; i <= n; i++)
            {
                cuts[i] = Integer.parseInt(st.nextToken());
            }
            cuts[n + 1] = L;

            int result = go(0, n + 1);
            System.out.println("The minimum cutting is " + result + ".");
        }
    }

    public int go(int left, int right)
    {
        if (left + 1 == right)
        {
            return dp[left][right] = 0;
        }
        if (dp[left][right] != -1)
        {
            return dp[left][right];
        }
        dp[left][right] = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++)
        {
            dp[left][right] = Math.min(dp[left][right], (cuts[right] - cuts[left]) + go(left, i) + go(i, right));
        }
        return dp[left][right];
    }
}
