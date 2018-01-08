package UVa.Popes.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 27-05-2017.
 */
public class Main
{
    private int n;
    private int[] a;

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
        while (true)
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            if (line.trim().length() == 0)
            {
                continue;
            }

            int years = Integer.parseInt(line);
            n = Integer.parseInt(in.readLine());

            a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(in.readLine());
            }
            //System.out.println("years = " + Arrays.toString(a));
            int start = -1;
            int end = -1;
            int max = -1;
            for (int i = 0; i < n; i++)
            {
                int sy = a[i];
                int ey = a[i] + years - 1;
                int low = i - 1;
                int high = n;
                while (high - low > 1)
                {
                    int mid = low + (high - low) / 2;
                    if (a[mid] <= ey)
                    {
                        low = mid;
                    } else
                    {
                        high = mid;
                    }
                }

                if (max < low - i + 1)
                {
                    max = low - i + 1;
                    start = a[i];
                    end = a[low];
                }
            }
            if (start < 0)
            {
                throw new RuntimeException();
            }
            System.out.println(max + " " + start + " " + end);
        }
    }
}
