package UVa.AgainPrimeNotime.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        outer:
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int D = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 2; i <= F; i++)
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
                        c = (c == null ? count : count + c);
                        map.put(j, c);
                    }
                }
                if (num > 1)
                {
                    Integer c = map.get(num);
                    c = (c == null ? 1 : c + 1);
                    map.put(num, c);
                }
            }
            int result = Integer.MAX_VALUE;
            int num = D;
            for (int i = 2; i * i <= D; i++)
            {
                int count = 0;
                while (num % i == 0)
                {
                    count++;
                    num /= i;
                }
                if (count > 0)
                {
                    Integer c = map.get(i);
                    if (c == null || c.compareTo(count) < 0)
                    {
                        System.out.println("Case " + t + ":");
                        System.out.println("Impossible to divide");
                        continue outer;
                    }
                    result = Math.min(result, c / count);
                }
            }
            if (num > 1)
            {
                Integer c = map.get(num);
                if (c == null || c.compareTo(1) < 0)
                {
                    System.out.println("Case " + t + ":");
                    System.out.println("Impossible to divide");
                    continue outer;
                } else
                {
                    result = Math.min(result, c);
                }
            }
            System.out.println("Case " + t + ":");
            System.out.println(result);
        }

    }
}
