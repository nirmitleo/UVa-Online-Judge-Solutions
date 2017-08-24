package UVa.DifferentDigits.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 24/06/2017.
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
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int low = Math.min(a, b);
            int high = Math.max(a, b);
            int count = 0;
            outer:
            for (int i = low; i <= high; i++)
            {
                TreeSet<Integer> set = new TreeSet<>();
                int n = i;
                while (n > 0)
                {
                    int d = n % 10;
                    if (set.contains(d))
                    {
                        continue outer;
                    }
                    n /= 10;
                    set.add(d);
                }
                count++;
            }
            System.out.println(count);
        }

    }
}
