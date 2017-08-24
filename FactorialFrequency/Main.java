package UVa.FactorialFrequency;

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
        for (int i = 2; i < 367; i++)
        {
            BigInteger ans = fact.get(i - 1).multiply(BigInteger.valueOf(i));
            fact.put(i, ans);
        }
        while (!(line = br.readLine()).trim().startsWith("0"))
        {
            int n = Integer.parseInt(line);
            String result = fact.get(n).toString();
            int a[] = new int[10];
            for (int i = 0; i < result.length(); i++)
            {
                a[Integer.parseInt(result.charAt(i) + "")]++;
            }
            System.out.println(n + "! --");
            System.out.printf("%6s%5d%7s%5d%7s%5d%7s%5d%7s%5d\n", "(0)", a[0], "(1)", a[1], "(2)", a[2], "(3)", a[3], "(4)", a[4]);
            System.out.printf("%6s%5d%7s%5d%7s%5d%7s%5d%7s%5d\n", "(5)", a[5], "(6)", a[6], "(7)", a[7], "(8)", a[8], "(9)", a[9]);
        }
    }

}
