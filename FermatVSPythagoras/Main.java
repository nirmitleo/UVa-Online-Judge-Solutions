package UVa.FermatVSPythagoras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        while ((line = br.readLine()) != null)
        {
            int countGCD = 1;
            int count = 0;
            int n = Integer.parseInt(line);
            boolean a[] = new boolean[n + 1];
            for (int i = 0; i <= n; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    for (int k = 0; k <= n; k++)
                    {
                        if ( i * i + j * j == k * k )
                        {
                            int relative = gcd(k, gcd(j, i));
                            if ( relative == 1 )
                            {
                                countGCD++;
                            }
                            a[i] = true;
                            a[j] = true;
                            a[k] = true;
                            break;
                        }
                    }
                }
            }
            for (int i = 1; i <= n; i++)
            {
                if ( !a[i] )
                {
                    count++;
                }
            }
            System.out.println(countGCD + " " + count);
        }
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }


}
