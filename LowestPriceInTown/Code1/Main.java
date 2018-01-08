package UVa.LowestPriceInTown.Code1;

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
    private int N = 500;
    private final static int INVALID = (int) 1e9;
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
            int[] prices = new int[N];
            Arrays.fill(prices, INVALID);
            st = new StringTokenizer(line);
            int priceForOne = parseDouble(st.nextToken());
            prices[1] = priceForOne;

            int q = Integer.parseInt(st.nextToken());
            while (q-- > 0)
            {
                st = new StringTokenizer(in.readLine());
                int qty = Integer.parseInt(st.nextToken());
                int price = parseDouble(st.nextToken());
                prices[qty] = Math.min(prices[qty], price);
            }
            //System.out.println(Arrays.toString(prices));
            int[] dp = new int[N];
            Arrays.fill(dp, INVALID);
            dp[0] = 0;
            dp[1] = priceForOne;
            for (int i = 0; i < N; i++)
            {
                if (prices[i] != INVALID)
                {
                    for (int j = 0; j < N; j++)
                    {
                        if (dp[j] != INVALID)
                        {
                            if (j + i < N)
                            {
                                dp[j + i] = Math.min(dp[j + i], dp[j] + prices[i]);
                            }
                        }
                    }
                }
            }
            System.out.println("Case " + t + ":");
            st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens())
            {
                int qty = Integer.parseInt(st.nextToken());
                int best = dp[qty];
                for (int i = qty + 1; i < N; i++)
                {
                    best = Math.min(best, dp[i]);
                }
                System.out.println("Buy " + qty + " for $" + String.format("%.2f", (best / 100.0)));
            }
        }
    }

    public int parseDouble(String s)
    {
        int sum = 0;
        int dot = s.indexOf(".");
        sum = Integer.parseInt(s.substring(0, dot));
        sum *= 100;
        sum += Integer.parseInt(s.substring(dot + 1));
        return sum;
    }
}
