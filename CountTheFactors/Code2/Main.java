package UVa.CountTheFactors.Code2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/07/2017.
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
        int N = (int) 1e6;
        int[] seive = new int[N + 1];
        for (int i = 2; i <= N; i++)
        {
            if (seive[i] == 0)
            {
                for (int j = i; j <= N; j += i)
                {
                    seive[j]++;
                }
            }
        }
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            System.out.println(n + " : " + seive[n]);
        }

    }
}
