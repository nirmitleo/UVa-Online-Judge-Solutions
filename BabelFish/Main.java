package UVa.BabelFish;

import java.io.*;
import java.util.TreeMap;

/**
 * Created by DELL on 24-Oct-15.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(outputStream, true);

        Main demo = new Main();
        demo.solve(in, out);

        out.close();
    }

    public void solve(BufferedReader in, PrintWriter out) throws IOException
    {
        TreeMap<String, String> dictionary = new TreeMap<String, String>();
        while (true)
        {
            String line = in.readLine();
            if (line == null || line.isEmpty())
            {
                break;
            }
            String dictionaryEntry[] = line.split("\\s+");
            if (dictionary.get(dictionaryEntry[1]) == null)
            {
                dictionary.put(dictionaryEntry[1], dictionaryEntry[0]);
            }
        }
        while (true)
        {
            String line = in.readLine();
            if (line == null || line.isEmpty())
            {
                break;
            }
            if (dictionary.get(line) == null)
            {
                out.println("eh");
            }
            else
            {
                out.println(dictionary.get(line));
            }
        }
    }
}


