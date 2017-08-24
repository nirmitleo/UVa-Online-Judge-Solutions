package UVa.CountOnCantor.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 03/07/2017.
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
        int N = (int) 1e7 + 1;
        int[] nr = new int[N];
        int[] dr = new int[N];

        nr[1] = 1;
        dr[1] = 1;
        boolean down = false;
        int x = 1;
        int y = 1;
        for (int i = 2; i < N; i++)
        {
            if (down)
            {
                if (y - 1 >= 1)
                {
                    x++;
                    y--;
                } else
                {
                    down = false;
                    x++;
                }
            } else
            {
                if (x - 1 >= 1)
                {
                    x--;
                    y++;
                } else
                {
                    down = true;
                    y++;
                }
            }
            nr[i] = x;
            dr[i] = y;
        }
        for (int t = 1; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            while (st.hasMoreTokens())
            {
                int n = Integer.parseInt(st.nextToken());
                System.out.println("TERM " + n + " IS " + nr[n] + "/" + dr[n]);
                t++;
            }
        }
    }
}
