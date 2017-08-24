package UVa.ConsecutiveIntegers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 30/06/2017.
 */
public class Main
{
    private int N = (int) 1e6;
    private long[] T = new long[N];

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
            int S = Integer.parseInt(st.nextToken());
            if (S < 0)
            {
                return;
            }

            long n = -1;
            long a = -1;
            int S2 = S + S;
            int limit = (int) Math.sqrt(S2);
            for (long i = 1; i * i <= S2; i++)
            {
                if (S2 % i == 0)
                {
                    long j = S2 / i;
                    long aa = j - i + 1;
                    if (aa % 2 == 0)
                    {
                        a = aa / 2;
                        n = i;
                    }
                }
            }
            System.out.println(S + " = " + a + " + ... + " + (a + (n - 1)));
        }
    }
}
