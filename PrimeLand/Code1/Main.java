package UVa.PrimeLand.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 08/07/2017.
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

    public void solve() throws IOException
    {
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0 || line.startsWith("0"))
            {
                return;
            }
            int n = 1;
            st = new StringTokenizer(line);
            while (st.hasMoreTokens())
            {
                int b = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                n *= pow(b, e);
            }
            n -= 1;
            int num = n;
            String sb = "";
            for (int i = 2; i * i <= n; i++)
            {
                int count = 0;
                while (num % i == 0)
                {
                    count++;
                    num /= i;
                }
                if (count > 0)
                {
                    sb = i + " " + count + " " + sb;
                }
            }
            if (num > 1)
            {
                System.out.println((num + " " + 1 + " " + sb).trim());
            } else
            {
                System.out.println(sb.trim());
            }

        }

    }

    public void test()
    {
        System.out.println(pow(2, 5));
    }

    public int pow(int b, int e)
    {
        int result = 1;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                result = result * b;
            }
            b = b * b;
            e /= 2;
        }
        return result;
    }
}
