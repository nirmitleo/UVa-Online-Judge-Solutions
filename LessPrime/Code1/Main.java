package UVa.LessPrime.Code1;

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
        int P = 1229;
        int N = (int) 1e4;
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
        for (int i = 2, j = 0; i < N + 1; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
            }
        }
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int min = Integer.MAX_VALUE;
            int result = -1;
            for (int i = 0; i < P && primes[i] <= n; i++)
            {
                int x = primes[i];
                int p = n / x;
                if ((p + 1) * x > n)
                {
                    if (min > p * x)
                    {
                        min = p * x;
                        result = x;
                    }
                }
            }
            System.out.println(result);
        }

    }
}
