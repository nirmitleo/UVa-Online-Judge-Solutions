package UVa.LCMCardinality.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/07/2017.
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
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            ArrayList<Integer> f = new ArrayList<Integer>();
            for (int i = 1; i * i <= n; i++)
            {
                if (n % i == 0)
                {
                    f.add(i);
                    if (n / i != i)
                    {
                        f.add(n / i);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < f.size(); i++)
            {
                for (int j = i + 1; j < f.size(); j++)
                {
                    if (lcm(f.get(i), f.get(j)) == n)
                    {
                        count++;
                    }
                }
            }
            System.out.println(n + " " + (count + 1));

        }

    }

    public int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
