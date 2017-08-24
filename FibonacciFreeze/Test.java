package UVa.FibonacciFreeze;

import java.util.Random;

/**
 * Created by Nirmit on 18-Mar-16.
 */
public class Test
{
    public static void main(String a[])
    {
        Random r = new Random();
        for (int i = 0; i < 100; i++)
        {

            System.out.println(r.nextInt(5001));
        }
    }
}
