package UVa.DifferentDigits;

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
        boolean a[] = new boolean[5001];
        for (int i = 11; i < a.length; i++)
        {
            boolean temp[] = new boolean[10];
            int n = i;
            while (n != 0)
            {
                int digit = n % 10;
                if (temp[digit])
                {
                    a[i] = true;
                    break;
                }
                temp[digit] = true;
                n /= 10;
            }
        }
        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            int temp1 = Integer.parseInt(tokens[0]);
            int temp2 = Integer.parseInt(tokens[1]);
            int min = Math.min(temp1, temp2);
            int max = Math.max(temp1, temp2);
            int result = 0;
            for (int i = min; i <= max; i++)
            {
                if (!a[i])
                {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}

