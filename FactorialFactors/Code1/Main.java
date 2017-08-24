package UVa.FactorialFactors.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/07/2017.
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
        int M = (int) 1e6;
        int P = 78498;
        boolean[] seive = new boolean[M + 1];
        int[] primes = new int[P];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i * i <= M; i++)
        {
            for (int j = i * i; j <= M; j += i)
            {
                seive[j] = false;
            }
        }
        for (int i = 2, j = 0; i <= M; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
            }
        }
        int[] result = new int[M + 1];
        result[2] = 1;
        for (int i = 3; i <= M; i++)
        {
            int num = i;
            int sum = 0;
            for (int j = 0; j < P && primes[j] * primes[j] <= M; j++)
            {
                int count = 0;
                while (num % primes[j] == 0)
                {
                    num /= primes[j];
                    count++;
                }
                if (count > 0)
                {
                    sum += count;
                }
            }
            if (num > 1)
            {
                sum++;
            }
            result[i] = result[i - 1] + sum;
        }
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            System.out.println(result[N]);
        }

    }
}
