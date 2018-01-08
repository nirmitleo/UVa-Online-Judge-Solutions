package UVa.HowManyFibs;

import java.util.Random;

/**
 * Created by Nirmit on 18-Mar-16.
 */
public class Test
{
    public static void main(String ar[])
    {
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            int a = random.nextInt(51);
            int b = random.nextInt(51);
            System.out.println(Math.min(a, b) + " " + Math.max(a, b));
        }
        System.out.println("0 0");
    }
}
