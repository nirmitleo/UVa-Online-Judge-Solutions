package UVa.FractionsAgain.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 14/07/2017.
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
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            StringBuilder sb = new StringBuilder("");
            for (int y = k + 1; ; y++)
            {
                long N = k * 1L * y;
                long D = y - k;
                if (N / D < y)
                {
                    break;
                }
                if (N % D == 0)
                {
                    count++;
                    sb.append("1/" + k + " = 1/" + (N / D) + " + 1/" + y + "\n");
                }
            }
            System.out.println(count);
            System.out.print(sb);
        }

    }
}
