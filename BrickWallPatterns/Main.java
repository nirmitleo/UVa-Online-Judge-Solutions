package UVa.BrickWallPatterns;

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
    int results[] = new int[51];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;
        for (int i = 4; i < results.length; i++)
        {
            results[i] = results[i - 1] + results[i - 2];
        }
        while (!(line = br.readLine()).trim().startsWith("0"))
        {
            int n = Integer.parseInt(line);
            System.out.println(results[n]);
        }

    }

}
