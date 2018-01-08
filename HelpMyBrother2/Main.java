package UVa.HelpMyBrother2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by DELL on 19-Mar-16.
 */
public class Main
{
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BigInteger median[] = new BigInteger[2000];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        median[0] = BigInteger.ZERO;
        median[1] = BigInteger.ONE;


        BigInteger start = BigInteger.valueOf(2);
        BigInteger result = null;
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        for (int i = 2; i < median.length; i++)
        {
            BigInteger c = a.add(b);
            BigInteger index = c.divide(BigInteger.valueOf(2));
            boolean isEven = c.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0;
            if (isEven)
            {
                result = start.add(index.subtract(BigInteger.ONE));
            } else
            {
                result = start.add(index);
            }
            median[i] = result;
            start = result.add(index.add(BigInteger.ONE));
            a = b;
            b = c;
        }
        int test = 1;
        while (true)
        {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0)
            {
                return;
            }
            System.out.println("Set " + (test++) + ":\n" + median[n - 1]);
        }
    }
}
