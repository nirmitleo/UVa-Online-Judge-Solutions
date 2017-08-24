package UVa.CriticalMass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Nirmit on 19-Mar-16.
 */
public class Main
{
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private BigInteger f[] = new BigInteger[5000];
    private String line;

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        f[0] = BigInteger.ZERO;
        f[1] = BigInteger.ZERO;
        f[2] = BigInteger.ZERO;
        f[3] = BigInteger.ONE;
        BigInteger diff = BigInteger.valueOf(2);
        for (int i = 4; i < f.length; i++)
        {
            f[i] = diff.add(f[i - 1]);
            diff = diff.add(f[i]);
        }
        while (!(line = br.readLine()).trim().startsWith("0"))
        {
            int n = Integer.parseInt(line);
            System.out.println(f[n]);
        }
    }
}
