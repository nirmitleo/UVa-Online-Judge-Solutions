package UVa.EcologicalBinPacking;

import java.util.Scanner;

/**
 * Created by DELL on 12-Dec-15.
 */
public class Main
{
    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int bin1[] = new int[3];
            int bin2[] = new int[3];
            int bin3[] = new int[3];
            bin1[0] = in.nextInt();
            bin1[1] = in.nextInt();
            bin1[2] = in.nextInt();

            bin2[0] = in.nextInt();
            bin2[1] = in.nextInt();
            bin2[2] = in.nextInt();

            bin3[0] = in.nextInt();
            bin3[1] = in.nextInt();
            bin3[2] = in.nextInt();


            int min = Integer.MAX_VALUE;
            String pattern = "";

            int temp = bin2[0] + bin3[0] + bin1[2] + bin3[2] + bin1[1] + bin2[1];
            if (temp < min)
            {
                min = temp;
                pattern = "BCG " + min;
            }
            temp = bin2[0] + bin3[0] + bin1[1] + bin3[1] + bin1[2] + bin2[2];
            if (temp < min)
            {
                min = temp;
                pattern = "BGC " + min;
            }
            temp = bin2[2] + bin3[2] + bin1[0] + bin3[0] + bin1[1] + bin2[1];
            if (temp < min)
            {
                min = temp;
                pattern = "CBG " + min;
            }
            temp = bin2[2] + bin3[2] + bin1[1] + bin3[1] + bin1[0] + bin2[0];
            if (temp < min)
            {
                min = temp;
                pattern = "CGB " + min;
            }
            temp = bin2[1] + bin3[1] + bin1[0] + bin3[0] + bin1[2] + bin2[2];
            if (temp < min)
            {
                min = temp;
                pattern = "GBC " + min;
            }
            temp = bin2[1] + bin3[1] + bin1[2] + bin3[2] + bin1[0] + bin2[0];
            if (temp < min)
            {
                min = temp;
                pattern = "GCB " + min;
            }
            System.out.println(pattern);
        }
    }
}
