package UVa.FibinaryNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
    1) Dont forget to remove the package statement
    2) Remove the public access specifier from the UpperBound class.
    
    Train insane or remain the same!
*/

public class Main
{
    String line = "";
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger f[] = new BigInteger[200];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        boolean isFirst = true;

        f[0] = BigInteger.ONE;
        f[1] = BigInteger.valueOf(2);
        for (int i = 2; i < f.length; i++)
        {
            f[i] = f[i - 1].add(f[i - 2]);
        }

        while (true)
        {
            String first = br.readLine();
            String second = br.readLine();

            BigInteger a = convertToDecimal(first);
            BigInteger b = convertToDecimal(second);

            BigInteger add = a.add(b);

            String result = convertToFinary(add);
            System.out.println(result);
            if (br.readLine() == null)
            {
                break;
            }
            System.out.println();
        }
    }

    public String convertToFinary(BigInteger number)
    {
        int index = -1;
        String result = "";
        for (int i = 0; i < f.length; i++)
        {
            if (number.compareTo(f[i]) < 0)
            {
                index = (i == 0) ? 0 : i - 1;
                break;
            }
        }
        for (int i = index; i >= 0; i--)
        {
            if (number.compareTo(f[i]) >= 0)
            {
                number = number.subtract(f[i]);
                result += "1";
            } else
            {
                result += "0";
            }
        }
        return result;
    }

    public BigInteger convertToDecimal(String number)
    {
        BigInteger result = BigInteger.ZERO;
        for (int i = number.length() - 1, j = 0; i >= 0; i--, j++)
        {
            if (number.charAt(i) == '1')
            {
                result = result.add(f[j]);
            }
        }
        return result;
    }

}
