package UVa.AndySecondDictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by DELL on 06-Feb-16.
 */
public class Main
{
    BufferedReader br;

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new FileReader(new File("./src/UVa/AndySecondDictionary/input.txt")));
        String line = "";
        ArrayList<String> lines = new ArrayList<String>();
        TreeSet<String> dictionary = new TreeSet<String>();
        while ((line = br.readLine()) != null)
        {
            String tokens[] = line.split("[^a-zA-Z-]+");
            for (int i = 0; i < tokens.length; i++)
            {
                if (tokens[i].equals(""))
                {
                    continue;
                }
                lines.add(tokens[i]);
            }
        }

        Iterator<String> i = lines.iterator();
        String result = "";
        while (i.hasNext())
        {
            result += i.next();
            while (result.charAt(result.length() - 1) == '-' && i.hasNext())
            {
                String t = i.next();
                if (t.charAt(0) == '-')
                {
                    dictionary.add(result.toLowerCase());
                    result = t;
                    continue;
                }
                result = result.substring(0, result.length() - 1) + t;
            }
            if (!result.equals("-"))
            {
                dictionary.add(result.toLowerCase());
            }
            result = "";
        }
        while (!dictionary.isEmpty())
        {
            System.out.println(dictionary.pollFirst());
        }
    }
}
