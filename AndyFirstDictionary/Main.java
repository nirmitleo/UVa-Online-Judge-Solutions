package UVa.AndyFirstDictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by DELL on 05-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //BufferedReader br;

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        //br = new BufferedReader(new FileReader(new File("./src/UVa/AndyFirstDictionary/input.txt")));
        String line = "";
        TreeSet<String> dictionary = new TreeSet<String>();
        while ((line = br.readLine()) != null)
        {
            String tokens[] = line.split("([^a-zA-Z]+)");
            for (int i = 0; i < tokens.length; i++)
            {
                if (tokens[i].equals(""))
                {
                    continue;
                }
                dictionary.add(tokens[i].toLowerCase());
            }
        }
        while (!dictionary.isEmpty())
        {
            System.out.println(dictionary.pollFirst());
        }
    }
}
