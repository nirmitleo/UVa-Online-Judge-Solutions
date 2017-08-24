package UVa.Entropy;

import java.io.*;
import java.util.Map;
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
        String line = in.readLine().toLowerCase();
        while (!line.equalsIgnoreCase("****END_OF_INPUT****"))
        {
            TreeMap<String, Integer> p = new TreeMap<String, Integer>();
            int lamda = 0;
            while (!line.equalsIgnoreCase("****END_OF_TEXT****"))
            {
                String tokens[] = line.split("[,.:;!?\"()\\s]");
                for (int i = 0; i < tokens.length; i++)
                {
                    if (tokens[i].isEmpty())
                    {
                        continue;
                    }
                    lamda++;
                    if (p.get(tokens[i]) != null)
                    {
                        p.put(tokens[i], p.get(tokens[i]) + 1);
                    }
                    else
                    {
                        p.put(tokens[i], 1);
                    }
                }
                line = in.readLine().toLowerCase();
            }
            double Emax = Math.log10(lamda);
            double delta = 0;
            for (Map.Entry<String, Integer> entry : p.entrySet())
            {
                delta += (entry.getValue() * (Emax - Math.log10(entry.getValue())));
            }
            double Et = delta / lamda;
            int Erel = (int) Math.round(Et * 100 / Emax);
            out.println(lamda + " " + (String.format("%.1f", Et)) + " " + Erel);
            line = in.readLine().toLowerCase();
        }

    }
}
