package UVa.DateBugs.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/06/2017.
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
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                System.out.println();
                return;
            }

            int start = Integer.MIN_VALUE;
            int[] d = new int[n];
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                d[i] = Integer.parseInt(st.nextToken());
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
                start = Math.max(start, d[i]);
            }

            int year = -1;
            outer:
            for (int i = start; i < 10000; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int mod = b[j] - a[j];
                    int dist = i - a[j];
                    if (a[j] + (dist % mod) != d[j])
                    {
                        continue outer;
                    }
                }
                year = i;
                break;
            }
            if (t == 1)
            {
                System.out.println("Case #" + t + ":");
                if (year == -1)
                {
                    System.out.println("Unknown bugs detected.");
                } else
                {
                    System.out.println("The actual year is " + year + ".");
                }
            } else
            {
                System.out.println("\nCase #" + t + ":");
                if (year == -1)
                {
                    System.out.println("Unknown bugs detected.");
                } else
                {
                    System.out.println("The actual year is " + year + ".");
                }
            }
        }
    }
}
