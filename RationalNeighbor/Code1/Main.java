package UVa.RationalNeighbor.Code1;

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
        outer:
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double f1 = a / (b * 1.0);

            double n = Double.parseDouble(in.readLine().trim());

            for (int d = 1; ; d++)
            {
                if (d > 1e7)
                {
                    throw new RuntimeException();
                }
                int c = (int) (f1 * d + 1);
                double f2 = c / (d * 1.0);
                if (f2 > f1 && f2 - f1 - n <= 1e-13)
                {
                    System.out.println(c + " " + d);
                    continue outer;
                }
            }
        }
    }
}
