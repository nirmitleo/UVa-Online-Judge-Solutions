package UVa.PeriodicStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 07-Feb-16.
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
        int test = Integer.parseInt(br.readLine());
        boolean isFirst = true;
        while (test-- > 0)
        {
            br.readLine();
            String tokens[] = br.readLine().split(" ");
            String text = tokens[0];
            for (int i = 1; i <= text.length(); i++)
            {
                String t = "";
                String pattern = text.substring(0, i);
                int length = pattern.length();
                for (int j = 0; j < text.length() / length; j++)
                {
                    t += pattern;
                }
                if (t.equals(text))
                {
                    if (isFirst)
                    {
                        System.out.print(pattern.length() + "\n");
                        isFirst = false;
                    }
                    else
                    {
                        System.out.println("\n" + pattern.length());
                    }
                    break;
                }
            }
        }
    }
}
