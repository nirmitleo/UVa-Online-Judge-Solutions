package UVa.HayPoints.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by DELL on 21-Apr-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        tokens = br.readLine().trim().split("[ ]+");
        int dictSize = Integer.parseInt(tokens[0]);
        int resumeSize = Integer.parseInt(tokens[1]);
        TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();
        while (dictSize-- > 0)
        {
            tokens = br.readLine().trim().split("[ ]+");
            String word = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            dictionary.put(word, value);
        }
        while (resumeSize-- > 0)
        {
            int cost = 0;
            outer:
            while (true)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int i = 0; i < tokens.length; i++)
                {
                    if (tokens[i].equals("."))
                    {
                        break outer;
                    }
                    Integer value = dictionary.get(tokens[i]);
                    if (value != null)
                    {
                        cost += value;
                    }
                }
            }
            System.out.println(cost);
        }
    }
}

