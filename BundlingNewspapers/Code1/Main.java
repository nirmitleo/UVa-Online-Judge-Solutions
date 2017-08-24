package UVa.BundlingNewspapers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/06/2017.
 */
public class Main
{
    private int n;
    private ArrayList<String> names;
    private ArrayList<String> subsets;
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
        for (int t = 1; t <= test; t++)
        {
            while (true)
            {
                line = in.readLine();
                if (line == null)
                {
                    return;
                }
                if (line.trim().length() != 0)
                {
                    break;
                }
            }
            st = new StringTokenizer(line);
            names = new ArrayList<String>();

            String token1 = st.nextToken();
            String token2 = null;
            if (st.hasMoreTokens())
            {
                token2 = st.nextToken();
            }

            for (; ; )
            {
                line = in.readLine();
                if (line == null || line.trim().length() == 0)
                {
                    break;
                }
                names.add(line);
            }

            int low = -1;
            int high = -1;
            n = names.size();
            if (token1.contains("*"))
            {
                low = 1;
                high = 1 << n;
            } else if (token2 == null)
            {
                low = high = Integer.parseInt(token1);
            } else
            {
                low = Integer.parseInt(token1);
                high = Integer.parseInt(token2);
            }

            for (int i = low; i <= high; i++)
            {
                subsets = new ArrayList<>();
                for (int j = 0; j < n; j++)
                {
                    go(j, i - 1, names.get(j), true);
                }
                StringBuilder result = new StringBuilder("");
                if (subsets.size() == 0)
                {
                    break;
                }
                result.append("Size " + i + "\n");
                for (String s : subsets)
                {
                    result.append(s + "\n");
                }
                String s = result.toString();
                System.out.println(s);
            }
            if (t < test)
            {
                System.out.println();
            }
        }
    }

    public void go(int i, int left, String subset, boolean ok)
    {
        if (i == n)
        {
            if (left == 0)
            {
                subsets.add(subset);
            }
        } else
        {
            if (left > 0 && !ok)
            {
                go(i + 1, left - 1, subset + ", " + names.get(i), ok);
            }
            ok = false;
            go(i + 1, left, subset, ok);
        }
    }
}
