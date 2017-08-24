package UVa.FermatVSPythagoras.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 08/07/2017.
 */
public class Main
{
    private int S = 1000;
    private int[] sq = new int[S + 1];

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }


    public int gcd(int a, int b, int c)
    {
        return gcd(a, gcd(b, c));
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean isSameParity(int a, int b)
    {
        return (a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0);
    }

    public void solve() throws IOException
    {
        int N = 1000000;
        int T = 159139;
        Item[] t = new Item[T];
        TreeSet<Item> set = new TreeSet<Item>();
        for (int n = 1; n * n <= N; n++)
        {
            int n2 = n * n;
            for (int m = n + 1; (m * m) + n2 <= N; m++)
            {
                int m2 = m * m;
                if (!isSameParity(m, n) && gcd(m, n) == 1)
                {
                    int a = m2 - n2;
                    int b = 2 * m * n;
                    int c = m2 + n2;
                    set.add(new Item(a, b, c));
                }
            }
        }
//        System.out.println(max);
//        System.out.println(set.size());
        for (int i = 0; i < T; i++)
        {
            t[i] = set.pollFirst();
        }

        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());

            int c1 = 0;
            boolean[] rest = new boolean[n + 1];
            Arrays.fill(rest, true);
            for (int i = 0; i < T; i++)
            {
                Item item = t[i];
                if (item.a <= n && item.b <= n && item.c <= n)
                {
                    if (Math.min(item.a, Math.min(item.b, item.c)) > n)
                    {
                        break;
                    }
                    if (gcd(item.a, item.b, item.c) == 1)
                    {
                        c1++;
                        for (int d = 1; d * item.c <= n; d++)
                        {
//                        System.out.println(d);
                            rest[item.a * d] = false;
                            rest[item.b * d] = false;
                            rest[item.c * d] = false;
                        }
                    }
                }
            }
            int c2 = 0;
            for (int i = 1; i <= n; i++)
            {
                if (rest[i])
                {
                    c2++;
                }
            }
            System.out.println(c1 + " " + c2);
        }

    }

    class Item implements Comparable<Item>
    {
        int a;
        int b;
        int c;

        public Item(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Item that)
        {
            int aDiff = Integer.compare(this.a, that.a);
            if (aDiff == 0)
            {
                int bDiff = Integer.compare(this.b, that.b);
                return bDiff != 0 ? bDiff : Integer.compare(this.c, that.c);
            }
            return aDiff;
        }

    }
}
