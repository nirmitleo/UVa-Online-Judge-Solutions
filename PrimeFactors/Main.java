package UVa.PrimeFactors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
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

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while ((line = br.readLine()) != null)
        {
            line = line.trim();
            if ( line.startsWith("0") || line.length() == 0 )
            {
                break;
            }
            int n = Integer.parseInt(line);
            int num = n;
            if ( num < 0 )
            {
                num = -num;
            }
            int limit = (int) Math.sqrt(num);
            TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
            for (int i = 2; i <= limit; i++)
            {
                int c = 0;
                while (num % i == 0)
                {
                    num /= i;
                    c++;
                }
                count.put(i, c);
            }
            if ( num > 1 )
            {
                count.put(num, 1);
            }
            String result = n < 0 ? " -1 x " : "";
            boolean isFirst = true;
            for (Map.Entry<Integer, Integer> entry : count.entrySet())
            {
                int value = entry.getValue();
                int key = entry.getKey();
                while (value-- > 0)
                {
                    if ( isFirst )
                    {
                        result += key;
                        isFirst = false;
                    } else
                    {
                        result += " x " + key;
                    }
                }
            }
            System.out.println(n + " = " + result);
        }

    }

}
