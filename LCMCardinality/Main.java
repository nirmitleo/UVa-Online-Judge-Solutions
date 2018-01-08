package UVa.LCMCardinality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        boolean isFirst = true;
        while (!(line = br.readLine()).trim().startsWith("0"))
        {
            int n = Integer.parseInt(line.trim());
            ArrayList<Integer> prod = new ArrayList<Integer>();
            if ( n == 1 )
            {
                System.out.println("1 1");
                continue;
            }
            for (int i = 1; i * i <= n; i++)
            {
                if ( n % i == 0 )
                {
                    prod.add(i);
                    if ( i != n / i )
                    {
                        prod.add(n / i);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < prod.size(); i++)
            {
                for (int j = i; j < prod.size(); j++)
                {
                    if ( gcd(prod.get(i), prod.get(j)) == 1 )
                    {
                        count++;
                    }
                }
            }
            System.out.println(n + " " + count);
        }
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

}
