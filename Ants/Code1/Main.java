package UVa.Ants.Code1;

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
        while (true)
        {
            line = in.readLine();
            if (line.trim().length() != 0)
            {
                break;
            }
        }
        st = new StringTokenizer(line);
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            while (true)
            {
                line = in.readLine();
                if (line == null)
                {
                    return;
                }
                if (line.trim().length() != 0)
                {
                    break;
                }
            }
            st = new StringTokenizer(line);
            long L = Long.parseLong(st.nextToken());

            int n = 0;
            if (!st.hasMoreTokens())
            {
                st = new StringTokenizer(in.readLine());
                n = Integer.parseInt(st.nextToken());
            } else
            {
                n = Integer.parseInt(st.nextToken());
            }

            long min = 0;
            long max = 0;
            while (true)
            {
                line = in.readLine();
                if (line.trim().length() != 0)
                {
                    break;
                }
            }
            st = new StringTokenizer(line);
            for (int i = 0; i < n; i++)
            {
                if (!st.hasMoreTokens())
                {
                    st = new StringTokenizer(in.readLine());
                }
                long pos = Long.parseLong(st.nextToken());
                long t1 = pos;
                long t2 = L - pos;
                min = Math.max(min, Math.min(t1, t2));
                max = Math.max(max, Math.max(t1, t2));
            }

            System.out.println(min + " " + max);
        }
    }
}
