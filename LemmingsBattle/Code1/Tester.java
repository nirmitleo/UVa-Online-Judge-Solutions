package UVa.LemmingsBattle.Code1;

import java.util.Random;

/**
 * Created by DELL on 24-Apr-16.
 */
public class Tester
{
    public static void main(String ar[])
    {
        Random r = new Random();
        int test = r.nextInt(10);
        System.out.println(test);
        for (int t = 1; t <= test; t++)
        {
            int a = r.nextInt(11);
            int b = r.nextInt(10);
            int c = r.nextInt(10);
            int total = b + c;

            System.out.println(a + " " + b + " " + c);
            for (int i = 0; i < total; i++)
            {
                System.out.println(r.nextInt(100));
            }
        }
    }
}
