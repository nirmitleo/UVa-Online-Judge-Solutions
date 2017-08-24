package UVa.GCDLCM.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by Nirmit on 09/07/2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
//        demo.test1();
        demo.test();
    }

    public void test() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            long G = Integer.parseInt(st.nextToken());
            long L = Integer.parseInt(st.nextToken());
            TreeMap<Long, Integer> g = pf(G);
            TreeMap<Long, Integer> l = pf(L);

            long a = 1;
            long b = 1;

            for (Map.Entry<Long, Integer> entry : g.entrySet())
            {
                long key = entry.getKey();
                int count = entry.getValue();
                for (int i = 1; i <= count; i++)
                {
                    a *= key;
                    b *= key;
                }
                if (l.containsKey(key))
                {
                    l.put(key, l.get(key) - count);
                }
            }
            for (Map.Entry<Long, Integer> entry : l.entrySet())
            {
                long key = entry.getKey();
                int count = entry.getValue();
                for (int i = 1; i <= count; i++)
                {
                    a *= key;
                }
            }
            if (a > L)
            {
                System.out.println(-1);
                continue;
            }
            System.out.println(b + " " + a);
        }
    }

    public TreeMap<Long, Integer> pf(long n)
    {
        long num = n;
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (long i = 2; i * i <= num; i++)
        {
            int count = 0;
            while (n % i == 0)
            {
                count++;
                n /= i;
            }
            if (count > 0)
            {
                map.put(i, count);
            }
        }
        if (n > 0)
        {
            map.put(n, 1);
        }
        return map;
    }

    public void solve() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        outer:
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            long G = Long.parseLong(st.nextToken());
            long L = Long.parseLong(st.nextToken());
            if (L % G == 0)
            {
                out.println(G + " " + L);
                continue;
            }
            long P = G * L;
//            System.out.println(P);
//            System.out.println("sqrt = " + Math.sqrt(P));
            for (long i = 1; i * i <= P; i++)
            {
                if (P % i == 0)
                {
                    long g = gcd(i, P / i);
                    long l = lcm(i, P / i);
                    if (g == G && l == L)
                    {
                        out.println(i + " " + (P / i));
                        continue outer;
                    }
                }
            }
            out.println(-1);
        }
        out.flush();
        out.close();
    }

    public long lcm(long a, long b)
    {
        return a / gcd(a, b) * b;
    }

    public long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
