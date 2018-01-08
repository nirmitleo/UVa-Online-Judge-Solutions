package UVa.HowManyFibs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeSet;
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
    BigInteger fibs[] = new BigInteger[481];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        fibs[0] = BigInteger.ZERO;
        fibs[1] = BigInteger.ONE;
        for (int i = 2; i < fibs.length; i++)
        {
            fibs[i] = fibs[i - 1].add(fibs[i - 2]);
        }
        while ((line = br.readLine()) != null)
        {
            tokens = line.split(" ");
            BigInteger a = new BigInteger(tokens[0]);
            BigInteger b = new BigInteger(tokens[1]);
            if ( a.compareTo(b) == 0 && a.compareTo(BigInteger.ZERO) == 0 )
            {
                return;
            } else
            {
                TreeSet<BigInteger> result = new TreeSet<BigInteger>();
                boolean isZero = false;
                if ( a.compareTo(BigInteger.ZERO) == 0 || b.compareTo(BigInteger.ZERO) == 0 )
                {
                    isZero = true;
                }
                for (int i = 0; i < fibs.length; i++)
                {
                    if ( fibs[i].compareTo(a) < 0 )
                    {
                        continue;
                    } else if ( fibs[i].compareTo(b) > 0 )
                    {
                        break;
                    }
                    result.add(fibs[i]);
                }
                int best = result.size();
                if ( isZero )
                {
                    best = best == 0 ? 0 : best - 1;
                }
                System.out.println(best);
            }
        }
    }

}
