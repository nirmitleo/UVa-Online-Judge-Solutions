package UVa.PowerStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 07-Feb-16.
 */
public class Main
{
    int b[];
    String text;
    String pattern;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        pattern = "";
        while (true)
        {
            pattern = br.readLine();
            b = new int[pattern.length() + 1];
            if (pattern.charAt(0) == '.')
            {
                break;
            }
            text = pattern + pattern;
            ppKMP();
            int index = searchKMP(1);
            System.out.println(pattern.length() / index);

        }
    }

    public void ppKMP()
    {
        int i = 0;
        int j = -1;
        b[0] = -1;
        while (i < pattern.length())
        {
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j))
            {
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }
    }

    public int searchKMP(int offset)
    {
        int i = offset;
        int j = 0;
        while (i < text.length())
        {
            while (j >= 0 && text.charAt(i) != pattern.charAt(j))
            {
                j = b[j];
            }
            i++;
            j++;
            if (j == pattern.length())
            {
                return i - j;
            }
        }
        return -1;
    }
}

