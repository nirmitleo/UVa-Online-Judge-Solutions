package UVa.ChooseAndDivide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by DELL on 30-Mar-16.
 */
public class Main
{
    BigInteger fact[] = new BigInteger[10000];
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
            tokens = line.split("[ ]+");
            int n1 = Integer.parseInt(tokens[0]);
            int r1 = Integer.parseInt(tokens[1]);
            int n2 = Integer.parseInt(tokens[2]);
            int r2 = Integer.parseInt(tokens[3]);

            BigDecimal nr = new BigDecimal(ncr(n1, r1));
            BigDecimal dr = new BigDecimal(ncr(n2, r2));
            BigDecimal result = nr.divide(dr, 10, BigDecimal.ROUND_CEILING);

            System.out.printf("%.5f\n", result);
        }
    }

    public BigInteger ncr(int n, int r)
    {
        return fact[n].divide(fact[n - r].multiply(fact[r]));
    }

}

