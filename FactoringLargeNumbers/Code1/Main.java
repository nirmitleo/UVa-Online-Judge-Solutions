package UVa.FactoringLargeNumbers.Code1;

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
        long[] primes = new long[P];
//        ArrayList<Long> primes = new ArrayList<Long>();

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
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
//                primes.add(i * 1L);
            }
        }
//        System.out.println("done 1");
//        outer:
//        for (long i = N + 1; i <= 1e9; i += 2)
//        {
//            long n = i;
//            for (int j = 0; ; j++)
//            {
//                long p = primes.get(j);
//                if (p * p > i)
//                {
//                    break;
//                }
//                if (n % p == 0)
//                {
//                    continue outer;
//                }
//            }
//            primes.add(i);
//        }
//        System.out.println("done 2");

        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            if (n < 0)
            {
                return;
            }
            long limit = n;
            for (int i = 0; i < P && primes[i] * primes[i] <= limit; i++)
            {
                while (n % primes[i] == 0)
                {
                    System.out.println("    " + primes[i]);
                    n /= primes[i];
                }
            }
            if (n > 1)
            {
                System.out.println("    " + n);
            }
            System.out.println();
        }

    }
}
