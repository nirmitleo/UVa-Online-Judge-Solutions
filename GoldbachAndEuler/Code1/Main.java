package UVa.GoldbachAndEuler.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 07/07/2017.
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
        int N = (int) 1e8;
        int P = 5761455;
        boolean[] seive = new boolean[N + 1];
        int[] primes = new int[P];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                seive[j] = false;
            }
        }

        for (int i = 0, j = 0; i < N; i++)
        {
            if (seive[i])
            {
//                count++;
                primes[j++] = i;
            }
        }

        outer:
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            if (n % 2 != 0)
            {

                if (n - 2 >= 0 && seive[n - 2])
                {
                    System.out.println(n + " is the sum of " + 2 + " and " + (n - 2) + ".");
                } else
                {
                    System.out.println(n + " is not the sum of two primes!");
                }
            } else
            {
                int low = -1;
                int high = P;
                while (high - low > 1)
                {
                    int mid = low + (high - low) / 2;
                    if (primes[mid] <= n / 2)
                    {
                        low = mid;
                    } else
                    {
                        high = mid;
                    }
                }
                for (int i = low; i >= 0; i--)
                {
                    int left = n - primes[i];
                    if (left != primes[i] && seive[left])
                    {
                        System.out.println(n + " is the sum of " + primes[i] + " and " + left + ".");
                        continue outer;
                    }
                }
                System.out.println(n + " is not the sum of two primes!");
            }
        }

    }
}
