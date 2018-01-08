package UVa.IncomeTaxHazard.Code1;

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

    //    public void test1() throws IOException
//    {
//        for (; ; )
//        {
//            line = in.readLine();
//            st = new StringTokenizer(line);
//            long m = Long.parseLong(st.nextToken());
//            long x = Long.parseLong(st.nextToken());
//            if (m + x == 0)
//            {
//                return;
//            }
//            if (x == 100 || m == 1 || x == 0)
//            {
//                System.out.println("Not found");
//                continue;
//            }
//
//            double ans = 100 * (m - 1);
//            ans /= (100 - x);
//            if (ans % 1 == 0)
//            {
//                ans--;
//            }
//            long result = (long) ans;
//            if (result >= m)
//            {
//                System.out.println(result);
//            } else
//            {
//                System.out.println("Not found");
//            }
//        }
//    }
    public void solve() throws IOException
    {
        for (; ; )
        {
            line = in.readLine();
            st = new StringTokenizer(line);
            long m = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            if (m + x == 0)
            {
                return;
            }
            if (x == 100 || m == 1 || x == 0)
            {
                System.out.println("Not found");
                continue;
            }

            long low = m - 2;
            long high = (long) 1e15;
            while (high - low > 1)
            {
                long mid = low + (high - low) / 2;
                if (mid * (100 - x) < 100 * (m - 1))
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
            if (low < m)
            {
                System.out.println("Not found");
            } else
            {
                System.out.println(low);
            }


        }
    }
}
