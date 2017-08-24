package UVa.BoiledEggs.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 20/06/2017.
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
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int w = 0;
            int best = 0;
            for (int i = 0; i < n && best < P; i++)
            {
                if (w + a[i] <= Q)
                {
                    w += a[i];
                    best++;
                }
            }
            System.out.println("Case " + t + ": " + best);

        }

    }
}
