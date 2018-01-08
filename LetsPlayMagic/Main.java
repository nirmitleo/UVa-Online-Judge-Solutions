package UVa.LetsPlayMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 11-Apr-16.
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
            int n = Integer.parseInt(line.trim());
            if (n == 0)
            {
                return;
            }
            String cards[] = new String[n];
            int index = -1;
            for (int i = 0; i < n; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                String key = tokens[0];
                int size = tokens[1].length();
                int j = 1;
                for (; j <= size; j++)
                {
                    if (cards[(index + j) % n] != null)
                    {
                        index = (index + 1) % n;
                        j--;
                    }
                }
                j--;
                index = (index + j) % n;
                cards[index] = key;
            }
            String result = "";
            for (int i = 0; i < n; i++)
            {
                result += cards[i] + " ";
            }
            System.out.println(result.trim());
        }
    }
}

