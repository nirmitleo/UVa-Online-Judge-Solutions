package UVa.Cola.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24/06/2017.
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
        for (; ; )
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            st = new StringTokenizer(line);
            int best = 0;
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 3; i++)
            {
                int count = 0;

                int now = n;
                int e = i;
                int b = i;
                while (now > 0)
                {
                    count += now;
                    e += now;
                    now = e / 3;
                    e %= 3;
                }
                if (e >= b)
                {
                    best = Math.max(best, count);
                }
            }
            System.out.println(best);
        }

    }
}
