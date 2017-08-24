package UVa.EnumeratingRationalNumbers.Code1;

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
        int N = (int) 2e5 + 1;
        long[] E = new long[N + 1];
        int[] e = new int[N + 1];
        e[1] = 2;
        E[1] = 2;
        for (int i = 2; i <= N; i++)
        {
            e[i] = i;
        }
        for (int i = 2; i <= N; i++)
        {
            if (e[i] == i)
            {
                for (int j = i; j <= N; j += i)
                {
                    e[j] -= e[j] / i;
                }
            }
            E[i] = E[i - 1] + e[i];
        }
//        for (int i = 1; i <= 10; i++)
//        {
//            System.out.println(i + " " + E[i]);
//        }
        outer:
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            if (n == 0)
            {
                return;
            }
            if (n == 1)
            {
                System.out.println("0/1");
                continue;
            }
            if (n == 2)
            {
                System.out.println("1/1");
                continue;
            }
            int nr = -1;
            int dr = lowerBound(n, E);
            long now = E[dr - 1];
            for (int i = 1; ; i++)
            {
                int G = gcd(i, dr);
                if (G == 1)
                {
                    now++;
                    if (now == n)
                    {
                        System.out.println(i + "/" + dr);
                        continue outer;
                    }
                }
            }
        }
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lowerBound(long value, long[] a)
    {
        int low = -1;
        int high = a.length;
        while (high - low > 1)
        {
            int mid = low + (high - low) / 2;
            if (a[mid] < value)
            {
                low = mid;
            } else
            {
                high = mid;
            }
        }
        return high;
    }
}
