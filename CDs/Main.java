package UVa.CDs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
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
        while (true)
        {
            String tokens[] = br.readLine().split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            if (n == m && n == 0)
            {
                break;
            }
            TreeSet<Integer> keys = new TreeSet<Integer>();
            TreeMap<Integer, Integer> a = new TreeMap<Integer, Integer>();
            TreeMap<Integer, Integer> b = new TreeMap<Integer, Integer>();
            while (n-- > 0)
            {
                int temp = Integer.parseInt(br.readLine());
                keys.add(temp);
                a.put(temp, 1);
            }
            while (m-- > 0)
            {
                int temp = Integer.parseInt(br.readLine());
                keys.add(temp);
                b.put(temp, 1);
            }
            int count = 0;
            while (!keys.isEmpty())
            {
                int key = keys.pollFirst();
                count += (a.get(key) != null && b.get(key) != null) ? 1 : 0;
            }
            System.out.println(count);
        }
    }
}
