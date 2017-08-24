package UVa.DigitCounting.Code1;

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
        int test = Integer.parseInt(in.readLine().trim());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] digit = new int[10];
            for (int i = 1; i <= n; i++)
            {
                int num = i;
                while (num > 0)
                {
                    int d = num % 10;
                    digit[d]++;
                    num /= 10;
                }
            }
            String result = "";
            for (int i = 0; i < 10; i++)
            {
                result += digit[i] + " ";
            }
            System.out.println(result.trim());
        }

    }
}
