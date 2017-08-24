package UVa.Area;

import java.util.Scanner;

/**
 * Created by DELL on 08-Jan-16.
 */
public class Main
{
    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int row = in.nextInt();
            int col = in.nextInt();
            int budget = in.nextInt();
            int a[][] = new int[row][col];
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a[i].length; j++)
                {
                    a[i][j] = in.nextInt();
                    a[i][j] += (i > 0) ? a[i - 1][j] : 0;
                    a[i][j] += (j > 0) ? a[i][j - 1] : 0;
                    a[i][j] -= ((i > 0) && (j > 0)) ? a[i - 1][j - 1] : 0;
                }
            }
            int max = Integer.MIN_VALUE;
            int area = Integer.MIN_VALUE;
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
                            int tempArea = (k - i) * (l - j);
                            if (tempArea >= area)
                            {
                                if ((tempArea > area && temp <= budget) || (tempArea == area && temp < max && temp <= budget))
                                {
                                    area = tempArea;
                                    max = temp;
                                }

                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + t + ": " + area + " " + max);
        }
    }
}
