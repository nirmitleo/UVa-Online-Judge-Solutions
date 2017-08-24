package UVa.BadCode.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 14/06/2017.
 */
public class Main
{
    private int n;
    private int L;
    private String s;
    private int Z = 9;
    private TreeSet<String> set;
    private Item[] a;
    private String[] zero;

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.init();
        demo.solve();
    }

    public void init()
    {
        zero = new String[Z];
        zero[0] = "";
        for (int i = 1; i < Z; i++)
        {
            zero[i] = zero[i - 1] + "0";
        }
    }

    public void solve() throws IOException
    {
        StringBuilder print = new StringBuilder("");
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                out.println(print);
                out.flush();
                out.close();
                return;
            }
            TreeSet<Item> b = new TreeSet<Item>();
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                String key = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                b.add(new Item(key, value));
            }
            n = b.size();
            a = new Item[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = b.pollFirst();
            }

            s = in.readLine().trim();
            L = s.length();
            set = new TreeSet<String>();
            go("", "");
            StringBuilder result = new StringBuilder("");
            result.append("Case #" + t + "\n");
            for (int i = 0; i < 100 && !set.isEmpty(); i++)
            {
                result.append(set.pollFirst());
                result.append("\n");
            }
            if (t == 1)
            {
                print.append(result);
            } else
            {
                print.append("\n" + result);
            }
        }
    }

    public void go(String code, String p)
    {
        if (p.length() > L)
        {
            return;
        }
        if (p.length() == L)
        {
            if (p.equals(s))
            {
                set.add(code);
            }
        } else
        {
            for (int j = 0; j < n; j++)
            {
                String key = a[j].key;
                int value = a[j].value;
                if (s.indexOf("" + value, p.length() - 1) == -1)
                {
                    continue;
                }
                for (int i = 0; i < Z; i++)
                {
                    String t = p + zero[i] + value;
                    if (t.length() > L)
                    {
                        break;
                    }
                    if (s.startsWith(t))
                    {
                        go(code + key, t);
                    }
                }
            }
        }
    }

    class Item implements Comparable<Item>
    {
        String key;
        int value;

        public Item(String key, int value)
        {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Item that)
        {
            int valueDiff = Integer.compare(this.value, that.value);
            return valueDiff != 0 ? valueDiff : this.key.compareTo(that.key);
        }
    }

}
