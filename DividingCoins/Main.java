package UVa.DividingCoins;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by DELL on 12-Jan-16.
 */
public class Main
{
    public static void main(String arp[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while (test-- > 0)
        {
            Main demo = new Main();
            demo.solve(in);
        }
    }

    public void solve(Scanner in)
    {
        int n = in.nextInt();
        if (n == 0)
        {
            System.out.println(0);
            return;
        }
        int a[] = new int[n];
        int totalSum = 0;
        for (int i = 0; i < a.length; i++)
        {
            a[i] = in.nextInt();
            totalSum += a[i];
        }
        boolean possibleSum[] = new boolean[totalSum + 1];
        possibleSum[0] = true;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = totalSum; j >= 0; j--)
            {
                if (possibleSum[j])
                {
                    possibleSum[j + a[i]] = true;
                }
            }
        }
        int sum = 0;
        for (int i = totalSum / 2; i >= 0; i--)
        {
            if (possibleSum[i])
            {
                sum = i;
                break;
            }
        }
        sum = ((totalSum / 2) - sum) * 2;
        System.out.println((totalSum % 2 == 0) ? sum : sum + 1);
    }
}
