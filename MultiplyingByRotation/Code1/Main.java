package UVa.MultiplyingByRotation.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 25/06/2017.
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
        //demo.test1();
    }

    public void test()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(i + " " + Integer.toString(i, 17));
        }
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
            int base = Integer.parseInt(st.nextToken());
            String d1 = st.nextToken();
            int d2 = Integer.parseInt(st.nextToken());

            int decimald2 = Integer.parseInt(d2 + "", base);
            for (long i = 0; ; i++)
            {
                String s = Long.toString(i, base);
                if (s.lastIndexOf(d1) == s.length() - d1.length())
                {
                    long result = i * decimald2;
                    String q = Long.toString(result, base);
                    if ((d1 + q).substring(d1.length()).equals(s))
                    {
                        System.out.println(q.length());
                        break;
                    }
                }
            }
        }

    }
}
