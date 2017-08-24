package UVa.AckermannFunctions.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 23/06/2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int low = Math.min(a, b);
            int high = Math.max(a, b);
            //System.out.println(low + " " + high);
            if (low == 0 && high == 0)
            {
                return;
            }
            int max = -1;
            int num = -1;
            for (int i = low; i <= high; i++)
            {
                //System.out.println(i);
                int c = 0;
                long x = i;
                do
                {
                    c++;
                    if (x % 2 == 0)
                    {
                        x /= 2;
                    } else
                    {
                        x = 3 * x + 1;
                    }
                } while (x != 1);
                if (c > max)
                {
                    max = c;
                    num = i;
                }
            }
            System.out.println("Between " + low + " and " + high + ", " + num + " generates the longest sequence of " + max + " values.");
        }

    }
}
