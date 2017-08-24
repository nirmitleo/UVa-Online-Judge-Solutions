package UVa.ForeignExchange.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Nirmit on 19/06/2017.
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
        outer:
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }

            TreeSet<String> e = new TreeSet<>();
            TreeMap<String, Integer> map = new TreeMap<String, Integer>();
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                line = st.nextToken() + " " + st.nextToken();
                e.add(line);
                Integer count = map.get(line);
                if (count == null)
                {
                    map.put(line, 1);
                } else
                {
                    map.put(line, count + 1);
                }
            }

            while (!e.isEmpty())
            {
                String p = e.pollFirst();
                Integer c1 = map.remove(p);

                st = new StringTokenizer(p);
                String q = st.nextToken();
                q = st.nextToken() + " " + q;
                e.remove(q);
                Integer c2 = map.remove(q);


                if (c2 == null || c1.compareTo(c2) != 0)
                {
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");

        }
    }
}
