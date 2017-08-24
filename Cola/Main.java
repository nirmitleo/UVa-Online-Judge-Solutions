package UVa.Cola;

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
        while ((line = br.readLine()) != null)
        {
            int n = Integer.parseInt(line.trim());
            int max = 0;
            int limit = (((n / 3) + 1) * 3);
            for (int i = 0; n + i <= limit; i++)
            {
                int j = n + i;
                int result = n;
                while (true)
                {
                    int temp = j / 3;
                    if (temp == 0)
                    {
                        break;
                    }
                    result += temp;
                    temp += j % 3;
                    j = temp;
                }
                max = Math.max(max, result);
            }
            System.out.println(max);
        }
    }
}

