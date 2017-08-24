package UVa.ExactChange.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/06/2017.
 */
public class Main
{
    private final static int INVALID = (int) 1e9;
    private final static int N = (int) 1e4 + 100;
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
            int V = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] left = new int[N];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken());
                left[c]++;
            }

            int[] dp = new int[N];
            Arrays.fill(dp, INVALID);

            dp[0] = 0;
            for (int i = 1; i < N; i++)
            {
                if (left[i] == 0)
                {
                    continue;
                }
                for (int j = N - 1; j >= 0; j--)
                {
                    if (dp[j] != INVALID)
                    {
                        for (int k = 1; k <= left[i]; k++)
                        {
                            if (j + k * i < N)
                            {
                                dp[j + k * i] = Math.min(dp[j + k * i], dp[j] + k);
                            }
                        }
                    }
                }
            }

            for (int i = V; true; i++)
            {
                if (dp[i] != INVALID)
                {
                    //System.out.println(dp[8763]);
                    System.out.println(i + " " + dp[i]);
                    break;
                }
            }
        }

    }
}
