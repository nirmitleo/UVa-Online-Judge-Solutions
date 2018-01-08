package UVa.MinimumSumLCM.Code1;

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
//        demo.test1();
    }

    public void test()
    {
        for (int i = 1; i <= 20; i++)
        {
            System.out.println(i);
        }
        System.out.println(0);
    }

    public void solve() throws IOException
    {
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            long N = Integer.parseInt(st.nextToken());
            if (N == 0)
            {
                return;
            }
            if (N == 1)
            {
                System.out.println("Case " + t + ": " + 2);
                continue;
            }
            long num = N;
            TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
            for (long i = 2; i * i <= N; i++)
            {
                int count = 0;
                while (N % i == 0)
                {
                    count++;
                    N /= i;
                }
                if (count > 0)
                {
                    map.put(i, count);
                }
            }
            if (N > 1)
            {
                map.put(N, 1);
            }
            long result = 0;
            if (map.size() == 1)
            {
                result = num + 1;
            } else
            {
                for (Map.Entry<Long, Integer> entry : map.entrySet())
                {
                    long b = entry.getKey();
                    int e = entry.getValue();
                    result += pow(b, e);
                }
            }
            System.out.println("Case " + t + ": " + result);
        }
    }

    public long pow(long b, int e)
    {
        long result = 1L;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                result = result * b;
            }
            b *= b;
            e /= 2;
        }
        return result;
    }
}
