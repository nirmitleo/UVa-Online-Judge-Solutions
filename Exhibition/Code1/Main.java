package UVa.Exhibition.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 23-Apr-16.
 */
public class Main
{

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
        for (int t = 1; t <= test; t++)
        {
            String result = "";
            int rows = Integer.parseInt(br.readLine().trim());
            int a[][] = new int[rows][];
            int unique[] = new int[rows];
            for (int i = 0; i < a.length; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int cols = Integer.parseInt(tokens[0]);
                a[i] = new int[cols];

                for (int j = 1; j < tokens.length; j++)
                {
                    a[i][j - 1] = Integer.parseInt(tokens[j]);
                }
            }
            //print(a);

            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a[i].length; j++)
                {
                    int value = a[i][j];
                    if (value == -1)
                    {
                        continue;
                    }
                    boolean isFound = false;
                    for (int k = i; k < a.length; k++)
                    {
                        int l = (k == i) ? j + 1 : 0;
                        for (; l < a[k].length; l++)
                        {
                            if (value == a[k][l])
                            {
                                a[k][l] = -1;
                                if (k != i)
                                {
                                    isFound = true;
                                }
                            }
                        }
                    }
                    if (!isFound)
                    {
                        unique[i]++;
                    }
                }
            }
            double total = 0;
            boolean isAllZero = true;
            for (int i = 0; i < unique.length; i++)
            {
                total += unique[i];
                if (total != 0)
                {
                    isAllZero = false;
                }
            }
            for (int i = 0; !isAllZero && i < unique.length; i++)
            {
                result += String.format("%.6f", unique[i] * 100.0 / total) + "% ";
            }
            System.out.println("Case " + t + ": " + result.trim());
        }
    }

    public void print(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

