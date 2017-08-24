package UVa.B2Sequence.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 06/07/2017.
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
        for (int t = 1; ; t++)
        {
            line = in.readLine();
            if (line == null)
            {
                System.out.println();
                return;
            }
            if (line.trim().length() == 0)
            {
                line = in.readLine();
                if (line == null || line.trim().length() == 0)
                {
                    System.out.println();
                    return;
                }
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++)
            {
                if (i == 0 && a[i] < 1)
                {
                    if (t == 1)
                    {
                        System.out.println("Case #" + t + ": It is not a B2-Sequence.");
                    } else
                    {
                        System.out.println("\nCase #" + t + ": It is not a B2-Sequence.");
                    }
                    continue outer;
                } else if (i > 0)
                {
                    if (a[i] <= a[i - 1])
                    {
                        if (t == 1)
                        {
                            System.out.println("Case #" + t + ": It is not a B2-Sequence.");
                        } else
                        {
                            System.out.println("\nCase #" + t + ": It is not a B2-Sequence.");
                        }
                        continue outer;
                    }
                }
            }

            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++)
            {
                for (int j = i; j < n; j++)
                {
                    int sum = a[i] + a[j];
                    if (set.contains(sum))
                    {
                        if (t == 1)
                        {
                            System.out.println("Case #" + t + ": It is not a B2-Sequence.");
                        } else
                        {
                            System.out.println("\nCase #" + t + ": It is not a B2-Sequence.");
                        }
                        continue outer;
                    }
                    set.add(sum);
                }
            }
            if (t == 1)
            {
                System.out.println("Case #" + t + ": It is a B2-Sequence.");
            } else
            {
                System.out.println("\nCase #" + t + ": It is a B2-Sequence.");
            }
        }

    }
}
