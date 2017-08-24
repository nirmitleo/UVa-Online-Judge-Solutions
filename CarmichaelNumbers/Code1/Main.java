package UVa.CarmichaelNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 05/07/2017.
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
//        demo.test1();
    }

    public void solve() throws IOException
    {
        int N = 65000;
        boolean isPrime[] = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                isPrime[j] = false;
            }
        }

        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            boolean ok = true;
            if (!isPrime[n])
            {
                for (int i = 2; i <= n - 1; i++)
                {
                    long result = pow(i, n, n);
                    if (result != i)
                    {
                        ok = false;
                        break;
                    }
                }
                if (ok)
                {
                    System.out.print("The number " + n + " is a Carmichael number.\n");
                } else
                {
                    System.out.println(n + " is normal.");
                }
            } else
            {
                System.out.println(n + " is normal.");
            }
        }
    }

    public void test()
    {
        int b = 2;
        int e = 5;
        System.out.println(pow(b, e, 1000));
    }

    public long pow(long b, int e, int mod)
    {
        long result = 1;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                result = result * b;
                result %= mod;
            }
            b = b * b;
            b %= mod;
            e /= 2;
        }
        return result;
    }
}
