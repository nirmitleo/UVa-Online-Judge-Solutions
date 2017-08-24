package UVa.DeterminatePrimes.Code1;

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
    private int P;
    private int[] primes;
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
        int N = 32000;
        P = 3432;
        boolean[] seive = new boolean[N + 1];
        primes = new int[P];
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
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
            }
        }

        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int start = Math.min(a, b);
            int end = Math.max(a, b) ;
            if (start == 0 && end == 0)
            {
                return;
            }
            int delta = -1;
            int now = -1;
            int prev = -1;
            String result = "";
            String temp = "";
            int count = 0;
            for (int i = lowBound(primes, start - 10), j = 0; i < P; i++)
            {
                if (prev == -1)
                {
                    prev = now = primes[i];
                    count++;
                } else
                {
                    prev = now;
                    now = primes[i];
                    count++;
                    if (delta == now - prev && count > 2)
                    {
                        temp += " " + now;
                    } else
                    {
                        if (count - 1 >= 3)
                        {
                            int first = Integer.parseInt(temp.substring(0, temp.indexOf(' ')));
                            int last = Integer.parseInt(temp.substring(temp.lastIndexOf(' ') + 1));
                            if (first >= start && first <= end && last >= start && last <= end)
                            {
                                result += temp + "\n";
                            }
                        }
                        count = 2;
                        if (now >= end + 10)
                        {
                            break;
                        }
                        temp = prev + " " + now;
                        delta = now - prev;
                    }
                }
            }
            if (count >= 3)
            {
                result += temp;
            }
            if (result.trim().length() > 0)
            {
                System.out.println(result.trim());
            }
        }
    }

    public int lowBound(int[] primes, int value)
    {
        int low = -1;
        int high = P;
        while (high - low > 1)
        {
            int mid = low + (high - low) / 2;
            if (primes[mid] < value)
            {
                low = mid;
            } else
            {
                high = mid;
            }
        }
        return high;
    }

}
