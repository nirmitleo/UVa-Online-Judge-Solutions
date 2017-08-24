package UVa.AddBricksInTheWall.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 28-Apr-16.
 */
public class Main
{

    int a[][] = new int[9][9];
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
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            for (int i = 0; i < 9; i += 2)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int j = 0, k = 0; j < tokens.length; j++, k += 2)
                {
                    a[i][k] = Integer.parseInt(tokens[j]);
                }
            }

            for (int i = a.length - 1; i > 0; i -= 2)
            {
                for (int j = 1; j < i; j += 2)
                {
                    int sum = a[i - 2][j - 1];
                    a[i][j] = (sum - (a[i][j - 1] + a[i][j + 1])) / 2;
                    a[i - 1][j - 1] = a[i][j - 1] + a[i][j];
                    a[i - 1][j] = a[i][j + 1] + a[i][j];
                }
            }

            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    if (j == 0)
                    {
                        System.out.print(a[i][j]);
                    } else
                    {
                        System.out.print(" " + a[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
}

