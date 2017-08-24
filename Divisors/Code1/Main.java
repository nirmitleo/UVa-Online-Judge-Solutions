package UVa.Divisors.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 11/07/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            long result = 1L;
            int best = 1;
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            for (int i = L; i <= U; i++)
            {
                int num = i;
                long now = 1;
                for (int j = 2; j * j <= i; j++)
                {
                    int count = 0;
                    while (num % j == 0)
                    {
                        num /= j;
                        count++;
                    }
                    if (count > 0)
                    {
                        now *= (count + 1);
                    }
                }
                if (num > 1)
                {
                    now *= 2;
                }
                if (result < now)
                {
                    result = now;
                    best = i;
                }
            }
            System.out.println("Between " + L + " and " + U + ", " + best + " has a maximum of " + result + " divisors.");
        }

    }
}
