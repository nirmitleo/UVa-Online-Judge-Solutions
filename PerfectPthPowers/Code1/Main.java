package UVa.PerfectPthPowers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long N = Long.parseLong(st.nextToken());
            if (N == 0)
            {
                return;
            }

            long num = Math.abs(N);
            int limit = Integer.MAX_VALUE;
            TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
            for (long i = 2; i * i <= Math.abs(N); i++)
            {
                int count = 0;
                while (num % i == 0)
                {
                    num /= i;
                    count++;
                }
                if (count > 0)
                {
                    limit = Math.min(limit, count);
                    map.put(i, count);
                }
            }
            if (num > 1)
            {
                System.out.println(1);
                continue;
            }
            outer:
            for (int i = limit; i >= 1; i--)
            {
                for (Map.Entry<Long, Integer> entry : map.entrySet())
                {
                    if (entry.getValue() % i != 0)
                    {
                        continue outer;
                    }
                }
                if (N < 0 && i % 2 == 0)
                {
                    continue;
                }
                System.out.println(i);
                break;
            }
        }

    }
}
