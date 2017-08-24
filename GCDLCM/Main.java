package UVa.GCDLCM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    1) Dont forget to remove the package statement
    2) Remove the public access specifier from the UpperBound class.
    
    Train insane or remain the same!
*/

public class Main
{
    String line = "";
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            tokens = br.readLine().split("[ ]+");
            int g = Integer.parseInt(tokens[0]);
            int l = Integer.parseInt(tokens[1]);
            if ( l % g == 0 )
            {
                System.out.println(g + " " + l);
            } else
            {
                System.out.println(-1);
            }

        }
    }

}
