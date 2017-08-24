package UVa.CoutingGame;

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
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            int k = Integer.parseInt(tokens[2]);
            if (n == 0)
            {
                break;
            }
            int a[] = new int[n];
            boolean isFirst = true;
            int count = 0;
            for (int i = 0; true; )
            {
                count++;
                if (isClap(count))
                {
                    a[i]++;
                    if (i + 1 == m && a[i] == k)
                    {
                        break;
                    }
                }
                if (isFirst)
                {
                    i++;
                } else
                {
                    i--;
                }
                if (i == a.length && isFirst)
                {
                    i = a.length - 2;
                    isFirst = false;
                } else if (i == -1 && !isFirst)
                {
                    i = 1;
                    isFirst = true;
                }
            }
            System.out.println(count);
        }
    }

    public boolean isClap(int n)
    {
        int temp = n;
        while (temp != 0)
        {
            int digit = temp % 10;
            if (digit == 7)
            {
                return true;
            }
            temp /= 10;
        }
        return n % 7 == 0;
    }
}

