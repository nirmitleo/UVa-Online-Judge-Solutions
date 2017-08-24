package UVa.ClosestSums;

import java.util.Scanner;

/**
 * Created by DELL on 14-Jan-16.
 */
public class Main
{
    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        while (true)
        {
            int n = in.nextInt();
            if (n == 0)
            {
                break;
            }
            counter++;
            int a[] = new int[n];
            for (int i = 0; i < a.length; i++)
            {
                a[i] = in.nextInt();
            }
            int query = in.nextInt();
            for (int q = 1; q <= query; q++)
            {
                int number = in.nextInt();
                int min = Integer.MAX_VALUE;
                int ans = 0;
                for (int i = 0; i < a.length; i++)
                {
                    for (int j = 0; j < a.length; j++)
                    {
                        if (i == j)
                        {
                            continue;
                        }
                        int sum = a[i] + a[j];
                        int diff = Math.abs(number - sum);
                        if (diff < min)
                        {
                            min = diff;
                            ans = sum;
                        }
                    }
                }
                if (q == 1)
                {
                    System.out.println("Case " + counter + ":");
                }
                System.out.println("Closest sum to " + number + " is " + ans + ".");
            }
        }
    }
}
