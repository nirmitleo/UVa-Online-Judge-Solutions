package UVa.JustPruneTheList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

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
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            br.readLine();
            String tokens[] = br.readLine().split(" ");
            TreeMap<Integer, Integer> a = new TreeMap<Integer, Integer>();
            for (int i = 0; i < tokens.length; i++)
            {
                int key = Integer.parseInt(tokens[i]);
                if (a.get(key) == null)
                {
                    a.put(key, 1);
                }
                else
                {
                    a.put(key, a.get(key) + 1);
                }
            }
            tokens = br.readLine().split(" ");
            TreeMap<Integer, Integer> b = new TreeMap<Integer, Integer>();
            for (int i = 0; i < tokens.length; i++)
            {
                int key = Integer.parseInt(tokens[i]);
                if (b.get(key) == null)
                {
                    b.put(key, 1);
                }
                else
                {
                    b.put(key, b.get(key) + 1);
                }
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> entryA : a.entrySet())
            {
                int key = entryA.getKey();
                if (b.get(key) != null)
                {
                    if (!entryA.getValue().equals(b.get(key)))
                    {
                        count += Math.abs(entryA.getValue() - b.get(key));
                    }
                    b.put(key, -1);
                }
                else
                {
                    count += entryA.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> entryB : b.entrySet())
            {
                int value = entryB.getValue();
                count = (value == -1) ? count : count + value;
            }
            System.out.println(count);
        }
    }
}
