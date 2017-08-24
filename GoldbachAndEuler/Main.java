package UVa.GoldbachAndEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    //PrintWriter sout = new PrintWriter(System.out, true);
    //PrintWriter sout = null;
    private boolean isPrime[] = new boolean[100000001];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
//        sout = new PrintWriter(new FileOutputStream(new File("./src/UVa/GoldbachAndEuler/out.txt")), true);
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++)
        {
            if (isPrime[i])
            {
                for (int j = i * i; j >= 0 && j < isPrime.length; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
        outer:
        for (; ; )
        {
            line = br.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            int n = Integer.parseInt(line);
            int index = n / 2;
            //If a number is odd. Then odd = odd + even && 2 is the only even prime
            if ((n & 1) == 1 && n > 1)
            {
                if (isPrime[n - 2])
                {
                    System.out.println(n + " is the sum of " + (2) + " and " + (n - 2) + ".");
                } else
                {
                    System.out.println(n + " is not the sum of two primes!");
                }
            } else
            {
                for (int i = index; i >= 2; i--)
                {
                    if (isPrime[i] && isPrime[n - i] && i != n - i)
                    {
                        System.out.println(n + " is the sum of " + (i) + " and " + (n - i) + ".");
                        continue outer;
                    }
                }
                System.out.println(n + " is not the sum of two primes!");
            }
        }


        //sout.flush();
        //sout.close();
    }

}
