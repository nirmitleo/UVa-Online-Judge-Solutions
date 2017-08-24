package UVa.FractionsAgain;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by DELL on 14-Jan-16.
 */
public class Main
{
    private static TreeMap<Integer, Integer> pair;

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            pair = new TreeMap<Integer, Integer>();
            int k = in.nextInt();
            int count = 0;
            double x = Integer.MAX_VALUE;
            for (int y = k + 1; y <= x; y++)
            {
                x = (y * k) / (y * 1.0 - k);
                if (x % 1 == 0)
                {
                    pair.put(y, (int) x);
                    count++;
                }
            }
            System.out.println(count);
            for (Map.Entry<Integer, Integer> entry : pair.entrySet())
            {
                System.out.println("1/" + k + " = 1/" + entry.getValue() + " + 1/" + entry.getKey());
            }
        }
    }
}
