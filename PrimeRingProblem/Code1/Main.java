package UVa.PrimeRingProblem.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/06/2017.
 */
public class Main
{
    private int n;
    private int[] a;
    private boolean[] was;
    private int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
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
        for (int t = 1; ; t++)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            a = new int[n];
            was = new boolean[n + 1];
            if (t == 1)
            {
                System.out.println("Case " + t + ":");
            } else
            {
                System.out.println("\nCase " + t + ":");
            }
            go(0);
        }
    }

    public void go(int i)
    {
        if (i == n)
        {
            String result = "";
            for (int j = 0; j < n; j++)
            {
                result += a[j] + " ";
            }
            System.out.println(result.trim());
        } else if (i == 0)
        {
            a[i] = 1;
            was[1] = true;
            go(i + 1);
        } else
        {

            for (int j = 1; j < n + 1; j++)
            {
                if (!was[j])
                {
                    a[i] = j;
                    if (ok(i))
                    {
                        was[j] = true;
                        go(i + 1);
                        was[j] = false;
                    }
                }
            }
        }
    }

    public boolean ok(int i)
    {
        if (i == 0)
        {
            return true;
        } else
        {
            int sum = a[i] + a[i - 1];
            int index = Arrays.binarySearch(primes, sum);
            if (index >= 0 && index < 11)
            {
                if (i == n - 1)
                {
                    index = Arrays.binarySearch(primes, a[n - 1] + a[0]);
                    return index >= 0 && index < 11;
                }
                return true;
            }
            return false;
        }
    }
}

