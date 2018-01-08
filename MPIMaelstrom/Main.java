package UVa.MPIMaelstrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 20-Feb-16.
 */
public class Main
{
    private int n;
    private int a[][];
    private final static int MAX = 10000000;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                a[i][j] = (i == j) ? 0 : MAX;
            }
        }
        for (int i = 1; i < a.length; i++)
        {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < tokens.length; j++)
            {
                a[j][i] = (a[i][j] = !tokens[j].equals("x") ? Integer.parseInt(tokens[j]) : a[i][j]);
            }
        }
        for (int k = 0; k < a.length; k++)
        {
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a.length; j++)
                {
                    a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
                }
            }
        }
        int max = -1;
        for (int i = 1; i < a.length; i++)
        {
            max = Math.max(max, a[0][i]);
        }
        System.out.println(max);
    }
}
