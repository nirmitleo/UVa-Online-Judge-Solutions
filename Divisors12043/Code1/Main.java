package UVa.Divisors12043.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/07/2017.
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
        int N = (int) 1e5;
        int[] d = new int[N + 1];
        long[] sd = new long[N + 1];
        sd[1] = 1;
        d[1] = 1;
        for (int i = 2; i <= N; i++)
        {
            if (d[i] == 0)
            {
                for (int j = i; j <= N; j += i)
                {
                    int num = j;
                    int count = 0;
                    while (num % i == 0)
                    {
                        num /= i;
                        count++;
                    }
                    sd[j] = Math.max(1, sd[j]);
                    sd[j] *= (pow(i, count + 1) - 1);
                    sd[j] /= (i - 1);
                    d[j] = Math.max(1, d[j]);
                    d[j] *= (count + 1);
                }
            }
        }
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (start % k != 0)
            {
                start = ((start + k) / k) * k;
            }

            long ans1 = 0;
            long ans2 = 0;
            for (int i = start; i <= end; i += k)
            {
                ans1 += sd[i];
                ans2 += d[i];
            }
            System.out.println(ans2 + " " + ans1);
        }

    }

    private long pow(long b, int e)
    {
        long result = 1L;
        while (e > 0)
        {
            if ((e & 1) > 0)
            {
                result = result * b;
            }
            e >>= 1;
            b = b * b;
        }
        return result;
    }
}
