package UVa.ListOfConquests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 07-Feb-16.
 */
public class Main
{
    TreeMap<String, Integer> counting;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        counting = new TreeMap<String, Integer>();
        while (test-- > 0)
        {
            String tokens[] = br.readLine().trim().split(" ");
            String country = tokens[0];
            if (counting.get(country) == null)
            {
                counting.put(country, 1);
            }
            else
            {
                counting.put(country, counting.get(country) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : counting.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
