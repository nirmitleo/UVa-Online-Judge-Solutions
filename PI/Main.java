package UVa.PI;

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
        while (!(line = br.readLine()).trim().startsWith("0"))
        {
            int n = Integer.parseInt(line);
            int a[] = new int[n];
            for (int i = 0; i < a.length; i++)
            {
                a[i] = Integer.parseInt(br.readLine());
            }
            int count = 0;
            int total = 0;
            for (int i = 0; i < a.length; i++)
            {
                for (int j = i + 1; j < a.length; j++)
                {
                    total++;
                    if ( gcd(a[i], a[j]) == 1 )
                    {
                        count++;
                    }
                }
            }
            if ( count == 0 )
            {
                System.out.println("No estimate for this data set.");
            } else
            {
                System.out.printf("%.6f\n", Math.sqrt(6.0 * total / count));
            }

        }
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
