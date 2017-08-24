package UVa.GoldbachsConjecture2.Code1;

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
        int P = 4203;
        int N = 40000;
        boolean[] seive = new boolean[N];
        int[] primes = new int[P];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i * i < N; i++)
        {
            for (int j = i * i; j < N; j += i)
            {
                seive[j] = false;
            }
        }
        for (int i = 2, j = 0; i < N; i++)
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
            int count = 0;
            for (int i = 0; primes[i] <= n / 2; i++)
            {
                int index = Arrays.binarySearch(primes, n - primes[i]);
                if (index >= 0 && index < P)
                {
                    count++;
                }
            }
            System.out.println(count);
        }


    }
}
