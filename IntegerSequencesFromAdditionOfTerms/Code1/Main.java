package UVa.IntegerSequencesFromAdditionOfTerms.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 14/07/2017.
 */
public class Main
{
    private long[] F;
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
            int terms = Integer.parseInt(st.nextToken()) + 1;
            F = new long[terms];
            for (int i = 0; i < terms; i++)
            {
                F[i] = Long.parseLong(st.nextToken());
            }
            long d = Long.parseLong(in.readLine().trim());
            long n = Long.parseLong(in.readLine().trim());
            long end = 0;
            for (int i = 1; true; i++)
            {
                long value = getValue(i);
                end = end + (d * i);
                if (n <= end)
                {
                    System.out.println(value);
                    break;
                }
            }
        }
    }

    public long getValue(long x)
    {
        long ret = 0;
        long pow = 1;
        for (int i = 0; i < F.length; i++)
        {
            ret += F[i] * pow;
            pow *= x;
        }
        return ret;
    }
}
