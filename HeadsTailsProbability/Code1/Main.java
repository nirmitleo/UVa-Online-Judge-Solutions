package UVa.HeadsTailsProbability.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
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
        int N = (int) 9000 + 1;
        BigInteger[] pow = new BigInteger[N];
        BigDecimal[] result = new BigDecimal[N];
        pow[0] = BigInteger.ONE;
        BigDecimal log2 = new BigDecimal(Math.log(2));
        for (int i = 1; i < N; i++)
        {
            pow[i] = BigInteger.valueOf(2).pow(i);
//            result[i] = BigDecimal.valueOf(i).multiply(log2).multiply(BigDecimal.valueOf(-1));

        }
        //System.out.println("done");
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            System.out.println("2^-" + n + " = " + BigDecimal.ONE.divide(BigDecimal.valueOf(2.0).pow(n)));
        }

    }
}
