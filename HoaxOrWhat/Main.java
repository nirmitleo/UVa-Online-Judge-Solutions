package UVa.HoaxOrWhat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by DELL on 06-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        boolean isFirst = true;
        while (true)
        {
            line = br.readLine();
            if (line.charAt(0) == '0')
            {
                break;
            }
            int sum = 0;
            int count = 0;
            int n = Integer.parseInt(line);
            TreeSet<Item> a = new TreeSet<Item>();
            while (n-- > 0)
            {
                String tokens[] = br.readLine().split(" ");
                for (int i = 1; i < tokens.length; i++)
                {
                    a.add(new Item(count++, Integer.parseInt(tokens[i])));
                }
                sum += a.pollLast().q - a.pollFirst().q;
            }
            System.out.println(sum);
        }
    }
}

class Item implements Comparable<Item>
{
    int id;
    long q;

    public Item(int id, int q)
    {
        this.id = id;
        this.q = q;
    }

    public int compareTo(Item that)
    {
        long diff = this.q - that.q;
        return diff < 1 ? -1 : diff > 1 ? 1 : this.id - that.id;
    }
}
