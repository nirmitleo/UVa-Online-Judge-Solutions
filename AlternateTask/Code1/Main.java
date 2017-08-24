package UVa.AlternateTask.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/07/2017.
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
        int N = (int) 1e3 + 1;
        int S = (int) 1e3;
        int[] result = new int[S + 1];
        Arrays.fill(result, -1);
        for (int i = N; i >= 1; i--)
        {
            int s = sum(i);
            if (s > S || s < 0)
            {
                continue;
            }
            if (result[s] == -1)
            {
                result[s] = i;
            }
        }
//        for (int i = 0; i <= S; i++)
//        {
//            System.out.println(i + " " + result[i]);
//        }
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            int sum = Integer.parseInt(st.nextToken());
            if (sum == 0)
            {
                return;
            }
            System.out.println("Case " + t + ": " + result[sum]);
        }
    }


    public int sum(int n)
    {
        int result = 1;
        for (int i = 2; i * i <= n; i++)
        {
            int count = 0;
            while (n % i == 0)
            {
                n /= i;
                count++;
            }
            if (count > 0)
            {
                result *= (pow(i, (count + 1)) - 1);
                result /= (i - 1);
            }
        }
        if (n > 1)
        {
            result *= (pow(n, 2) - 1);
            result /= (n - 1);
        }
        return result;
    }

    public long pow(long b, int e)
    {
        long result = 1L;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                result = result * b;
            }
            b *= b;
            e >>= 1;
        }
        return result;
    }
}
