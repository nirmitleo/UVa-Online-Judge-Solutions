package UVa.Benefit.Code1;

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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        outer:
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
//            if (C % A == 0)
//            {
//                System.out.println(C);
//                continue outer;
//            }
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 2; i * i <= C; i++)
            {
                int count = 0;
                while (C % i == 0)
                {
                    C /= i;
                    count++;
                }
                if (count > 0)
                {
                    map.put(i, count);
                }
            }
            if (C > 1)
            {
                map.put(C, 1);
            }
            for (int i = 2; i * i <= A; i++)
            {
                int count = 0;
                while (A % i == 0)
                {
                    A /= i;
                    count++;
                }
                if (count > 0)
                {
                    Integer c = map.get(i);
                    if (c == null || c.compareTo(count) < 0)
                    {
                        System.out.println("NO SOLUTION");
                        continue outer;
                    }
                    if (c.compareTo(count) == 0)
                    {
                        map.remove(i);
                    }
                }
            }
            if (A > 1)
            {
                Integer c = map.get(A);
                if (c == null || c.compareTo(1) < 0)
                {
                    System.out.println("NO SOLUTION");
                    continue outer;
                }
                if (c.compareTo(1) == 0)
                {
                    map.remove(A);
                }
            }
            int B = 1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                int key = entry.getKey();
                int value = entry.getValue();
                for (int e = 1; e <= value; e++)
                {
                    B *= key;
                }
            }
            System.out.println(B);

        }
    }
}
