package UVa.DroppingBalls;

import java.util.Scanner;

/**
 * Created by DELL on 18-Dec-15.
 */
public class Main
{
    public static void main(String arr[])
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while (test-- > 0)
        {
            int n = in.nextInt();
            if (n == -1)
            {
                break;
            }
            int size = (1 << n) - 1;
            int times = in.nextInt();
            int currentPosition = 1;
            while (currentPosition <= size)
            {
                currentPosition = (times % 2 == 0) ? (currentPosition << 1) + 1 : (currentPosition << 1);
                times = (int) Math.ceil(times / 2.0);
            }
            System.out.println(currentPosition >> 1);
        }
    }
}
