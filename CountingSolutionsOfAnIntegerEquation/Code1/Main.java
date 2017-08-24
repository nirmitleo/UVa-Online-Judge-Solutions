package UVa.CountingSolutionsOfAnIntegerEquation.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 03/07/2017.
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
        for (int n = 1; n < 100; n++)
        {
            int count = 0;
            for (int y = 0; y <= n / 2; y++)
            {
                for (int z = 0; z <= n / 2; z++)
                {
                    int x = n - (2 * (y + z));
                    if (x >= 0 && x <= n)
                    {
                        count++;
                    }
                }
            }
            if (n % 2 == 0)
            {

            }
            System.out.println("For n = " + n + " solutions = " + count + " t[" + n + "] = " + t(n) + "     " + t((n / 2) + 1));
//            System.out.println(count);
        }
    }

    public long t(long n)
    {
        long result = n * (n + 1);
        return result / 2;
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            int n = Integer.parseInt(line.trim());
            System.out.println(t(n / 2 + 1));

        }

    }
}
