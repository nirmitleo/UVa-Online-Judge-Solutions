package UVa.JollybeeTournament.Code2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
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
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n + m == 0)
            {
                return;
            }

            int p = (1 << n);
            BitSet now = new BitSet(p);
            for (int i = 0; i < p; i++)
            {
                now.set(i);
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < m; i++)
            {
                int id = Integer.parseInt(st.nextToken()) - 1;
                now.flip(id);
            }

            int ans = 0;
            for (; now.size() > 1; )
            {
                BitSet next = new BitSet(p / 2);
                for (int i = 1, j = 0; i < p; i += 2, j++)
                {
                    boolean p1 = now.get(i);
                    boolean p2 = now.get(i - 1);
                    if ((!p1 && p2) || (p1 && !p2))
                    {
                        ans++;
                    }
                    if (p1 || p2)
                    {
                        next.set(j);
                    }
                }
                now = next;
                p = p / 2;
            }
            System.out.println(ans);
        }
    }
}
