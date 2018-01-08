package UVa.LCM.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by Nirmit on 11/07/2017.
 */
public class Main
{
    private int M = (int) 1e6;
    private int P = 78498;
    private boolean seive[];
    private TreeMap<Integer, Integer> primes;

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
//        demo.test();
//        demo.test();
        demo.solve2();
//        demo.stressSeive();
    }

    public void solve2() throws IOException
    {
        seive();
        long[] result = new long[M + 1];
        result[1] = 1;
        long L = 1;
        for (int i = 2; i <= M; i++)
        {
            int num = i;
            for (int j = 2; j * j <= num; j++)
            {
                int count = 0;
                while (num % j == 0)
                {
                    num /= j;
                    count++;
                }
                if (count > 0)
                {
                    int c = primes.get(j);
                    if (count > c)
                    {
                        L *= j;
                        while (L % 10 == 0)
                        {
                            L /= 10;
                        }
                        L %= 1e6;
                        primes.put(j, count);
                    }
                }
            }
            if (num > 1)
            {
                int c = primes.get(num);
                if (c < 1)
                {
                    L *= num;
                    while (L % 10 == 0)
                    {
                        L /= 10;
                    }
                    L %= 1e6;
                    primes.put(num, 1);
                }
            }
            result[i] = L;
        }
//        System.out.println("done");
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0)
            {
                return;
            }
            System.out.println(result[N] % 10);
        }

    }

    public void test()
    {
        int N = 100;
        for (int i = N; i >= N - 100; i--)
        {
            System.out.println(i);
        }
        System.out.println(0);
    }


    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0)
            {
                return;
            }
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = 2; i <= N; i++)
            {
                int num = i;
                for (int j = 2; j * j <= num; j++)
                {
                    int count = 0;
                    while (num % j == 0)
                    {
                        num /= j;
                        count++;
                    }
                    if (count > 0)
                    {
                        Integer c = map.get(j);
                        c = (c == null) ? 0 : c;
                        c = Math.max(c, count);
                        map.put(j, c);
                    }
                }
                if (num > 1)
                {
                    Integer c = map.get(num);
                    c = (c == null) ? 0 : c;
                    c = Math.max(c, 1);
                    map.put(num, c);
                }
            }

            Integer two = map.get(2);
            Integer five = map.get(5);
            two = two == null ? 0 : two;
            five = five == null ? 0 : five;
            int min = Math.min(two, five);
            map.put(2, two - min);
            map.put(5, five - min);
            long result = 1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                int key = entry.getKey();
                int value = entry.getValue();
                for (int i = 1; i <= value; i++)
                {
                    result = result * key;
                    while (result % 10 == 0)
                    {
                        result = result / 10;
                    }
                    result = result % 10;
                }
            }
            System.out.println(result % 10);
        }
    }

    public void stressSeive()
    {
        seive();
        for (int i = 2; i < 1e8; i++)
        {
            boolean b1 = isPrime(i);
            boolean b2 = seive[i];
            if ((b1 && !b2) || (b2 && !b1))
            {
                System.out.println(i);
            }
        }
    }

    public boolean isPrime(int N)
    {
        for (long i = 2; i * i <= N; i++)
        {
            if (N % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public void seive()
    {
        seive = new boolean[M + 1];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i * i <= M; i++)
        {
            for (int j = i * i; j <= M; j += i)
            {
                seive[j] = false;
            }
        }
        primes = new TreeMap<Integer, Integer>();
        for (int i = 0; i <= M; i++)
        {
            if (seive[i])
            {
                primes.put(i, 0);
            }
        }
    }

    public long pow(long b, int e)
    {
        long result = 1L;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                result = result * b;
            }
            b = b * b;
            e /= 2;
        }
        return result;
    }
}
