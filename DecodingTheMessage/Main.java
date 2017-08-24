package UVa.DecodingTheMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 03-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int t = Integer.parseInt(br.readLine());
        int tc = 0;
        br.readLine();
        while (t-- > 0)
        {
            String line = "";
            System.out.println("Case #" + (++tc) + ":");
            while ((line = br.readLine()).length() != 0)
            {
                String message = "";
                int index = 0;
                int position = 0;
                String tokens[] = line.split(" ");
                while (true)
                {
                    if (index >= tokens.length)
                    {
                        break;
                    }
                    if (position >= tokens[index].length())
                    {
                        index++;
                        continue;
                    }
                    message += tokens[index].charAt(position);
                    index++;
                    position++;
                }
                System.out.println(message);
            }
            if (t != 0)
            {
                System.out.println();
            }
        }
    }
}
