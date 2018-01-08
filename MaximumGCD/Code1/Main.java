package UVa.MaximumGCD.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 09/07/2017.
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
            ArrayList<Integer> a = new ArrayList<Integer>();
            while (st.hasMoreTokens())
            {
                a.add(Integer.parseInt(st.nextToken()));
            }
            int n = a.size();
            Integer[] b = new Integer[n];
            a.toArray(b);
            int result = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    result = Math.max(result, gcd(b[i], b[j]));
                }
            }
            System.out.println(result);
        }
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
