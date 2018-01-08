package UVa.HashmatTheBraveWarrior.Code1;

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
        for (; ; )
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            st = new StringTokenizer(line);
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            System.out.println(Math.abs(a - b));
        }

    }
}
