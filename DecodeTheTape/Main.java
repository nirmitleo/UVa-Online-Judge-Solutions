package UVa.DecodeTheTape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 01-Feb-16.
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
        br.readLine();
        String line = "";
        String ans = "";
        int test = 0;
        while (!(line = br.readLine()).contains("_"))
        {

            String asciiNumber = "";
            for (int i = 0; i < line.length(); i++)
            {
                asciiNumber += (line.charAt(i) == ' ') ? "0" : (line.charAt(i) == 'o') ? "1" : "";
            }
            char c = (char) Integer.parseInt(asciiNumber, 2);
            ans += (c == 13) ? "\n" : c;
        }
        if (test == 0)
        {
            System.out.print(ans);
        }
        else
        {
            System.out.println("\n" + ans);
        }
    }
}
