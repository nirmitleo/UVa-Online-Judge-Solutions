package UVa.MaximumGCD;

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
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            tokens = br.readLine().trim().split("[ ]+");
            int a[] = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++)
            {
                a[i] = Integer.parseInt(tokens[i]);
            }
            int max = 0;
            for (int i = 0; i < a.length; i++)
            {
                for (int j = i + 1; j < a.length; j++)
                {
                    max = Math.max(max, gcd(a[i], a[j]));
                }
            }
            System.out.println(max);
        }

    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

}
