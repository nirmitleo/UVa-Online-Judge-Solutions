package UVa.AboveAverage.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24/06/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }
            int count = 0;
            double average = sum / (1.0 * n);
            for (int i = 0; i < n; i++)
            {
                if (a[i] > average)
                {
                    count++;
                }
            }

            System.out.println(String.format("%.3f", (count * 100) / (n * 1.0)) + "%");
        }

    }
}
