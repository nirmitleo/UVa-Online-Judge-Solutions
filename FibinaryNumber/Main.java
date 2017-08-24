package UVa.FibinaryNumber;

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

    private BigInteger f[] = new BigInteger[1000];

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        f[0] = BigInteger.ONE;
        f[1] = BigInteger.valueOf(2);
        for (int i = 2; i < f.length; i++)
        {
            f[i] = f[i - 1].add(f[i - 2]);
        }

        long test = Long.parseLong(br.readLine().trim());

        while (test-- > 0)
        {
            long n = Long.parseLong(br.readLine().trim());
            System.out.println(convert(n));
        }
    }

    public String convert(long n)
    {
        int index = -1;
        String result = "";
        BigInteger fix = BigInteger.valueOf(n);
        for (int i = 0; i < f.length; i++)
        {
            if (f[i].compareTo(fix) >= 0)
            {
                index = (i == 0) ? 0 : i - 1;
                break;
            }
        }
        for (int i = index; i >= 0; i--)
        {
            if (fix.compareTo(f[i]) >= 0)
            {
                fix = fix.subtract(f[i]);
                result += "1";
            } else
            {
                result += "0";
            }
        }
        return result;
    }
}
