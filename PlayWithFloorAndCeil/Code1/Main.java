package UVa.PlayWithFloorAndCeil.Code1;

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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long A = a / b;
            long B = (a + b - 1) / b;
            gcd(A, B);
            if (a % d == 0)
            {
                x *= a / d;
                y *= a / d;
                System.out.println(x + " " + y);
            } else
            {
                throw new RuntimeException();
            }
        }
    }

    public void gcd(long a, long b)
    {
        if (b == 0)
        {
            d = a;
            x = 1;
            y = 0;
            return;
        }
        gcd(b, a % b);
        long x1 = y;
        long y1 = x - ((a / b) * y);
        x = x1;
        y = y1;


    }
}
