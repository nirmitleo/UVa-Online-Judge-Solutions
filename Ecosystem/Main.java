package UVa.Ecosystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

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
        String line = "";
        while ((line = br.readLine()) != null)
        {
            int n = Integer.parseInt(line);
            boolean a[][] = new boolean[n][n];
            for (int i = 0; i < a.length; i++)
            {
                tokens = br.readLine().split("[ ]+");
                for (int j = 0; j < tokens.length; j++)
                {
                    a[i][j] = tokens[j].equals("1");
                }
            }
            int count = 0;
            TreeSet<String> results = new TreeSet<String>();
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a.length; j++)
                {
                    for (int k = 0; k < a.length; k++)
                    {
                        if ( (a[i][j] && a[j][k] && a[k][i]) && ((i > j && j > k) || (i < j && j < k)) )
                        {
                            count++;
                            System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                        }
                    }
                }
            }
            System.out.println("total:" + count);
            System.out.println();
        }
    }

}
