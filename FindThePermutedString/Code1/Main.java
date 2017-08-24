package UVa.FindThePermutedString.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 16/06/2017.
 */
public class Main
{
    private int S;
    private int N;
    private String s;
    private String result;
    private BigInteger[] f;
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.init();
        demo.solve();
    }

    public void init()
    {
        f = new BigInteger[27];
        f[0] = BigInteger.ONE;
        f[1] = BigInteger.ONE;
        for (int i = 1; i <= 26; i++)
        {
            f[i] = f[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

    public void solve() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            s = in.readLine().trim();
            S = s.length();
            N = Integer.parseInt(in.readLine().trim()) - 1;
            result = null;
            go(BigInteger.ZERO, f[S].subtract(BigInteger.ONE), BigInteger.valueOf(N), 1, s.charAt(0) + "");
            System.out.println(result);
        }
    }


    public void go(BigInteger low, BigInteger high, BigInteger x, int i, String p)
    {
        if (x.compareTo(low) < 0 || x.compareTo(high) > 0)
        {
            return;
        }
        if (x.compareTo(low) == 0 && x.compareTo(high) == 0)
        {
            result = p;
            return;
        }

        char ch = s.charAt(i);
        BigInteger steps = high.subtract(low).add(BigInteger.ONE).divide(BigInteger.valueOf(p.length() + 1));

        BigInteger left = low;
        BigInteger right = left.add(steps.subtract(BigInteger.ONE));

        for (int j = 0; j <= p.length(); j++)
        {
            go(left, right, x, i + 1, p.substring(0, j) + ch + p.substring(j));
            left = right.add(BigInteger.ONE);
            right = right.add(steps);
        }
    }
}
