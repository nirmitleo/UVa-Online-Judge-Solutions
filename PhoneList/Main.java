package UVa.PhoneList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by DELL on 07-Feb-16.
 */
public class Main
{
    String a[];
    String text;
    String pattern;
    int b[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine().trim());
        while (test-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            a = new String[n];
            for (int i = 0; i < a.length; i++)
            {
                a[i] = br.readLine().trim();
            }
            Arrays.sort(a);
            System.out.println(process());
        }
    }

    public String process()
    {
        for (int i = 0; i < a.length - 1; i++)
        {
            pattern = a[i];
            text = a[i + 1];
            if (text.startsWith(pattern))
            {
                return "NO";
            }
        }
        return "YES";
    }

}

    /*public void ppKMP()
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

    public int search()
    {
        int i = 0;
        int j = 0;
        while (i < text.length())
        {
            if(text.charAt(i) != pattern.charAt(j))
            {
                return -1;
            }
            i++;
            j++;
            if (j == pattern.length())
            {
                return i - j;
            }
        }
        return -1;
    }*/

