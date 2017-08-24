package UVa.Combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by DELL on 28-Mar-16.
 */
public class Main
{
    private BigInteger fact[] = new BigInteger[101];
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
        fact[0] = BigInteger.ONE;
        fact[1] = BigInteger.ONE;
        for (int i = 2; i < fact.length; i++)
        {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }
        while (true)
        {
            tokens = br.readLine().split("[ ]+");
            int n = Integer.parseInt(tokens[0]);
            int k = Integer.parseInt(tokens[1]);
            if (n == 0 && k == 0)
            {
                break;
            }
            System.out.println(n + " things taken " + k + " at a time is " + fact[n].divide(fact[n - k].multiply(fact[k])) + " exactly.");
        }
    }

}
