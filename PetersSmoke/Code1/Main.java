package UVa.PetersSmoke.Code1;

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
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int now = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int total = now;
            while (true)
            {
                if (now < k)
                {
                    break;
                }
                int next = now / k;
                now = now % k;
                now += next;
                total += next;
            }
            System.out.println(total);
        }
    }
}
