package UVa.Feynman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 23-Feb-16.
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
        String line = "";
        while (!(line = br.readLine()).startsWith("0"))
        {
            if ( line.trim().length() == 0 )
            {
                break;
            }
            int n = Integer.parseInt(line);
            System.out.println((n * (n + 1) * ((n << 1) + 1)) / 6);
        }
    }

}
