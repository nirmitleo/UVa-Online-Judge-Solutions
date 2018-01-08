package UVa.JumpingChampion.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
        int P = 78498;
        int N = (int) 1e6;
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
        outer:
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int from = Math.min(a, b);
            int to = Math.min(Math.max(a, b), N);

            int max = -1;
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = lowBound(primes, from) + 1; i < P && primes[i] <= to; i++)
            {
                int diff = primes[i] - primes[i - 1];
                Integer count = map.get(diff);
                if (count == null)
                {
                    map.put(diff, 1);
                    max = Math.max(max, 1);
                } else
                {
                    map.put(diff, count + 1);
                    max = Math.max(max, count + 1);
                }
            }
            if (max == -1)
            {
                System.out.println("No jumping champion");
                continue outer;
            }
            boolean ok = true;
            int result = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value == max)
                {
                    if (ok)
                    {
                        result = key;
                        ok = false;
                    } else
                    {
                        System.out.println("No jumping champion");
                        continue outer;
                    }
                }

            }
            System.out.println("The jumping champion is " + result);

        }
    }

    public int lowBound(int[] primes, int value)
    {
        int low = -1;
        int high = primes.length;
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
