package UVa.InternalRateOfReturn.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 26-05-2017.
 */
public class Main
{
    private int t;
    private double[] cf;


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
        while (true)
        {
            st = new StringTokenizer(in.readLine());
            t = Integer.parseInt(st.nextToken()) + 1;
            if (t == 1)
            {
                return;
            }

            cf = new double[t];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < t; i++)
            {
                cf[i] = Long.parseLong(st.nextToken());
            }

            double low = -1;
            double high = 1e9;
            for (int i = 0; i <= 100; i++)
            {
                double mid = low + high;
                mid /= 2;
                double ans = f(mid);
                if (ans < 0)
                {
                    high = mid;
                } else
                {
                    low = mid;
                }
            }

            String result = String.format("%.2f", low);

            //System.out.println("IRR = " + result);
            System.out.println(result);

        }

    }

    public double f(double irr)
    {
        double ans = 0;
        for (int i = 0; i < t; i++)
        {
            ans += (cf[i] / power((1 + irr), i));
        }
        return ans;
    }

    public double power(double base, int e)
    {
        double ans = 1;
        for (int i = 1; i <= e; i++)
        {
            ans *= base;
        }
        return ans;
    }
}
