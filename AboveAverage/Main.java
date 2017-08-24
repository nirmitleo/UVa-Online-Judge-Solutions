package UVa.AboveAverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Mar-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine().trim());
        while (test-- > 0)
        {
            tokens = br.readLine().trim().split("[ ]+");
            int count = Integer.parseInt(tokens[0]);
            int a[] = new int[count];

            int temp = 0;
            int sum = 0;
            for (int i = 1; i < tokens.length; i++)
            {
                a[temp++] = Integer.parseInt(tokens[i]);
                sum += a[temp - 1];
            }

            while (temp < count)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int i = 0; i < tokens.length; i++)
                {
                    a[temp++] = Integer.parseInt(tokens[i]);
                    sum += a[temp - 1];
                }
            }
            double average = sum / (count * 1.0);
            double ans = 0;
            for (int i = 0; i < a.length; i++)
            {
                if (a[i] > average)
                {
                    ans++;
                }
            }
            ans = (ans * 100) / count;
            String percent = "%";
            System.out.printf("%.3f%s\n", ans, percent);
        }
    }
}

