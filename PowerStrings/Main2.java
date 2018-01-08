package UVa.PowerStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 07-Feb-16.
 */
public class Main2
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String text = "";
        while (true)
        {
            text = br.readLine();
            if (text.charAt(0) == '.')
            {
                break;
            }
            for (int length = 1; length <= text.length() / 2; length++)
            {
                String pattern = text.substring(0, length);
                String result = pattern;
                if (text.length() % pattern.length() != 0)
                {
                    for (int c = 1; c < text.length() / pattern.length(); c++)
                    {
                        result += pattern;
                    }
                    if (result.equals(text))
                    {
                        System.out.println(text.length() / pattern.length());
                        break;
                    }
                }
            }
        }
    }
}

