package UVa.PrimeDistance.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 07/07/2017.
 */
public class Main
{
    private int P = 78498;
    private int[] primes;
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
        int N = (int) 1e6;
        primes = new int[P];
        boolean[] seive = new boolean[N + 1];

        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                seive[j] = false;
            }
        }

        for (int i = 0, j = 0; i < N + 1; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
            }
        }

        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long low = Math.min(a, b);
            long high = Math.max(a, b);

            long minDiff = Integer.MAX_VALUE;
            long minLeft = -1;
            long minRight = -1;

            long maxDiff = -1;
            long maxLeft = -1;
            long maxRight = -1;
            long prev = -1;
            long now = -1;
            for (long i = low; i <= high; i++)
            {
                if (isPrime(i))
                {
                    if (prev == -1)
                    {
                        now = i;
                        prev = i;
                    } else
                    {
                        prev = now;
                        now = i;
                        if (now - prev < minDiff)
                        {
                            minDiff = now - prev;
                            minLeft = prev;
                            minRight = now;
                        }
                        if (now - prev > maxDiff)
                        {
                            maxDiff = now - prev;
                            maxLeft = prev;
                            maxRight = now;
                        }
                    }
                }
            }
            if (minDiff == Integer.MAX_VALUE)
            {
                System.out.println("There are no adjacent primes.");
            } else
            {
                System.out.println(minLeft + "," + minRight + " are closest, " + maxLeft + "," + maxRight + " are most distant.");
            }
        }


    }

    public boolean isPrime(long n)
    {
        if (n < 2)
        {
            return false;
        }
        for (int i = 0; primes[i] * 1L * primes[i] <= n; i++)
        {
            if (n % primes[i] == 0)
            {
                return false;
            }
        }
        return true;
    }
}
