package UVa.JillRidesAgain;

import java.util.Scanner;

/**
 * Created by DELL on 27-Dec-15.
 */
public class Main
{
    public static void main(String arpg[])
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 1; k <= t; k++)
        {
            int r = in.nextInt();
            int a[] = new int[r];
            a[0] = 0;
            for (int i = 1; i < a.length; i++)
            {
                a[i] = in.nextInt();
            }
            int sum = 0;
            int maxSum = 0;
            int maxLength = -1;
            int tempLength = -1;
            int start = 1;
            int tempStart = 1;
            for (int j = 1; j < a.length; j++)
            {
                sum += a[j];
                if (sum >= maxSum)
                {
                    if ((sum > maxSum) || (sum == maxSum && (j - tempStart) > maxLength))
                    {
                        maxLength = j - tempStart;
                        start = tempStart;
                    }
                    maxSum = sum;
                }
                if (sum < 0)
                {
                    sum = 0;
                    tempStart = (j + 1 < a.length) ? j + 1 : tempStart;
                }
            }
            if (maxSum == 0)
            {
                System.out.println("Route " + k + " has no nice parts");
            }
            else
            {
                System.out.println("The nicest part of route " + k + " is between stops " + (start) + " and " + (start + maxLength + 1));
            }
        }
    }
}
