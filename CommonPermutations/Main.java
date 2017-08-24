package UVa.CommonPermutations;

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
        String line = "";
        while ((line = br.readLine()) != null)
        {
            String a = line;
            TreeMap<Character, Integer> countA = new TreeMap<Character, Integer>();
            for (int i = 0; i < a.length(); i++)
            {
                char key = a.charAt(i);
                if (countA.get(key) != null)
                {
                    countA.put(key, countA.get(key) + 1);
                }
                else
                {
                    countA.put(key, 1);
                }
            }
            String b = br.readLine();
            TreeMap<Character, Integer> countB = new TreeMap<Character, Integer>();
            for (int i = 0; i < b.length(); i++)
            {
                char key = b.charAt(i);
                if (countB.get(key) != null)
                {
                    countB.put(key, countB.get(key) + 1);
                }
                else
                {
                    countB.put(key, 1);
                }
            }
            String result = "";
            for (Map.Entry<Character, Integer> entry : countA.entrySet())
            {
                char keyA = entry.getKey();
                int valueA = entry.getValue();
                if (countB.get(keyA) != null)
                {
                    int min = Math.min(valueA, countB.get(keyA));
                    for (int i = 0; i < min; i++)
                    {
                        result += keyA;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
