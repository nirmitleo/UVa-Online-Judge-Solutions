package UVa.PrimeFactors.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 08/07/2017.
 */
public class Main
{
    int N = 46340;
    int P = 4792;
    int[] primes = new int[P];
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }

    public void test()
    {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }

    public void solve() throws IOException
    {
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
//        int count = 0;
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (seive[i])
            {
//                count++;
                primes[j++] = i;
            }
        }
//        System.out.println(count);

        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                out.flush();
                out.close();
                return;
            }
            ArrayList<Integer> f = new ArrayList<>();
            int num = n;
            if (num < 0)
            {
                f.add(-1);
                num = -num;
            }
            int limit = num;
            for (int i = 0; i < P && primes[i] * primes[i] <= limit; i++)
            {
                while (num % primes[i] == 0)
                {
                    f.add(primes[i]);
                    num /= primes[i];
                }
            }
            if (num > 1)
            {
                f.add(num);
            }

            StringBuilder result = new StringBuilder(n + " = ");
            Collections.sort(f);
            for (int i = 0; i < f.size(); i++)
            {
                if (i == 0)
                {
                    result.append(f.get(i));
                } else
                {
                    result.append(" x " + f.get(i));
                }
            }
            out.println(result);

        }

    }
}
