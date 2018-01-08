package UVa.PI.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 08/07/2017.
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
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
//                a[i] = set.pollFirst();
//                a[i] = set.get(i);
                a[i] = Integer.parseInt(in.readLine());
            }
            int count = 0;
            int total = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    int G = gcd(a[i], a[j]);
                    if (G == 1)
                    {
                        count++;
                    }
                    total++;
                }
            }
            if (count == 0)
            {
                System.out.println("No estimate for this data set.");
            } else
            {
                double value = Math.sqrt((total * 6) / (count * 1.0));
                System.out.println(String.format("%.6f", value));
            }
        }
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
