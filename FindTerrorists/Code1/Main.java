package UVa.FindTerrorists.Code1;

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
        int N = (int) 1e4;
        int P = 1229;
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
        for (int i = 0, j = 0; i <= N; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
            }
        }
        boolean[] result = new boolean[N + 1];
        for (int i = 2; i <= N; i++)
        {
            int num = i;
            int sum = 1;
            for (int j = 0; j < P && primes[j] * primes[j] <= N; j++)
            {
                int count = 0;
                while (num % primes[j] == 0)
                {
                    num /= primes[j];
                    count++;
                }
                if (count > 0)
                {
                    sum *= (count + 1);
                }
            }
            if (num > 1)
            {
                sum *= 2;
            }
            if (seive[sum])
            {
                result[i] = true;
            }
        }

        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int c = 0;
            StringBuilder sb = new StringBuilder("");
            for (int i = L; i <= H; i++)
            {
                if (result[i])
                {
                    c++;
                    sb.append(i + " ");
                }
            }
            if (c == 0)
            {
                System.out.println(-1);
            } else
            {
                System.out.println(sb.toString().trim());
            }
        }
    }
}
