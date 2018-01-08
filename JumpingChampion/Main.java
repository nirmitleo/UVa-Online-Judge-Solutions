package UVa.JumpingChampion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
    PrintWriter sout = new PrintWriter(System.out, true);

    private boolean primes[] = new boolean[1000002];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i < primes.length; i++)
        {
            if ( primes[i] )
            {
                for (int j = i * i; j < primes.length; j += i)
                {
                    primes[j] = false;
                }
            }
        }
        ArrayList<Integer> p = new ArrayList<Integer>();
        for (int i = 0; i < primes.length; i++)
        {
            if ( primes[i] )
            {
                p.add(i);
            }
        }

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            TreeMap<Integer, Integer> diff = new TreeMap<Integer, Integer>();
            tokens = br.readLine().split(" ");
            int lower = Integer.parseInt(tokens[0]);
            int upper = Integer.parseInt(tokens[1]);
            for (int i = 1; i < p.size(); i++)
            {
                if ( p.get(i) > upper )
                {
                    break;
                }
                if ( p.get(i) <= upper && p.get(i - 1) >= lower )
                {
                    int delta = p.get(i) - p.get(i - 1);
                    if ( diff.get(delta) != null )
                    {
                        diff.put(delta, diff.get(delta) + 1);
                    } else
                    {
                        diff.put(delta, 1);
                    }
                }
            }
            int max = -1;
            for (Map.Entry<Integer, Integer> entry : diff.entrySet())
            {
                max = Math.max(max, entry.getValue());
            }
            int d = -1;
            boolean isFound = false;
            boolean isDuplicate = false;
            for (Map.Entry<Integer, Integer> entry : diff.entrySet())
            {
                if ( isFound && max == entry.getValue() && d != -1 )
                {
                    isDuplicate = true;
                    break;
                }
                if ( max == entry.getValue() && d == -1 && !isFound )
                {
                    d = entry.getKey();
                    max = entry.getValue();
                    isFound = true;
                }
            }
            if ( isDuplicate || d == -1 )
            {
                System.out.println("No jumping champion");
            } else
            {
                System.out.println("The jumping champion is " + d);
            }
        }

        sout.flush();
        sout.close();
    }

}
