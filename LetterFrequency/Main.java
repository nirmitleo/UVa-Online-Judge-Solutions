package UVa.LetterFrequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 09-Feb-16.
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
            TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
            char a[] = br.readLine().toLowerCase().toCharArray();
            int max = 0;
            for (int i = 0; i < a.length; i++)
            {
                if (a[i] >= 'a' && a[i] <= 'z')
                {
                    if (map.get(a[i]) != null)
                    {
                        map.put(a[i], map.get(a[i]) + 1);
                    }
                    else
                    {
                        map.put(a[i], 1);
                    }
                    max = Math.max(max, map.get(a[i]));
                }
            }
            String result = "";
            for (Map.Entry<Character, Integer> entry : map.entrySet())
            {
                if (entry.getValue() == max)
                {
                    result += entry.getKey();
                }
            }
            System.out.println(result);
        }
    }

}
