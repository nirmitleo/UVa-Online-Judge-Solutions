package UVa.BinomialShowdown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by DELL on 29-Mar-16.
 */
public class Main
{
    BigInteger fact[] = new BigInteger[5001];
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        fact[0] = fact[1] = BigInteger.ONE;
        for (int i = 2; i < fact.length; i++)
        {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }
        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            if (a == b && b == 0)
            {
                break;
            }
            int n = Math.max(a, b);
            int k = Math.min(a, b);
            System.out.println(fact[n].divide(fact[n - k].multiply(fact[k])));
        }
    }

}

