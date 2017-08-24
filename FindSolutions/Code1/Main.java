package UVa.FindSolutions.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
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
//        demo.test();
        demo.anotherSolve();
    }

    public void anotherSolve() throws IOException
    {
        int N = (int) 3e7;
        int P = (int) 1857859;
        int[] primes = new int[P];
        boolean[] isComposite = new boolean[N + 1];
        for (int i = 2, k = 0; i <= N; i++)
        {
            if (!isComposite[i])
            {
                primes[k++] = i;
                for (long j = i * 1L * i; j <= N; j += i)
                {
                    isComposite[(int)j] = true;
                }
//                System.out.println(k);
            }
        }
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long C = Long.parseLong(st.nextToken());
            long num = C;
            if (C == 0)
            {
                return;
            }
            C = 4 * C - 3;
            long result = 1;
            for (int i = 0; i < P && primes[i] * 1L * primes[i] <= C; i++)
            {
                int count = 0;
                while (C % primes[i] == 0)
                {
                    count++;
                    C /= primes[i];
                }
                if (count > 0)
                {
                    result *= (count + 1);
                }
            }
            if (C > 1)
            {
                result *= 2;
            }
            System.out.println(num + " " + result);
        }
    }

    public void solve() throws IOException
    {
        int N = (int) 3e7;
        int P = 1857859;
        boolean[] seive = new boolean[N + 1];
        int[] primes = new int[P];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (long i = 2; i * i <= N; i++)
        {
            for (long j = i * i; j <= N; j += i)
            {
                seive[(int) j] = false;
            }
        }
//        int c = 0;
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (seive[i])
            {
//                c++;
                primes[j++] = i;
            }
        }
//        System.out.println(c);


        for (; ; )
        {
            long C = Long.parseLong(in.readLine().trim());
            long temp = C;
            if (temp == 0)
            {
                return;
            }

//            C = C.multiply(BigInteger.valueOf(4L));
//            C = C.subtract(BigInteger.valueOf(3L));
            C = 4 * C - 3;
            long result = 1;
            for (int i = 0; i < P && primes[i] * 1L * primes[i] <= C; i++)
            {
                int count = 0;
                while (C % primes[i] == 0)
                {
                    count++;
                    C /= primes[i];
                }
                if (count > 0)
                {
                    result *= (count + 1);
                }
            }
            if (C > 1)
            {
                result *= 2;
            }
            System.out.println(temp + " " + result);
        }
    }

    public boolean check(BigInteger now, BigInteger C)
    {
        return now.multiply(now).compareTo(C) <= 0;
    }
}
