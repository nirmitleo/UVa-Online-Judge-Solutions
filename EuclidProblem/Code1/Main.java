package UVa.EuclidProblem.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/07/2017.
 */
public class Main
{
    private int x;
    private int y;
    private int d;
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
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            x = 0;
            y = 0;
            d = 0;
            gcd(a, b);
            System.out.println(x + " " + y + " " + d);
        }

    }

    public void gcd(int a, int b)
    {
        if (b == 0)
        {
            d = a;
            x = 1;
            y = 0;
            return;
        }
        gcd(b, a % b);
        int x1 = y;
        int y1 = x - (a / b) * y;
        x = x1;
        y = y1;
    }
}
