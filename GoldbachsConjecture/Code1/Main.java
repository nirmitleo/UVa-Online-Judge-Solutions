package UVa.GoldbachsConjecture.Code1;

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
        int P = 78497;
        int N = (int) 1e6;
        int[] primes = new int[P];
        boolean[] seive = new boolean[N + 1];
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
        for (int i = 3, j = 0; i < N + 1; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
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
            for (int i = 0; primes[i] < n; i++)
            {
                int index = Arrays.binarySearch(primes, n - primes[i]);
                if (index >= 0 && index < P)
                {
                    System.out.println(n + " = " + primes[i] + " + " + (n - primes[i]));
                    break;

                }
            }
        }


    }

}
