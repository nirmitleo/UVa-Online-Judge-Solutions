package UVa.MemoryOverflow.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 17/07/2017.
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
            int count = 0;

            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] a = st.nextToken().toCharArray();
            for (int i = 0; i < n; i++)
            {
                char now = a[i];
                for (int j = i - 1; j >= 0 && j >= i - k; j--)
                {
                    if (a[j] == now)
                    {
                        count++;
                        break;
                    }
                }
            }

            System.out.println("Case " + t + ": " + count);
        }
    }
}
