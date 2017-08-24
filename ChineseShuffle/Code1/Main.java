package UVa.ChineseShuffle.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 02/07/2017.
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
//        demo.test1();
    }

    public void test2()
    {
        System.out.println(isFermat(11111119));
    }

    public void test()
    {
        outer:
        for (int N = 3; N <= 1e5; N++)
        {
            ArrayList<Integer> now = new ArrayList<>();
            ArrayList<Integer> original = new ArrayList<>();
            for (int i = 1; i <= N; i++)
            {
                now.add(i);
                original.add(i);
            }


            for (int i = 0; i < N - 1; i++)
            {
                ArrayList<Integer> next = new ArrayList<>();
                for (int left = 0, right = N / 2; right < N; left++, right++)
                {
                    next.add(now.get(right));
                    next.add(now.get(left));
                }
                now = next;
            }
            for (int i = 0; i < N; i++)
            {
                int a = now.get(i);
                int b = original.get(i);
                if (a != b)
                {
                    if (isPrime(N))
                    {
                        System.out.println(N + " is prime but not jimmy!");
                    }
                    //System.out.println(N + " = Not Jimmy");
                    continue outer;
                }
            }
            //System.out.println(N + " = Jimmy" + " isPrime = " + isPrime(N));
            if (!isPrime(N))
            {
                long num = BigInteger.ONE.shiftLeft(N - 1).mod(BigInteger.valueOf(N)).longValue();
                System.out.println(N + " is not prime but jimmy" + " fermat condition = " + (num == 1));
            }
        }
    }

    public boolean isPrime(int n)
    {
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public void solve() throws IOException
    {
        outer:
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N < 0)
            {
                return;
            }
            if (N % 2 == 0)
            {
                System.out.println(N + " is not a Jimmy-number");
            } else
            {
                if (isFermat(N))
                {
                    System.out.println(N + " is a Jimmy-number");
                } else
                {
                    System.out.println(N + " is not a Jimmy-number");
                }
            }
        }
    }

    public boolean isFermat2(int N)
    {
        long num = BigInteger.valueOf(2).modPow(BigInteger.valueOf(N).subtract(BigInteger.ONE), BigInteger.valueOf(N)).longValue();
        return num == 1;
    }

    public boolean isFermat(int n)
    {
        long x = 1;
        long bx = 2;
        long e = n - 1;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                x = (x * bx) % n;
            }
            bx = bx * bx;
            bx %= n;
            e /= 2;
        }
        return (x % n) == 1;
    }
}
