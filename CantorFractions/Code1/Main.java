package UVa.CantorFractions.Code1;

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
//        demo.test1();
        demo.test();
    }

    public void test() throws IOException
    {
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            long N = Long.parseLong(st.nextToken());
            if (N == 1)
            {
                System.out.println("1/1");
            } else
            {
                //-b + SQRT(b^2 - 4ac)//
                long i = -1 + (long) Math.sqrt(1 + (8 * N));
                i /= 2;
                long T = t(i);
                if (T == N)
                {
                    System.out.println(1 + "/" + i);
                } else
                {
                    i = i + 1;
                    T = t(i);
                    long diff = T - N;
                    System.out.println((1 + diff) + "/" + (i - diff));
                }
            }
        }
    }

    public long t(long n)
    {
        return (n * n + n) / 2;
    }
}
