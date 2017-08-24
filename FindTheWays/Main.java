package UVa.FindTheWays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by DELL on 30-Mar-16.
 */
public class Main
{
    BigInteger b[][] = new BigInteger[2001][2001];
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                b[i][j] = (i == j || j == 0) ? BigInteger.ONE : b[i - 1][j].add(b[i - 1][j - 1]);
            }
        }
        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);

            int aa = Math.max(row, col);
            int bb = Math.min(row, col);
            if (aa <= 0 || bb <= 0)
            {
                System.out.println(1);
            } else
            {
                System.out.println(b[aa][bb].toString().length());
            }
        }

    }
}

