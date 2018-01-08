package UVa.PermutationArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by DELL on 16-Oct-15.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
        try
        {
            demo.solve();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void solve() throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine().trim());
        while (n-- > 0)
        {

            in.readLine();
            String index[] = in.readLine().split("\\s+");
            String values[] = in.readLine().split("\\s+");

            for (int i = 0; i < index.length; i++)
            {
                for (int j = 0; j < index.length; j++)
                {
                    if (Integer.parseInt(index[j]) == i + 1)
                    {
                        if (i == index.length - 1)
                        {
                            out.print(values[j]);
                        }
                        else
                        {
                            out.println(values[j]);
                        }
                        break;
                    }
                }
            }
            if (n != 0)
            {
                out.println("\n");
            }
            else
            {
                out.println();
            }

        }
        out.close();
    }
}
