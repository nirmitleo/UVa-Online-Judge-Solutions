package UVa.MaximumProduct.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 18/07/2017.
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
        int c = 0;
        for (int t = 1; ; t++)
        {
            while (true)
            {
                line = in.readLine();
                if (line == null || c == 2)
                {
                    System.out.println();
                    return;
                }
                if (line.trim().length() != 0)
                {
                    c = 0;
                    break;
                }
                c++;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = i; j < n; j++)
                {
                    long prod = 1;
                    for (int k = i; k <= j; k++)
                    {
                        prod *= a[k];
                    }
                    result = Math.max(result, prod);
                }
            }
            if (t == 1)
            {
                System.out.println("Case #" + t + ": The maximum product is " + result + ".");
            } else
            {
                System.out.println();
                System.out.println("Case #" + t + ": The maximum product is " + result + ".");
            }
        }

    }
}
