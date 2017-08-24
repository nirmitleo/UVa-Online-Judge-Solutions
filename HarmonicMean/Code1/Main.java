package UVa.HarmonicMean.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/07/2017.
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
            int N = Integer.parseInt(st.nextToken());
            long[] a = new long[N];
            for (int i = 0; i < N; i++)
            {
                if (st.hasMoreTokens())
                {
                    a[i] = Long.parseLong(st.nextToken());
                } else
                {
                    st = new StringTokenizer(in.readLine());
                    i--;
                }
            }
            long L = lcm(a);
            long nr = 0;
            for (int i = 0; i < N; i++)
            {
                nr += (L / a[i]);
            }
            long dr = nr;
            nr = L * N;
            long G = gcd(nr, dr);
            System.out.println("Case " + t + ": " + (nr / G) + "/" + (dr / G));
        }
    }


    public long lcm(long[] a)
    {
        long result = 1;
        for (int i = 0; i < a.length; i++)
        {
            result = lcm(result, a[i]);
        }
        return result;
    }

    public long lcm(long a, long b)
    {
        return a / gcd(a, b) * b;
    }

    public long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

}
