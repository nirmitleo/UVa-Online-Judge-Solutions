package UVa.FibonaccimalBase;

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

    private BigInteger f[] = new BigInteger[200];

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

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            System.out.println(n + " = " + convertToFinary(n) + " (fib)");
        }
    }

    public String convertToFinary(int n)
    {
        String result = "";
        int index = -1;
        BigInteger fix = BigInteger.valueOf(n);
        for (int i = 0; i < f.length; i++)
        {
            if (f[i].compareTo(fix) > 0)
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
