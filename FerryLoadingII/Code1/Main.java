package UVa.FerryLoadingII.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 23/06/2017.
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
            int time = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] cars = new int[m];
            for (int i = 0; i < m; i++)
            {
                st = new StringTokenizer(in.readLine());
                cars[i] = Integer.parseInt(st.nextToken());
            }

            int cap = 0;
            int now = 0;
            int count = 0;
            for (int i = 0; i < m; i++)
            {
                int next = Math.max(now, cars[i]);
                if (now < next && cap > 0)
                {
                    count++;
                    cap = 1;
                }
                cap++;
                now = next;
                if (cap == n)
                {
                    cap = 0;
                    count++;
                    now += time + time;
                }
            }
            if (cap > 0)
            {
                count++;
                now += time + time;
            }
            System.out.println((now - time) + " " + count);
        }

    }
}
