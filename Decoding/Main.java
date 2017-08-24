package UVa.Decoding;

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
        while (t-- > 0)
        {
            String line = br.readLine();
            int f = 0;
            String ans = "";
            int place = 1;
            char currentChar = line.charAt(0);
            for (int i = 1; i < line.length(); i++)
            {
                char temp = line.charAt(i);
                while (temp >= '0' && temp <= '9')
                {
                    f = (f * place) + Integer.parseInt(temp + "");
                    place *= 10;
                    if (i + 1 >= line.length())
                    {
                        break;
                    }
                    temp = line.charAt(++i);
                }
                while (f > 0)
                {
                    ans += currentChar;
                    f--;
                }
                currentChar = temp;
                place = 1;
            }
            System.out.println("Case " + (++tc) + ": " + ans);
        }

    }
}
