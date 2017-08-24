package UVa.GridSuccessors.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 01-May-16.
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
        while (test-- > 0)
        {
            br.readLine();
            int a[][] = new int[3][3];
            for (int i = 0; i < a.length; i++)
            {
                line = br.readLine().trim();
                for (int j = 0; j < a.length; j++)
                {
                    a[i][j] = line.charAt(j) - 48;
                }
            }
            int result = -1;
            //System.out.println("Original matrix");
            //print(a);
            while (!isEnd(a))
            {
                a = convert(a);
                //System.out.println("*******************");
                //print(a);
                result++;
            }
            System.out.println(result);
        }
    }

    public void print(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEnd(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if (a[i][j] != 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] convert(int a[][])
    {
        int temp[][] = new int[3][3];
        int drow[] = new int[]{-1, 0, 1, 0};
        int dcol[] = new int[]{0, -1, 0, 1};
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                int count = 0;
                for (int k = 0; k < 4; k++)
                {
                    if (i + drow[k] >= 0 && i + drow[k] < a.length && j + dcol[k] >= 0 && j + dcol[k] < a.length)
                    {
                        count += a[i + drow[k]][j + dcol[k]];
                    }
                }
                if (count % 2 != 0)
                {
                    temp[i][j] = 1;
                }
            }
        }
        return temp;
    }
}

