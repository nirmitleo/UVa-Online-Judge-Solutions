package UVa.Deck.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 02/07/2017.
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
        StringBuilder sb = new StringBuilder("");
        sb.append("# Cards Overhang");
        sb.append("\n");
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                System.out.print(sb);
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            double sum = 0;
            for (int i = 1, j = 2; i <= n; i++, j += 2)
            {
                sum += (1 / (j * 1.0));
            }
            sb.append(String.format("%5d%10.3f\n", n, sum));
        }
    }
}
