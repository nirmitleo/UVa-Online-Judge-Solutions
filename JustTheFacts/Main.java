package UVa.JustTheFacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeMap;
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

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        TreeMap<Integer, Integer> fact = new TreeMap<Integer, Integer>();
        fact.put(0, 0);
        fact.put(1, 1);
        BigInteger prev = BigInteger.ONE;
        BigInteger mod = BigInteger.valueOf(10);
        mod = mod.pow(20);
        for (int i = 2; i < 10001; i++)
        {
            BigInteger current = prev.multiply(BigInteger.valueOf(i));
            current = current.mod(mod);
            String result = current.toString();
            for (int j = result.length() - 1; j >= 0; j--)
            {
                if ( result.charAt(j) != '0' )
                {
                    fact.put(i, Integer.parseInt(result.charAt(j) + ""));
                    break;
                }
            }
            prev = current;
        }
        while ((line = br.readLine()) != null)
        {
            int n = Integer.parseInt(line);
            int lastDigit = fact.get(n);
            System.out.println(n + " -> " + lastDigit);
        }
    }

}
