package UVa.RareEasyProblem.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            if (n == 0)
            {
                return;
            }
            long A = 9;
            long B = 1;
            gcd(A, B);
            if (n % d != 0)
            {
                throw new RuntimeException();
            }
            x *= n / d;
            y *= n / d;
            B = B / d;
            A = A / d;
            long start = (x + B - 1) / B;
            start *= -1;
            long end = y / A;
            String result = "";
            for (long i = start; i <= end; i++)
            {
                long X = x + (B * i);
                long Y = y - (A * i);
                if (9 * X + Y == n && X > 0 && Y >= 0 && Y <= 9)
                {
                    result += (X * 10 + Y) + " ";
                }
            }
            System.out.println(result.trim());
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
