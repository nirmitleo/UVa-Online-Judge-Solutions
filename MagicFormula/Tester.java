package UVa.MagicFormula;

import java.util.Random;

/**
 * Created by DELL on 30-Mar-16.
 */
public class Tester
{
    public static void main(String ar[])
    {
        Random r = new Random();
        for (int i = 0; i < 1000; i++)
        {
            System.out.println(r.nextInt(1001) + " " + r.nextInt(1001) + " " + r.nextInt(1001) + " " + r.nextInt(1001) + " " + r.nextInt(1000000) + r.nextInt(1000));
        }
        System.out.println("0 0 0 0 0");
    }

}
