package UVa.JoanaAndTheOddNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 02/07/2017.
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
        long num = 1;
        long prev = -1;
        long diffPrev = -1;
        for (int i = 1, j = 1; i <= 30; i++, j += 2)
        {
            String p = "";
            long sum = 0;
            for (int k = 1; k <= j; k++)
            {
                //System.out.print(num + " ");
                if (k >= j - 2)
                {
                    p += num + " ";
                    sum += num;
                }
                num += 2;
            }
            System.out.println("N = " + j + " ******* Sum = " + sum + " p = (" + p + ")" + " diff = " + (sum - prev) + ", diff = " + ((sum - prev) - diffPrev));
            diffPrev = sum - prev;
            prev = sum;

        }
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
            st = new StringTokenizer(line);
            long N = Long.parseLong(st.nextToken());
            if (N == 1)
            {
                System.out.println(1);
            } else
            {
                N -= 1;
                N /= 2;
                long a = (2 * N * N) + (4 * N - 3);
                long b = a + 2;
                long c = b + 2;
//                System.out.println(a + " " + b + " " + c + " " + " sum = " + (a + b + c));
                System.out.println(a + b + c);
            }
        }

    }
}
