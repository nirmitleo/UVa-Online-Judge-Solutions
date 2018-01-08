package UVa.MaximumSumOnTorus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DELL on 08-Jan-16.
 */
public class Main
{
    public ArrayList<int[][]> combinations;

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        Main demo = new Main();
        while (test-- > 0)
        {
            int n = in.nextInt();
            int a[][] = new int[n][n];
            demo.combinations = new ArrayList<int[][]>();
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a[i].length; j++)
                {
                    a[i][j] = in.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a.length; i++)
            {
                int b[][] = demo.shiftRight(a, i);
                if (demo.insert(b))
                {
                    max = Math.max(max, demo.solve(b));
                    for (int k = 0; k < a.length; k++)
                    {
                        int c[][] = demo.shiftDown(b, k);
                        if (demo.insert(c))
                        {
                            max = Math.max(max, demo.solve(c));
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }

    public boolean insert(int a[][])
    {
        for (int i = 0; i < combinations.size(); i++)
        {
            int temp[][] = combinations.get(i);

            if (temp != null && isEqual(a, temp))
            {
                return false;
            }
        }
        return combinations.add(a);
    }

    public boolean isEqual(int a[][], int b[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if (a[i][j] != b[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int solve(int temp2D[][])
    {
        int a[][] = new int[temp2D.length][temp2D[0].length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                a[i][j] = temp2D[i][j];
            }
        }
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                a[i][j] += (i > 0) ? a[i - 1][j] : 0;
                a[i][j] += (j > 0) ? a[i][j - 1] : 0;
                a[i][j] -= ((i > 0) && (j > 0)) ? a[i - 1][j - 1] : 0;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                for (int k = i; k < a.length; k++)
                {
                    for (int l = j; l < a[i].length; l++)
                    {
                        int temp = a[k][l];
                        temp -= (i > 0) ? a[i - 1][l] : 0;
                        temp -= (j > 0) ? a[k][j - 1] : 0;
                        temp += ((i > 0) && (j > 0)) ? a[i - 1][j - 1] : 0;
                        max = Math.max(max, temp);
                    }
                }
            }
        }
        return max;
    }

    public int[][] shiftRight(int a[][], int places)
    {
        int b[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[0].length; j++)
            {
                b[i][(j + places) % a[0].length] = a[i][j];
            }
        }
        return b;
    }

    public int[][] shiftDown(int a[][], int places)
    {
        int b[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                b[(i + places) % a.length][j] = a[i][j];
            }
        }
        return b;
    }
}
