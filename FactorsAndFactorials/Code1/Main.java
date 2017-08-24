package UVa.FactorsAndFactorials.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 10/07/2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int PF = 100;
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }

            int[] pf = new int[PF + 1];
            for (int i = 2; i <= n; i++)
            {
                int num = i;
                for (int j = 2; j * j <= n; j++)
                {
                    int count = 0;
                    while (num % j == 0)
                    {
                        count++;
                        num /= j;
                    }
                    if (count > 0)
                    {
                        pf[j] += count;
                    }
                }
                if (num > 1)
                {
                    pf[num]++;
                }
            }
            String result = String.format("%3d! =", n);
            for (int i = 2, j = 0; i <= n; i++)
            {
                if (isPrime(i))
                {
                    result += String.format("%3d", pf[i]);
                    j++;
                    if (j % 15 == 0 && i + 1 <= n)
                    {
                        result += "\n" + "      ";
                    }
                }
            }
            System.out.println(result.replaceAll("[\n' ']+$", ""));
        }
    }

    public boolean isPrime(int n)
    {
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
