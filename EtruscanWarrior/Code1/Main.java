package UVa.EtruscanWarrior.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 23/06/2017.
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
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            long low = 0;
            long high = (long) 1e9 + 7;
            while (high - low > 1)
            {
                long mid = low + (high - low) / 2;
                long tn = mid * (mid + 1);
                tn /= 2;
                if (tn <= n)
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
            System.out.println(low);

        }

    }
}
