package UVa.CoinCollector.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 17/06/2017.
 */
public class Main
{
    private int N;
    private int[] coins;

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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());

            coins = new int[N];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
            {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            long sum = coins[0];
            int result = 1;
            for (int i = 1; i < N - 1; i++)
            {
                if (sum + coins[i] < coins[i + 1])
                {
                    result++;
                    sum += coins[i];
                }
            }
            System.out.println(result + 1);
        }
    }
}
