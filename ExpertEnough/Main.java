package UVa.ExpertEnough;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DELL on 12-Dec-15.
 */
public class Main
{
    ArrayList<Manufacturer> make;

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();

        Main demo = new Main();
        while (test-- > 0)
        {

            int d = in.nextInt();
            demo.make = new ArrayList<Manufacturer>();
            for (int i = 1; i <= d; i++)
            {
                demo.make.add(new Manufacturer(in.next(), in.nextInt(), in.nextInt()));
            }

            int q = in.nextInt();
            for (int i = 1; i <= q; i++)
            {
                System.out.println(demo.solve(in.nextInt()));
            }
            if (test != 0)
            {
                System.out.println();
            }
        }
    }

    public String solve(int queryPrice)
    {
        boolean isFound = false;
        String result = "";
        for (int i = 0; i < make.size(); i++)
        {
            Manufacturer temp = make.get(i);
            if (queryPrice >= temp.low && queryPrice <= temp.high)
            {
                if (isFound)
                {
                    return "UNDETERMINED";
                }
                isFound = true;
                result = temp.name;
            }
        }
        return isFound ? result : "UNDETERMINED";
    }
}

class Manufacturer implements Comparable<Manufacturer>
{
    String name;
    int low;
    int high;

    public Manufacturer(String name, int low, int high)
    {
        this.name = name;
        this.low = low;
        this.high = high;
    }

    public int compareTo(Manufacturer that)
    {
        return this.name.compareTo(that.name);
    }
}