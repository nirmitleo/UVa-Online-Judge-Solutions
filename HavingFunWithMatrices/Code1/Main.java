package UVa.HavingFunWithMatrices.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 28-Apr-16.
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
            int n = Integer.parseInt(br.readLine());
            int a[][] = new int[n][n];
            for (int i = 0; i < a.length; i++)
            {
                line = br.readLine();
                for (int j = 0; j < a.length; j++)
                {
                    a[i][j] = Integer.parseInt(line.charAt(j) + "");
                }
            }
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++)
            {
                String command = br.readLine();
                if (command.equals("transpose"))
                {
                    a = transpose(a);
                } else if (command.contains("row"))
                {
                    tokens = command.trim().split("[ ]+");
                    int from = Integer.parseInt(tokens[1]);
                    int to = Integer.parseInt(tokens[2]);
                    a = row(a, from, to);

                } else if (command.contains("col"))
                {
                    tokens = command.trim().split("[ ]+");
                    int from = Integer.parseInt(tokens[1]);
                    int to = Integer.parseInt(tokens[2]);
                    a = col(a, from, to);
                } else if (command.contains("inc"))
                {
                    a = increment(a);
                } else
                {
                    a = decrement(a);
                }
            }
            System.out.println("Case #" + t);
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a.length; j++)
                {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public int[][] row(int a[][], int from, int to)
    {
        from = from - 1;
        to = to - 1;
        for (int i = 0; i < a.length; i++)
        {
            int temp = a[from][i];
            a[from][i] = a[to][i];
            a[to][i] = temp;
        }
        return a;
    }

    public int[][] col(int a[][], int from, int to)
    {
        from = from - 1;
        to = to - 1;
        for (int i = 0; i < a.length; i++)
        {
            int temp = a[i][from];
            a[i][from] = a[i][to];
            a[i][to] = temp;
        }
        return a;
    }

    public int[][] transpose(int a[][])
    {
        int b[][] = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    public int[][] increment(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if (a[i][j] == 9)
                {
                    a[i][j] = 0;
                } else
                {
                    a[i][j]++;
                }
            }
        }
        return a;
    }

    public int[][] decrement(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if (a[i][j] == 0)
                {
                    a[i][j] = 9;
                } else
                {
                    a[i][j]--;
                }
            }
        }
        return a;
    }
}

