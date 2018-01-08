package UVa.MrAzadAndHisSon.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 07/07/2017.
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
        outer:
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }

            st = new StringTokenizer(line);
            int n = Integer.parseInt(line);
            if (n == 0)
            {
                return;
            }
            long N = -1;
            switch (n)
            {
                case 2:
                    N = 6;
                    break;
                case 3:
                    N = 28;
                    break;
                case 5:
                    N = 496;
                    break;
                case 7:
                    N = 8128;
                    break;
                case 13:
                    N = 33550336;
                    break;
                case 17:
                    N = 8589869056L;
                    break;
                case 19:
                    N = 137438691328L;
                    break;
                case 31:
                    N = 2305843008139952128L;
                    break;
            }
            if (N != -1)
            {

                System.out.println("Perfect: " + N + "!");
            } else
            {
                for (int i = 2; i * i <= n; i++)
                {
                    if (n % i == 0)
                    {
                        System.out.println("Given number is NOT prime! NO perfect number is available.");
                        continue outer;
                    }
                }
                System.out.println("Given number is prime. But, NO perfect number is available.");
            }
        }
    }

    public long isPerfect(long n)
    {
        long sum = 1;
        for (long i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                sum += i;
                if (i != n / i)
                {
                    sum += (n / i);
                }
            }
        }
        return sum;
    }
}
