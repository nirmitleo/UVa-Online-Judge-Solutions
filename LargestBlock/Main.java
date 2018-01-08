package UVa.LargestBlock;

import java.util.Scanner;

/**
 * Created by DELL on 08-Jan-16.
 */
public class Main
{
    public final static int BLOCK = -100000;

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while (test-- > 0)
        {
            Main demo = new Main();
            int size = in.nextInt();
            int a[][] = new int[size][size];
            int blocks = in.nextInt();
            for (int b = 1; b <= blocks; b++)
            {
                int startRow = in.nextInt() - 1;
                int startColumn = in.nextInt() - 1;

                int endRow = in.nextInt() - 1;
                int endColumn = in.nextInt() - 1;
                demo.placeBlocks(a, startRow, startColumn, endRow, endColumn);
            }
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a[i].length; j++)
                {
                    a[i][j] = (a[i][j] != Main.BLOCK) ? 1 : a[i][j];
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
            max = (max == Main.BLOCK) ? 0 : max;
            System.out.println(max);
        }
    }

    public void placeBlocks(int a[][], int startRow, int startColumn, int endRow, int endColumn)
    {
        for (int i = startRow; i <= endRow; i++)
        {
            for (int j = startColumn; j <= endColumn; j++)
            {
                a[i][j] = Main.BLOCK;
            }
        }

    }
}
