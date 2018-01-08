package UVa.HowManySolutions.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/07/2017.
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
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            if (M == 0 || N == 0 || P == 0)
            {
                return;
            }

            long ans = 1;
            long F = Math.abs(P * P * 1L * M * N);
            for (long i = 2; i * i <= F; i++)
            {
                int count = 0;
                while (F % i == 0)
                {
                    count++;
                    F /= i;
                }
                if (count > 0)
                {
                    ans *= (count + 1);
                }
            }
            if (F > 1)
            {
                ans *= 2;
            }
            System.out.println("Case " + t + ": " + ((ans * 2) - 1));
        }

    }
}
