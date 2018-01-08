package UVa.HumbleNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 04/07/2017.
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

    public void test()
    {
        for (int i = 1; i <= 5842; i++)
        {
            System.out.println(i);
        }
    }

    public void solve() throws IOException
    {
        int N = 5842 + 1;
        long[] h = new long[N];

        TreeSet<Long> q = new TreeSet<Long>();
        q.add(1L);
        for (int i = 1; i < N; i++)
        {
            long n = q.pollFirst();
            h[i] = n;
            q.add(n * 2);
            q.add(n * 3);
            q.add(n * 5);
            q.add(n * 7);
        }
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            System.out.println("The " + getPrefix(n) + " humble number is " + h[n] + ".");
        }
    }

    public String getPrefix(int n)
    {
        if (n % 10 == 1)
        {
            if (n % 100 != 11)
            {
                return n + "st";
            }
        }
        if (n % 10 == 2)
        {
            if (n % 100 != 12)
            {
                return n + "nd";
            }
        }
        if (n % 10 == 3)
        {
            if (n % 100 != 13)
            {
                return n + "rd";
            }
        }
        return n + "th";
    }
}
