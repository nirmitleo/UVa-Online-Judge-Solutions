package UVa.AnnagrammaticPrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    1) Dont forget to remove the package statement
    2) Remove the public access specifier from the UpperBound class.
    
    Train insane or remain the same!
*/

public class Main
{

    String line = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int a[];
    private boolean isPrime[] = new boolean[100 * 1000 * 1000];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++)
        {
            if ( isPrime[i] )
            {
                for (int j = i * i; j < isPrime.length; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
        boolean isFirst = true;
        outer:
        while ((line = br.readLine()) != null)
        {
            if ( line.trim().startsWith("0") )
            {
                break;
            }
            int n = Integer.parseInt(line);
            int limit = (int) Math.pow(10, (n + "").length());
            boolean isAnagrammaticPrime = true;
            int i = n + 1;
            for (; i < limit; i++)
            {
                if ( isPrime[i] )
                {
                    a = toIntArray(i);
                    isAnagrammaticPrime = true;
                    Arrays.sort(a);
                    do
                    {
                        int num = toInteger(a);
                        if ( num <= 0 || num > isPrime.length || !isPrime[num] )
                        {
                            isAnagrammaticPrime = false;
                            break;
                        }
                    } while (nextPermutation(a));
                    if ( isAnagrammaticPrime )
                    {
                        System.out.println(i);
                        continue outer;
                    } else
                    {
                        isPrime[i] = false;
                    }
                }
            }
            System.out.println("0");
        }
    }

    public int toInteger(int a[])
    {
        int n = 0;
        String num = "";
        for (int i = 0; i < a.length; i++)
        {
            num += a[i];
        }
        return Integer.parseInt(num);
    }

    public int[] toIntArray(int n)
    {
        int digit[] = new int[(n + "").length()];
        for (int i = digit.length - 1; i >= 0; i--)
        {
            digit[i] = n % 10;
            n /= 10;
        }
        return digit;
    }

    public boolean nextPermutation(int a[])
    {
        int i = a.length - 2;
        for (; i >= 0; i--)
        {
            if ( a[i] < a[i + 1] )
            {
                break;
            }
        }
        if ( i < 0 )
        {
            return false;
        }
        for (int j = a.length - 1; j >= i; j--)
        {
            if ( a[j] > a[i] )
            {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                break;
            }
        }
        //Reverse the array from i+1 to N-1//
        for (int j = i + 1; j < (a.length + i + 1) / 2; j++)
        {
            int temp = a[j];
            a[j] = a[a.length + i - j];
            a[a.length + i - j] = temp;
        }
        return true;
    }

}
