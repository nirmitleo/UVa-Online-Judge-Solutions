package UVa.FiveHundred;

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
        TreeMap<Integer, BigInteger> fact = new TreeMap<Integer, BigInteger>();
        fact.put(0, BigInteger.ONE);
        fact.put(1, BigInteger.ONE);
        for (int i = 2; i <= 1000; i++)
        {
            BigInteger ans = fact.get(i - 1).multiply(BigInteger.valueOf(i));
            fact.put(i, ans);
        }
        while ((line = br.readLine()) != null)
        {
            int n = Integer.parseInt(line);
            System.out.println(n + "!");
            System.out.println(fact.get(n));
        }

    }

}
