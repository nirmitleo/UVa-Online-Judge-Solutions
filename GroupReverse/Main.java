package UVa.GroupReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 09-Apr-16.
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
        while (true)
        {
            line = br.readLine();
            if (line == null)
            {
                return;
            }
            String result = "";

            tokens = line.trim().split("[ ]+");
            int size = Integer.parseInt(tokens[0]);
            if (size == 0)
            {
                return;
            }
            String temp = tokens[1];
            size = temp.length() / size;
            for (int i = 0; i < temp.length(); i += size)
            {
                result += new StringBuffer(temp.substring(i, i + size)).reverse().toString();
            }
            System.out.println(result);
        }
    }
}

