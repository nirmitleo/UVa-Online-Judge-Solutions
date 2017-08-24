package UVa.DissectingAHexagon.Code1;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Nirmit on 03/07/2017.
 */
public class Test
{
    public static void main(String[] a)
    {
        Test demo = new Test();
        demo.solve();
    }

    public void solve()
    {
        Random r = new Random();
        for (int i = 0; i < 100; i++)
        {
            BigInteger num = BigInteger.valueOf(r.nextLong());
            if (r.nextInt() % 2 == 0)
            {
                num = num.multiply(num);
                if (r.nextInt() % 2 == 0)
                {
                    num = num.multiply(BigInteger.valueOf(-1));
                }
            }else
            {
                num = num.mod(BigInteger.valueOf(1000001L));
            }
            if (num.compareTo(BigInteger.valueOf(1000001L)) > 0)
            {
                continue;
            }
            System.out.println(num);
        }
    }
}
