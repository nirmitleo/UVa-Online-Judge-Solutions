package UVa.Multifactorials.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
        BigInteger max = BigInteger.valueOf((long) 1e18);
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        outer:
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            String s = st.nextToken();
            int exclam = s.indexOf("!");
            int f = s.length() - exclam;
            int N = Integer.parseInt(s.substring(0, exclam));
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = N; i >= N % f; i -= f)
            {
                int num = i;
                for (int j = 2; j * j <= num; j++)
                {
                    int count = 0;
                    while (num % j == 0)
                    {
                        count++;
                        num /= j;
                    }
                    if (count > 0)
                    {
                        Integer c = map.get(j);
                        c = (c == null) ? count : c + count;
                        map.put(j, c);
                    }
                }
                if (num > 1)
                {
                    Integer c = map.get(num);
                    c = (c == null) ? 1 : c + 1;
                    map.put(num, c);
                }
            }
            BigInteger result = BigInteger.ONE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                long value = entry.getValue();
                value += 1;
                result = result.multiply(BigInteger.valueOf(value));
                if (result.compareTo(max) > 0)
                {
                    System.out.println("Case " + t + ": Infinity");
                    continue outer;
                }
            }
            System.out.println("Case " + t + ": " + result);
        }

    }
}
