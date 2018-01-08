package UVa.IrreducibleBasicFractions.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/07/2017.
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
        int N = 123456;
        int result = N;
        for (long i = 2; i * i <= N; i++)
        {
            int count = 0;
            while (N % i == 0)
            {
                N /= i;
                count++;
            }
            if (count > 0)
            {
                result /= i;
                result *= (i - 1);
            }
        }
        if (N > 1)
        {
            result /= N;
            result *= (N - 1);
        }
        System.out.println(result);
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            int result = n;
            for (int i = 2; i * 1L * i <= n; i++)
            {
                int count = 0;
                while (n % i == 0)
                {
                    count++;
                    n /= i;
                }
                if (count > 0)
                {
                    result /= i;
                    result *= (i - 1);
                }
            }
            if (n > 1)
            {
                result /= n;
                result *= (n - 1);
            }
            System.out.println(result);
        }

    }
}
