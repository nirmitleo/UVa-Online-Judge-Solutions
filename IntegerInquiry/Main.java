package UVa.IntegerInquiry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by DELL on 24-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        BigInteger result = BigInteger.ZERO;
        String line = "";
        while (!(line = br.readLine()).equals("0"))
        {
            BigInteger n = new BigInteger(line);
            result = result.add(n);
        }
        System.out.println(result);
    }
}
