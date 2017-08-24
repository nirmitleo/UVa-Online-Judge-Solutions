package UVa.AckermannFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 24-Feb-16.
 */
public class Main
{
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while (true)
        {
            tokens = br.readLine().split(" ");
            long a = Long.parseLong(tokens[0]);
            long b = Long.parseLong(tokens[1]);
            if ( a == b && a == 0 )
            {
                break;
            }
            long start = Math.min(a, b);
            long end = Math.max(a, b);
            long max = findCycle(start);
            long number = start;
            long s = start;
            while (start != end)
            {
                int cycle = findCycle(start);
                if ( max < cycle )
                {
                    max = cycle;
                    number = start;
                }
                start++;
            }
            System.out.println("Between " + s + " and " + end + ", " + number + " generates the longest sequence of " + max + " values.");
        }
    }

    public int findCycle(long n)
    {
        int count = 0;
        do
        {
            count++;
            n = (n & 1) == 0 ? (n >> 1) : 3 * n + 1;
        } while (n != 1);
        return count;
    }
}
