package UVa.LessPrime;

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
    private boolean isPrime[] = new boolean[10000];

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
        int test = Integer.parseInt(br.readLine());

        while (test-- > 0)
        {
            int max = -1;
            int result = -1;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n && i < isPrime.length; i++)
            {
                if ( isPrime[i] )
                {
                    int p = n / i;
                    if ( (p * i <= n && (p + 1) * i > n) && (max < (n - (p * i))) )
                    {
                        max = n - (p * i);
                        result = i;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
