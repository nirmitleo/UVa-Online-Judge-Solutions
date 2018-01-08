package UVa.MaximumSubSequenceProduct;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by DELL on 29-Dec-15.
 */
public class Main
{
    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        demo.solve(in);
    }

    public void solve(Scanner in)
    {
        while (in.hasNext())
        {
            String tokens[] = in.nextLine().split(" ");
            int a[] = new int[tokens.length - 1];
            for (int i = 0; i < tokens.length - 1; i++)
            {
                a[i] = Integer.parseInt(tokens[i]);
            }

            BigInteger product = BigInteger.ONE;
            BigInteger lastNegativeProduct = BigInteger.ONE;
            BigInteger max = BigInteger.valueOf(a[0]);
            for (int i = 0; i < a.length; i++)
            {
                product = product.multiply(BigInteger.valueOf(a[i]));
                lastNegativeProduct = lastNegativeProduct.multiply(BigInteger.valueOf(a[i]));
                max = product.max(lastNegativeProduct);
                max = max.max(BigInteger.valueOf(a[i]));

                lastNegativeProduct = (a[i] < 0) ? BigInteger.valueOf(a[i]) : lastNegativeProduct;
            }
            System.out.println(max);
        }
    }
}
