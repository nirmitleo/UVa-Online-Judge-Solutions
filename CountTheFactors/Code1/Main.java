package UVa.CountTheFactors.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/07/2017.
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
        int N = (int) 1e6;
        int P = 78498;
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

        int[] result = new int[N + 1];
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
            }
            int num = i;
            for (int k = 0; k < j && primes[k] * primes[k] <= i; k++)
            {
                int count = 0;
                while (num % primes[k] == 0)
                {
                    count++;
                    num /= primes[k];
                }
                if (count > 0)
                {
                    result[i]++;
                }
            }
            if (num > 1)
            {
                result[i]++;
            }
        }
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            System.out.println(n + " : " + result[n]);
        }

    }
}
