package UVa.Marbles.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/07/2017.
 */
public class Main
{
    private long x;
    private long y;
    private long d;
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                out.flush();
                out.close();
                return;
            }
            st = new StringTokenizer(line);
            long N = Long.parseLong(st.nextToken());
            if (N == 0)
            {
                out.flush();
                out.close();
                return;
            }
            st = new StringTokenizer(in.readLine());
            long c1 = Long.parseLong(st.nextToken());
            long n1 = Long.parseLong(st.nextToken());

            st = new StringTokenizer(in.readLine());
            long c2 = Long.parseLong(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());

            gcd(n1, n2);
            if (N % d != 0)
            {
                out.println("failed");
                continue;
            }
            x *= N / d;
            y *= N / d;
            long A = n1 / d;
            long B = n2 / d;

            long start = (long) Math.ceil(-x / (B * 1.0));
            long end = (long) Math.floor(y / (A * 1.0));
            long bag1 = -1;
            long bag2 = -1;
            long min = Long.MAX_VALUE;
            if (start > end)
            {
                out.println("failed");
                continue;
            }
            long X = x + (B * start);
            long Y = y - (A * start);
            long cost = (X * c1) + (Y * c2);
            if (cost < min && (X * n1 + Y * n2 == N))
            {
                min = cost;
                bag1 = X;
                bag2 = Y;
            }
            X = x + (B * end);
            Y = y - (A * end);
            cost = (X * c1) + (Y * c2);
            if (cost < min && (X * n1 + Y * n2 == N))
            {
                min = cost;
                bag1 = X;
                bag2 = Y;
            }
            if (min == Long.MAX_VALUE)
            {
                out.println("failed");
            } else
            {
                out.println(bag1 + " " + bag2);
            }

        }

    }

    public void gcd(long a, long b)
    {
        if (b == 0)
        {
            x = 1;
            y = 0;
            d = a;
            return;
        }
        gcd(b, a % b);
        long x1 = y;
        long y1 = x - ((a / b) * y);
        x = x1;
        y = y1;
    }
}
