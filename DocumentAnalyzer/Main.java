package UVa.DocumentAnalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by DELL on 25-Oct-15.
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
        int n = Integer.parseInt(in.readLine());
        int counter = 0;
        while (n-- > 0)
        {
            String line = in.readLine();
            TreeMap<String, Integer> index = new TreeMap<String, Integer>();
            ArrayList<String> text = new ArrayList<String>();
            while (!line.equalsIgnoreCase("END"))
            {
                String tokens[] = line.split("[^a-z]+");
                for (int i = 0; i < tokens.length; i++)
                {
                    if (!tokens[i].equals(""))
                    {
                        text.add(tokens[i]);
                        index.put(tokens[i], 0);
                    }
                }
                line = in.readLine();
            }
            int total = 0;
            int start = 0;
            int p = 0;
            int q = text.size();
            for (int i = 0; i < text.size(); i++)
            {
                String word = text.get(i);
                if (index.get(word) == 0)
                {
                    total++;
                }
                index.put(word, index.get(word) + 1);
                while (index.get(text.get(start)) > 1)
                {
                    index.put(text.get(start), index.get(text.get(start)) - 1);
                    start++;
                }
                if (total == index.size() && i - start < q - p)
                {
                    p = start;
                    q = i;
                }
            }
            out.println("Document " + (++counter) + ": " + (p + 1) + " " + (q + 1));

        }

    }
}
