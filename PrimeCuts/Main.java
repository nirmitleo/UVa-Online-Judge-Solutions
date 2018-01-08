package UVa.PrimeCuts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    PrintWriter sout = new PrintWriter(System.out, true);

    int index = 0;
    private int primes[] = new int[1001];
    private boolean isPrime[] = new boolean[1001];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        boolean isFirst = true;
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        for (int i = 2; i < isPrime.length; i++)
        {
            int limit = (int) Math.sqrt(i);
            for (int j = 2; j <= limit; j++)
            {
                if ( i % j == 0 )
                {
                    isPrime[i] = false;
                    break;
                }
            }
            if ( isPrime[i] )
            {
                primes[++index] = i;
            }
        }
        while ((line = br.readLine()) != null)
        {
            tokens = line.split("[ ]+");
            int n = Integer.parseInt(tokens[0]);
            int c = Integer.parseInt(tokens[1]);
            String result = n + " " + c + ":";
            int start = 0;
            for (start = 0; start < primes.length; start++)
            {
                if ( primes[start] > n )
                {
                    break;
                }
            }
            start -= 1;
            start = start / 2 - 1;
            int count = c;
            if ( (start & 1) == 0 )
            {
                count = (count << 1);
            } else
            {
                count = (count << 1) - 1;
            }
            for (int i = start; count-- > 0 && primes[i] < n; i++)
            {
                result += " " + primes[i];
            }
            if ( isFirst )
            {
                System.out.println(result);
                isFirst = false;
            } else
            {
                System.out.println("\n" + result);

            }
        }
        sout.flush();
        sout.close();
    }

    public int binarySearch(int n)
    {
        int low = 1;
        int high = index;
        int mid = 0;
        while (low < high)
        {
            //System.out.println("Low = " + low + " high = " + high);
            mid = low + (high - low) / 2;
            if ( primes[mid] <= n )
            {
                low = mid;
            } else
            {
                high = mid - 1;
            }
        }
        return mid;
    }

}
