package UVa.Dollars.Code1SpaceSaverTrick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/06/2017.
 */
public class Main
{
    private int[] coins = new int[]{5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] a) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        long[] dp = new long[300100];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++)
        {
            for (int j = 0; j < dp.length; j++)
            {
                if (j + coins[i] < dp.length)
                {
                    dp[j + coins[i]] += dp[j];
                }
            }
        }

        while (true)
        {
            st = new StringTokenizer(in.readLine());
            String d = st.nextToken();
            int V = Integer.parseInt(d.substring(0, d.indexOf("."))) * 100;
            V += Integer.parseInt(d.substring(d.indexOf(".") + 1));
            if (V == 0)
            {
                return;
            }
            //System.out.println(dp[V]);
            String result = String.format("%6.2f%17d", V / 100.0, dp[V]);
            System.out.println(result);
        }
    }
}
