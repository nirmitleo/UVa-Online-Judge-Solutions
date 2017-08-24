package UVa.BrotherArifPleaseFeedUs.Code1;

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
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (R + C + N == 0)
            {
                return;
            }

            boolean[] cols = new boolean[C];
            boolean[] rows = new boolean[R];

            for (int i = 0; i < N; i++)
            {
                st = new StringTokenizer(in.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                rows[r] = true;
                cols[c] = true;
            }

            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            boolean ok = false;
            if (!ok && !rows[r] && !cols[c])
            {
                ok = true;
            }
            if (!ok && r - 1 >= 0 && !rows[r - 1] && !cols[c])
            {
                ok = true;
            }
            if (!ok && r + 1 < R && !rows[r + 1] && !cols[c])
            {
                ok = true;
            }
            if (!ok && c - 1 >= 0 && !rows[r] && !cols[c - 1])
            {
                ok = true;
            }
            if (!ok && c + 1 < C && !rows[r] && !cols[c + 1])
            {
                ok = true;
            }

            if (ok)
            {
                System.out.println("Case " + t + ": Escaped again! More 2D grid problems!");
            } else
            {
                System.out.println("Case " + t + ": Party time! Let's find a restaurant!");
            }
        }

    }
}
