package UVa.DissectingAHexagon.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 03/07/2017.
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
            if (st.hasMoreTokens())
            {
                BigInteger n = new BigInteger(st.nextToken());
                System.out.println(n.mod(BigInteger.valueOf(3L)).compareTo(BigInteger.ZERO) == 0 && n.compareTo(BigInteger.ZERO) > 0 ? 1 : 0);
            }
        }

    }
}
