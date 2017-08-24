package UVa.BrickGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by DELL on 23-Feb-16.
 */
public class Main
{
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
        for (int t = 1; t <= test; t++)
        {
            tokens = br.readLine().split(" ");
            int a[] = new int[tokens.length - 1];
            for (int i = 1; i < tokens.length; i++)
            {
                a[i - 1] = Integer.parseInt(tokens[i]);
            }
            Arrays.sort(a);
            System.out.println("Case " + t + ": " + a[a.length / 2 ]);
        }
    }
}
