package UVa.Antiarithmetic.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nirmit on 17/07/2017.
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
//        demo.test1(new int[]{1, 2, 3, 4, 5, 6});
//        for (int t = 1; t <= 10; t++)
//        {
//            demo.test1();
//        }
//        demo.run();
    }

    public void run()
    {
        boolean result = test2(new int[]{2, 0, 1, 3, 4});
    }

    public void test()
    {
        Random r = new Random();
        int N = r.nextInt(10);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < N; i++)
        {
            a.add(i);
        }
        Collections.shuffle(a);
        int[] b = new int[N];
        for (int i = 0; i < N; i++)
        {
            b[i] = a.get(i);
        }
        boolean result1 = test1(b);
        boolean result2 = test2(b);
        if (result1 != result2)
        {
            System.out.println("TestClass failed!");
            System.out.println(Arrays.toString(b));
            System.out.println("Slow = " + result1);
            System.out.println("Fast = " + result2);
        }
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("*********************");
    }

    public boolean test1(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if (a[i] - a[j] == a[j] - a[k])
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean test2(int[] a)
    {
        int n = a.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++)
        {
            p[i] = a[i];
            if (i > 0)
            {
                p[i] += p[i - 1];
            }
        }
        for (int i = 0; i < n - 2; i++)
        {
            for (int j = i + 1; j < n - 1; j++)
            {
                if (i != j)
                {
                    int first = a[i];
                    int second = a[j];
                    int third = a[j] + (a[j] - a[i]);
                    if (first != third && second != third && third >= 1 && third <= n)
                    {
                        if ((p[n - 1] - p[j]) % third == 0)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void solve() throws IOException
    {
        outer:
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }

            st = new StringTokenizer(line);
            String s = st.nextToken();
            if (s.startsWith("0"))
            {
                return;
            }
            s = s.substring(0, s.indexOf(":"));
            int n = Integer.parseInt(s);

            int[] a = new int[n];
            int[] index = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
                index[a[i]] = i;
            }
            for (int i = 0; i < n - 2; i++)
            {
                for (int j = i + 1; j < n - 1; j++)
                {
                    int first = a[i];
                    int second = a[j];
                    int third = second + (second - first);
                    if (third >= 0 && third < n && index[third] > j)
                    {
                        System.out.println("no");
                        continue outer;
                    }
                }
            }
            System.out.println("yes");
        }
    }
}
