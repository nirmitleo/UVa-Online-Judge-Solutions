package UVa.Luggage.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 04/06/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        outer:
        for (int t = 1; t <= test; t++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens())
            {
                temp.add(Integer.parseInt(st.nextToken()));
            }

            int n = temp.size();
            int[] bag = new int[n + 1];
            int[] bagSum = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                bag[i] = temp.get(i - 1);
                bagSum[i] = bag[i] + bagSum[i - 1];
            }

            boolean[] dp = new boolean[bagSum[n] + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++)
            {
                for (int j = bagSum[n]; j >= bag[i]; j--)
                {
                    dp[j] |= dp[j - bag[i]];
                }
            }

            for (int i = 0; i < bagSum[n] + 1; i++)
            {
                if (dp[i])
                {
                    int car1 = i;
                    int car2 = bagSum[n] - i;
                    if (car1 == car2)
                    {
                        System.out.println("YES");
                        continue outer;
                    }
                }
            }
            System.out.println("NO");
        }


    }
}
