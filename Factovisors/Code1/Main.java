package UVa.Factovisors.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//        demo.test();
        demo.go();
    }

    public void go() throws IOException
    {
        outer2:
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int F = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (M == 0 || (F == 0 && M == 1))
            {
                System.out.println(M + " divides " + F + "!");
                continue outer2;
            }
            int num = M;
            outer:
            for (int i = 2; i * i <= M && num > 1; i++)
            {
                int count = 0;
                while (num % i == 0)
                {
                    num /= i;
                    count++;
                }
                if (count > 0)
                {
                    for (int j = 2; j <= F; j++)
                    {
                        int n = j;
                        while (n % i == 0)
                        {
                            count--;
                            n /= i;
                            if (count == 0)
                            {
                                continue outer;
                            }
                        }
                    }
                    if (count > 0)
                    {
                        System.out.println(M + " does not divide " + F + "!");
                        continue outer2;
                    }
                }
            }
            if (num >= 1)
            {
                if (num >= 1 && num <= F)
                {
                    System.out.println(M + " divides " + F + "!");
                    continue outer2;
                }
            }
            System.out.println(M + " does not divide " + F + "!");
        }
    }

//    public void test() throws IOException
//    {
//        outer:
//        for (; ; )
//        {
//            line = in.readLine();
//            if (line == null || line.trim().length() == 0)
//            {
//                return;
//            }
//            st = new StringTokenizer(line);
//            int n = Integer.parseInt(st.nextToken());
//            TreeMap<Integer, Integer> internalMap = new TreeMap<Integer, Integer>();
//            for (int i = 2; i <= n; i++)
//            {
//                int num = i;
//                for (int j = 2; j * j <= i; j++)
//                {
//                    int count = 0;
//                    while (num % j == 0)
//                    {
//                        num /= j;
//                        count++;
//                    }
//                    if (count > 0)
//                    {
//                        Integer c = internalMap.get(j);
//                        c = c == null ? count : c + count;
//                        internalMap.put(j, c);
//                    }
//                }
//                if (num > 1)
//                {
//                    Integer c = internalMap.get(num);
//                    c = c == null ? 1 : c + 1;
//                    internalMap.put(num, c);
//                }
//            }
//
//            TreeMap<Integer, Integer> d = new TreeMap<Integer, Integer>();
//            int m = Integer.parseInt(st.nextToken());
//            int limit = m;
//            for (int i = 2; i * i <= limit; i++)
//            {
//                int count = 0;
//                while (m % i == 0)
//                {
//                    m /= i;
//                    count++;
//                }
//                if (count > 0)
//                {
//                    Integer c1 = d.get(i);
//                    c1 = c1 == null ? count : c1 + count;
//                    Integer c2 = internalMap.get(i);
//                    if (c2 == null || c2.compareTo(c1) < 0)
//                    {
//                        System.out.println(limit + " does not divide " + n + "!");
//                        continue outer;
//                    }
//                }
//            }
//            if (m > 1)
//            {
//                Integer c1 = d.get(m);
//                c1 = c1 == null ? 1 : c1 + 1;
//                Integer c2 = internalMap.get(m);
//                if (c2 == null || c2.compareTo(c1) < 0)
//                {
//                    System.out.println(limit + " does not divide " + n + "!");
//                    continue outer;
//                }
//            }
//            System.out.println(limit + " divides " + n + "!");
//        }
//    }

}
