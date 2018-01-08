package UVa.LuckyNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/07/2017.
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
//        demo.test1();
    }

    public void test()
    {
        System.out.println(Math.sqrt(1e9));

    }

    public void solve() throws IOException
    {
        int N = 31622;
        int[] sq = new int[N];
        for (int i = 0; i < N; i++)
        {
            sq[i] = i * i;
        }
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            String prefix = "Case " + t + ": ";
            String result = "";
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int i = 1; ; i++)
            {
                if (sq[i] >= n)
                {
                    break;
                }
                int x = n - sq[i];
                if (x % i == 0)
                {
                    result = x + " " + result;
                }
            }
            System.out.println(prefix + result.trim());
        }

    }
}
