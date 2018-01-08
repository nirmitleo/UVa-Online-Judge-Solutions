package UVa.PowerOfCryptography.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/07/2017.
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
            int n = Integer.parseInt(st.nextToken());
            BigInteger base = null;
            if (st.hasMoreTokens())
            {
                base = new BigInteger(st.nextToken());
            } else
            {
                base = new BigInteger(in.readLine());
            }


            BigInteger low = BigInteger.ONE;
            BigInteger high = base.add(BigInteger.ONE);
            while (high.subtract(low).compareTo(BigInteger.ONE) > 0)
            {
                BigInteger mid = low.add(high.subtract(low).divide(BigInteger.valueOf(2)));
                if (check(mid, base, n))
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
            System.out.println(low);
        }
    }

    public boolean check(BigInteger k, BigInteger p, int n)
    {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
        {
            result = result.multiply(k);
        }
        return result.compareTo(p) <= 0;
    }
}
