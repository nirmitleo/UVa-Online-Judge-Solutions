package UVa.JollybeeTournament.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        st = new StringTokenizer(in.readLine());
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
            int n = Integer.parseInt(st.nextToken());
            int p = (1 << n);
            ArrayList<Boolean> now = new ArrayList<Boolean>(p);

            for (int i = 0; i < p; i++)
            {
                now.add(true);
            }

            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < m; i++)
            {
                int pp = Integer.parseInt(st.nextToken()) - 1;
                now.set(pp, false);
            }

            int ans = 0;
            for (; ; )
            {
                ArrayList<Boolean> next = new ArrayList<Boolean>();
                if (now.size() == 1)
                {
                    break;
                }
                for (int i = 0, j = 0; i + 1 < now.size(); i += 2, j++)
                {
                    boolean p1 = now.get(i);
                    boolean p2 = now.get(i + 1);
                    if ((!p1 && p2) || (p1 && !p2))
                    {
                        ans++;
                    }
                    if (p1 || p2)
                    {
                        next.add(true);
                    } else
                    {
                        next.add(false);
                    }
                }
                now = next;
            }
            System.out.println(ans);
        }

    }
}
