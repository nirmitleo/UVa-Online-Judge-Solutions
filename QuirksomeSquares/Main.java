package UVa.QuirksomeSquares;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DELL on 12-Dec-15.
 */
public class Main
{
    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> sqs = new ArrayList<Integer>();
        int maxLimit = (int) Math.pow(10, 4);
        for (int i = 0; i < maxLimit; i++)
        {
            sqs.add(i * i);
        }
        while (in.hasNext())
        {
            int n = in.nextInt();
            int limit = (int) Math.pow(10, n);
            for (int i = 0; i < sqs.size(); i++)
            {
                int number = sqs.get(i);
                if (number > limit)
                {
                    break;
                }
                String temp = String.format("%0" + n + "d", number);
                int a = Integer.parseInt(temp.substring(0, n / 2));
                int b = Integer.parseInt(temp.substring(n / 2));
                if ((a * a) + (2 * a * b) + (b * b) == number)
                {
                    System.out.format("%0" + n + "d\n", number);
                }
            }
        }
    }
}
