package UVa.GoldbachsConjecture;

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

    private boolean isPrime[] = new boolean[1000000];

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
        for (int i = 4; i < isPrime.length; i++)
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
        }

        while (!(line = br.readLine()).startsWith("0"))
        {
            int n = Integer.parseInt(line);
            for (int i = 2; i <= (n / 2); i++)
            {
                if ( isPrime[i] && isPrime[n - i] )
                {
                    sout.println(n + " = " + i + " + " + (n - i));
                    break;
                }
            }
        }
        sout.flush();
        sout.close();
    }

}
