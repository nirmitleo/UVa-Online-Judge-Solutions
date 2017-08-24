package UVa.AllInAll.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 21/06/2017.
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
        start:
        for (; ; )
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            st = new StringTokenizer(line);
            String p = st.nextToken();
            String q = st.nextToken();
            outer:
            for (int i = 0, j = 0; i < p.length(); i++)
            {
                char ch = p.charAt(i);
                for (; j < q.length(); j++)
                {
                    if (ch == q.charAt(j))
                    {
                        j++;
                        continue outer;
                    }
                }
                System.out.println("No");
                continue start;
            }
            System.out.println("Yes");
        }

    }
}
