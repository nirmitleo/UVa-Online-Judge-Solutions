package UVa.ExactSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DELL on 23-Dec-15.
 */
public class Main
{
    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < a.length; i++)
            {
                a[i] = in.nextInt();
            }
            int price = in.nextInt();
            int diff = Integer.MAX_VALUE;
            int first = 0;
            int second = 0;
            Arrays.sort(a);
            for (int i = 0; i < a.length; i++)
            {
                int index = Arrays.binarySearch(a, price - a[i]);
                if (index >= 0 && index != i && Math.abs(a[index] - a[i]) < diff)
                {
                    diff = Math.abs(a[index] - a[i]);
                    first = a[index];
                    second = a[i];
                }
            }
            System.out.println("Peter should buy books whose prices are " + Math.min(first, second) + " and " + Math.max(first, second) + ".\n");
            in.nextLine();
        }
    }
}
