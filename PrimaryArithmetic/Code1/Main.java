package UVa.PrimaryArithmetic.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24/06/2017.
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
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (a + b == 0)
            {
                return;
            }
            int count = 0;
            int carry = 0;
            for (; a > 0 || b > 0; )
            {
                long d1 = a % 10;
                long d2 = b % 10;
                if (d1 + d2 + carry >= 10)
                {
                    count++;
                    carry = 1;
                } else
                {
                    carry = 0;
                }
                a /= 10;
                b /= 10;
            }
            if (count == 0)
            {
                System.out.println("No carry operation.");
            } else if (count == 1)
            {
                System.out.println("1 carry operation.");
            } else
            {
                System.out.println(count + " carry operations.");
            }
        }

    }
}
