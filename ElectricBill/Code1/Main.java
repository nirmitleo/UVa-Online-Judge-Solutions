package UVa.ElectricBill.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 26-05-2017.
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
        demo.solve();
    }


    public void solve() throws IOException
    {
        while (true)
        {
            st = new StringTokenizer(in.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            if (A == 0 && B == 0)
            {
                out.flush();
                out.close();
                return;
            }

            long plusPower = getPower(A);


            long low = 0;
            long high = plusPower;
            for (int i = 0; i < 200; i++)
            {
                long y = low + high;
                y /= 2;

                long yPay = getPay(y);
                long xPay = getPay(plusPower - y);
                if (xPay - yPay <= B)
                {
                    high = y;
                } else
                {
                    low = y;
                }
            }
            out.println(getPay(high));
        }
    }

    public long getPower(long pay)
    {
        long low = 0;
        long high = (long) 1e9;
        for (int b = 0; b <= 100; b++)
        {
            long mid = low + high;
            mid /= 2;
            long ans = getPay(mid);
            if (ans >= pay)
            {
                high = mid;
            } else
            {
                low = mid;
            }
        }
        return high;
    }

    public long getPay(long power)
    {
        long pay = 0;
        if (power > 0)
        {
            if (power >= 100)
            {
                pay += 200;
                power -= 100;
            } else
            {
                pay += (power * 2);
                power -= 100;
            }
        }
        if (power > 0)
        {
            if (power >= 9900)
            {
                pay += (3 * 9900);
                power -= 9900;
            } else
            {
                pay += (power * 3);
                power -= 9900;
            }
        }
        if (power > 0)
        {
            if (power >= 990000)
            {
                pay += (5 * 990000);
                power -= 990000;
            } else
            {
                pay += (power * 5);
                power -= 990000;
            }
        }
        if (power > 0)
        {
            pay += (power * 7);
        }
        return pay;
    }
}
