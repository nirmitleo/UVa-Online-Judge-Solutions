package UVa.f91.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 01/07/2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        //demo.test1();
        demo.test();
    }

    public void test() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            if (n == 0)
            {
                return;
            }
            System.out.println("f91(" + n + ") = " + Math.max(91, n - 10));
        }
    }

    public void solve() throws IOException
    {

        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            if (n == 0)
            {
                return;
            }
            long result = solve(n);
            System.out.println("f91(" + n + ") = " + result);
        }
    }

    public long solve(long n)
    {
        if (n <= 100)
        {
            return solve(solve(n + 11));
        }
        return n - 10;
    }
}
