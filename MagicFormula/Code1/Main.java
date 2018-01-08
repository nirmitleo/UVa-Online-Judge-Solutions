package UVa.MagicFormula.Code1;

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
            st = new StringTokenizer(in.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            long L = Long.parseLong(st.nextToken());

            if (a == 0 && b == 0 && c == 0)
            {
                return;
            }
            int count = 0;
            for (long x = 0; x <= L; x++)
            {
                long sum = (a * x * x) + (b * x) + c;
                if (sum % d == 0)
                {
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
