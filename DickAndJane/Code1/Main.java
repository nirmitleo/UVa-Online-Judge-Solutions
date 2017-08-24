package UVa.DickAndJane.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 27/06/2017.
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
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            for (int i = -100; ; i++)
            {
                if (i > 1e6)
                {
                    System.out.println("Age exceeded for test1" + t);
                    throw new RuntimeException();
                }
                int sum = y + p + (3 * i);
                if (sum == j + 12)
                {
                    int S = y + i;
                    int P = p + i;
                    System.out.println(S + " " + P + " " + i);
                    break;
                } else if (sum + 2 == j + 12)
                {
                    int S = y + i + 1;
                    int P = p + i + 1;
                    System.out.println(S + " " + P + " " + i);
                    break;
                } else if (sum - 2 == j + 12)
                {
                    int S = y + i - 1;
                    int P = p + i - 1;
                    System.out.println(S + " " + P + " " + i);
                    break;
                } else if (sum + 1 == j + 12)
                {
                    int S = y + i + 1;
                    int P = p + i;
                    if (Math.abs(S - P) <= s)
                    {

                    }
                    System.out.println(S + " " + P + " " + i);
                    break;
                } else if (sum - 1 == j + 12)
                {
                }
            }
        }

    }
}
