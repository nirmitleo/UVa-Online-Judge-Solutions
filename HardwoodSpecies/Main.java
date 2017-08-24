package UVa.HardwoodSpecies;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 23-Oct-15.
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
        int test = Integer.parseInt(in.readLine());
        in.readLine();

        while (test-- > 0)
        {
            TreeMap<String, Integer> distribution = new TreeMap<String, Integer>();
            int count = 0;
            while (true)
            {
                String line = in.readLine();
                if ( line == null || line.isEmpty() )
                {
                    break;
                }
                count++;
                if ( distribution.get(line) != null )
                {
                    distribution.put(line, distribution.get(line) + 1);
                } else
                {
                    distribution.put(line, 1);
                }
            }
            int i = distribution.size();
            for (Map.Entry<String, Integer> entry : distribution.entrySet())
            {
                if ( i == 1 && test == 0 )
                {
                    out.print(entry.getKey() + " here" + (new DecimalFormat("######.####").format(entry.getValue() * 100 / (1.0 * count))));
                } else
                {
                    out.println(entry.getKey() + " " + (new DecimalFormat("######.####").format(entry.getValue() * 100 / (1.0 * count))));
                }
                i--;
            }
        }
        System.exit(0);
    }
}
