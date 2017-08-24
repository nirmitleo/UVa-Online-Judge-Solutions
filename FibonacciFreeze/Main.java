package UVa.FibonacciFreeze;

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
    BigInteger fibo[] = new BigInteger[5001];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        fibo[0] = BigInteger.ZERO;
        fibo[1] = BigInteger.ONE;
        for (int i = 2; i < fibo.length; i++)
        {
            fibo[i] = fibo[i - 1].add(fibo[i - 2]);
        }
        while ((line = br.readLine()) != null)
        {
            int n = Integer.parseInt(line);
            System.out.println("The Fibonacci number for " + n + " is " + fibo[n]);
        }
    }
}
