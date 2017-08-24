package UVa.DivisibilityOfFactors.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by Nirmit on 10/07/2017.
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
        System.out.println((Integer.MAX_VALUE + "").length());
        System.out.println((Long.MAX_VALUE + "").length());
    }

    public void solve() throws IOException
    {
        outer:
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int F = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            if (F + D == 0)
            {
                return;
            }

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 2; i <= F; i++)
            {
                int num = i;
                for (int j = 2; j * j <= i; j++)
                {
                    int count = 0;
                    while (num % j == 0)
                    {
                        num /= j;
                        count++;
                    }
                    if (count > 0)
                    {
                        Integer c = map.get(j);
                        c = (c == null ? count : c + count);
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
            long result = 1;
            int num = D;
            for (int i = 2; i * i <= D; i++)
            {
                int count = 0;
                while (num % i == 0)
                {
                    num /= i;
                    count++;
                }
                if (count > 0)
                {
                    Integer c = map.get(i);
                    if (c == null || c.compareTo(count) < 0)
                    {
                        System.out.println(0);
                        continue outer;
                    }
                    c -= count;
                    map.put(i, c);
                }
            }
            if (num > 1)
            {
                Integer c = map.get(num);
                if (c == null || c.compareTo(1) < 0)
                {
                    System.out.println(0);
                    continue outer;
                }
                c -= 1;
                map.put(num, c);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                result *= (entry.getValue() + 1);
            }
            System.out.println(result);
        }


    }
}
