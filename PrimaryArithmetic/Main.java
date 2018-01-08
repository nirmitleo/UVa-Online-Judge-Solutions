package UVa.PrimaryArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Mar-16.
 */
public class Main
{
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            long a = Long.parseLong(tokens[0]);
            long b = Long.parseLong(tokens[1]);
            if (a == b && a == 0)
            {
                break;
            }
            long min = Math.min(a, b);
            long max = Math.max(a, b);
            int result = 0;
            long carry = 0;
            while (min != 0)
            {
                long d1 = min % 10;
                long d2 = max % 10;
                min /= 10;
                max /= 10;
                if (d1 + d2 + carry >= 10)
                {
                    result++;
                }
                carry = d1 + d2 + carry >= 10 ? (d1 + d2 + carry) / 10 : 0;
            }
            if (result == 0)
            {
                System.out.println("No carry operation.");
            } else
            {
                if (result == 1)
                {
                    System.out.println(result + " carry operation.");
                } else
                {
                    System.out.println(result + " carry operations.");
                }
            }
        }
    }
}

