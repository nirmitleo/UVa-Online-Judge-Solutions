package UVa.Antimonotonicity.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 22/06/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int best = 0;
            int prev = -1;
            boolean up = true;
            for (int i = 0; i < n; i++)
            {
                if (up)
                {
                    if (a[i] < prev)
                    {
                        prev = a[i];
                    }
                    if (a[i] > prev)
                    {
                        up = !up;
                        prev = a[i];
                        best++;
                    }
                } else
                {
                    if (a[i] > prev)
                    {
                        prev = a[i];
                    }
                    if (a[i] < prev)
                    {
                        up = !up;
                        prev = a[i];
                        best++;
                    }
                }
            }
            System.out.println(best);
        }

    }
}
