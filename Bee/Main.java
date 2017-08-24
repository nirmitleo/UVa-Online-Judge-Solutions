package UVa.Bee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
    1) Dont forget to remove the package statement
    2) Remove the public access specifier from the UpperBound class.
    
    Train insane or remain the same!
*/

public class Main
{
    String line = "";
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger f[] = new BigInteger[1000];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        f[0] = BigInteger.ONE;
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 1; i < f.length; i++)
        {
            BigInteger c = a.add(b);
            f[i] = f[i - 1].add(c);
            a = b;
            b = c;
        }
        while (!(line = br.readLine()).trim().contains("-1"))
        {
            int n = Integer.parseInt(line.trim());
            if ( n == 0 )
            {
                System.out.println("0 1");
                continue;
            }
            System.out.println(f[n - 1] + " " + f[n]);
        }
    }
}
