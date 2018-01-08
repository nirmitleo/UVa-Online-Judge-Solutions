package UVa.LargestPrimeDivisor.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 10/07/2017.
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
        int N = (int) 1e7;
        int P = 664579;
        boolean[] seive = new boolean[N + 1];
        int[] primes = new int[P];
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
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            if (n == 0)
            {
                return;
            }
            n = Math.abs(n);
            int count = 0;
            long limit = n;
            long result = -1;
            for (int i = 0; i < P && primes[i] * primes[i] <= limit; i++)
            {
                if (n % primes[i] == 0)
                {
                    count++;
                }
                while (n % primes[i] == 0)
                {
                    n /= primes[i];
                    result = Math.max(result, primes[i]);

                }
            }
            if (n > 1)
            {
                count++;
                result = Math.max(result, n);
            }
            if (count == 1)
            {
                System.out.println(-1);
                continue;
            }
            System.out.println(result);

        }

    }
}
