package UVa.CoconutsRevisited.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 26/06/2017.
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
        start:
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n < 0)
            {
                return;
            }

            int best = 0;
            outer:
            for (int p = 1; p * p <= n + 5; p++)
            {
                //System.out.println("********No of people = " + p + "**************************");
                int sum = n;
                for (int i = 1; i <= p; i++)
                {
                    //System.out.println("Remaining = " + sum + ". Now (" + i + ")th person divides.");
                    if (sum % p != 1)
                    {
                        //System.out.println("Remainder was not equal to 1");
                        continue outer;
                    }
                    sum = sum - (sum / p) - 1;
                }
                if (sum % p == 0)
                {
                    best = p;
                }
            }
            if (best > 0)
            {
                System.out.println(n + " coconuts, " + best + " people and 1 monkey");
            } else
            {
                System.out.println(n + " coconuts, no solution");
            }
        }

    }
}
