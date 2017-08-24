package UVa.DeterminatePrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
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

    private boolean isPrime[] = new boolean[32001];
    private int primes[] = new int[32001];
    private int primesLength = 0;

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
            for (int j = i * i; isPrime[i] && j < isPrime.length; j += i)
            {
                isPrime[j] = false;
            }
        }
        for (int i = 0; i < isPrime.length; i++)
        {
            if ( isPrime[i] )
            {
                primes[primesLength++] = i;
            }
        }

        while (true)
        {
            LinkedList<DPrimes> result = new LinkedList<DPrimes>();
            tokens = br.readLine().split("[ ]+");
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);
            if ( start == end && end == 0 )
            {
                break;
            }
            for (int i = 0; i < primesLength && primes[i] <= end; i++)
            {
                if ( primes[i] >= start && i - 2 >= 0 )
                {
                    if ( primes[i] - primes[i - 1] == primes[i - 1] - primes[i - 2] )
                    {
                        int diff = primes[i] - primes[i - 1];
                        result.add(new DPrimes(primes[i - 2], diff));
                        result.add(new DPrimes(primes[i - 1], diff));
                        result.add(new DPrimes(primes[i], diff));
                    }
                }
            }
            DPrimes first = result.pollFirst();
            String res = "" + first.id + " ";
            int prev = first.id;
            int diff = first.diff;
            while (!result.isEmpty())
            {
                DPrimes temp = result.pollFirst();
                if ( temp.diff == diff && temp.id - diff == prev )
                {
                    res += temp.id + " ";
                } else
                {
                    res = res.trim();
                    res += "\n" + temp.id + " ";
                    diff = temp.diff;
                }
                prev = temp.id;
            }
            System.out.println(res.trim());
        }
    }

}

class DPrimes
{
    int id;
    int diff;


    public DPrimes(int id, int diff)
    {
        this.id = id;
        this.diff = diff;
    }

}