package UVa.CoutingGame.Code1;

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

        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 && m == -1 && k == 0)
            {
                return;
            }
            int[] count = new int[n];
            boolean ok = true;
            for (int i = 0, c = 1; i < n; c++)
            {
                if (c % 7 == 0 || (c + "").contains("7"))
                {
                    count[i]++;
                    if (count[i] == k && i == m)
                    {
                        System.out.println(c);
                        break;
                    }
                }
                if (ok)
                {
                    i++;
                    if (i == n)
                    {
                        i = n - 2;
                        ok = !ok;
                    }
                } else
                {
                    i--;
                    if (i == -1)
                    {
                        i = 1;
                        ok = !ok;
                    }
                }
            }
        }
    }
}
