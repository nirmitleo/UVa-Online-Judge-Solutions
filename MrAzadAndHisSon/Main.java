package UVa.MrAzadAndHisSon;

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

    private boolean isPrime[] = new boolean[100 * 1000 * 1000];

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
            int k = Integer.parseInt(line);
            double index = (Math.pow(2, (k - 1)) * (Math.pow(2, k) - 1));
            if ( isPerfect(index) )
            {
                System.out.println("Perfect: " + ((long) index) + "!");
            } else if ( isPrime[k] )
            {
                System.out.println("Given number is prime. But, NO perfect number is available.");
            } else
            {
                System.out.println("Given number is NOT prime! NO perfect number is available.");
            }
        }
        sout.flush();
        sout.close();
    }

    public boolean isPerfect(double number)
    {
        int sum = 1;
        for (long i = 2; sum <= number && i * i <= number; i++)
        {
            if ( number % i == 0 )
            {
                sum += (i) + (number / i);
            }
        }
        return sum == number;
    }

}
