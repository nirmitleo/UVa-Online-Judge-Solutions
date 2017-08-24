package UVa.EcologicalBinPacking.Code1;

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
            long b1B = Long.parseLong(st.nextToken());
            long b1G = Long.parseLong(st.nextToken());
            long b1C = Long.parseLong(st.nextToken());
            long b2B = Long.parseLong(st.nextToken());
            long b2G = Long.parseLong(st.nextToken());
            long b2C = Long.parseLong(st.nextToken());
            long b3B = Long.parseLong(st.nextToken());
            long b3G = Long.parseLong(st.nextToken());
            long b3C = Long.parseLong(st.nextToken());

            String result = "";
            long ans = Long.MAX_VALUE;
            long moves = b2B + b3B + b1C + b3C + b1G + b2G;
            if (moves < ans)
            {
                result = "BCG";
                ans = moves;
            }
            moves = b2B + b3B + b1C + b2C + b1G + b3G;
            if (moves < ans)
            {
                result = "BGC";
                ans = moves;
            }
            moves = b1B + b3B + b2C + b3C + b1G + b2G;
            if (moves < ans)
            {
                result = "CBG";
                ans = moves;
            }
            moves = b2B + b1B + b2C + b3C + b1G + b3G;
            if (moves < ans)
            {
                result = "CGB";
                ans = moves;
            }
            moves = b1B + b3B + b1C + b2C + b3G + b2G;
            if (moves < ans)
            {
                result = "GBC";
                ans = moves;
            }
            moves = b2B + b1B + b1C + b3C + b3G + b2G;
            if (moves < ans)
            {
                result = "GCB";
                ans = moves;
            }
            System.out.println(result + " " + ans);

        }

    }
}
