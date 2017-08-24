package UVa.ContinuedFraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Mar-16.
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

        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            int n = Integer.parseInt(tokens[0]);
            int d = Integer.parseInt(tokens[1]);
            String result = "";
            boolean isFirst = true;
            while (true)
            {
                int quotient = n / d;
                int remainder = n % d;
                if (isFirst)
                {
                    isFirst = false;
                    result += quotient + ";";
                } else
                {
                    result += quotient + ",";
                }
                if (remainder == 0)
                {
                    break;
                }
                n = d;
                d = remainder;
            }
            System.out.println("[" + result.substring(0, result.length() - 1) + "]");
        }
    }
}

