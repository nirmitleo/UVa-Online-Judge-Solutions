package UVa.PrimeDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
    PrintWriter sout = new PrintWriter(System.out, true);

    ArrayList<Integer> primes = new ArrayList<Integer>();
    private boolean isPrime[] = new boolean[1000001];
    TreeMap<Integer, AdjacentPrime> delta = new TreeMap<Integer, AdjacentPrime>();

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++)
        {
            if ( isPrime[i] )
            {
                for (int j = i * i; j < isPrime.length; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
        while ((line = br.readLine()) != null)
        {
            tokens = line.split(" ");
            int max = 0;
            int min = Integer.MAX_VALUE;
            int close1 = 0;
            int close2 = 0;
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);

            if ( start > isPrime.length )
            {
                System.out.println("There are no adjacent primes.");
                continue;
            }
            int prev = 0;
            int far1 = 0;
            int far2 = 0;
            for (int i = start; i <= end && i < isPrime.length; i++)
            {
                if ( prev == 0 && isPrime[i] )
                {
                    prev = i;
                    continue;
                }
                if ( isPrime[i] )
                {
                    if ( i - prev < min )
                    {
                        close1 = prev;
                        close2 = i;
                        min = i - prev;
                    }
                    if ( i - prev > max )
                    {
                        far1 = prev;
                        far2 = i;
                        max = i - prev;
                    }
                    prev = i;
                }
            }
            if ( far1 == far2 && close1 == 0 )
            {
                System.out.println("There are no adjacent primes.");
            } else
            {
                System.out.println(close1 + "," + close2 + " are closest, " + far1 + "," + far2 + " are most distant.");
            }
        }


        sout.flush();
        sout.close();
    }

}

class AdjacentPrime
{
    int diff;
    int first;
    int second;

    public AdjacentPrime(int first, int second, int diff)
    {
        this.first = first;
        this.second = second;
        this.diff = diff;
    }
}