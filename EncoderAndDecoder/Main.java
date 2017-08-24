package UVa.EncoderAndDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Jan-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        int test = 0;
        while ((line = br.readLine()) != null)
        {
            String ans = "";
            String decode = "";
            if (line.length() == 0)
            {
                System.out.println();
                continue;
            }
            for (int i = line.length() - 1; i >= 0; i--)
            {
                char ch = line.charAt(i);
                if (ch >= '0' && ch <= '9')
                {
                    decode += ch;
                    int ascii = Integer.parseInt(decode);
                    if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 121) || ascii == 32 || ascii == 33 || ascii == 44 || ascii == 46 || ascii == 58 || ascii == 59 || ascii == 63)
                    {
                        ans += ((char) ascii);
                        decode = "";
                    }
                }
                else
                {
                    String c = ((int) ch) + "";
                    for (int j = c.length() - 1; j >= 0; j--)
                    {
                        ans += c.charAt(j);
                    }
                }
            }
            if (test == 0)
            {
                System.out.print(ans);
            }
            else
            {
                System.out.print("\n" + ans);
            }
            test++;
        }
    }
}
