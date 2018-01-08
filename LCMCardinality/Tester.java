package UVa.LCMCardinality;

import java.util.Random;

/**
 * Created by Nirmit on 13-Mar-16.
 */
public class Tester
{
    public static void main(String[] args)
    {
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            System.out.println(random.nextInt(2 * 1000 * 1000 * 1000 + 1));
        }
    }
}
