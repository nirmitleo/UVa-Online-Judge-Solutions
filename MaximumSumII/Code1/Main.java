package UVa.MaximumSumII.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 23/06/2017.
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
            if (n == 0)
            {
                return;
            }
            boolean allZero = true;
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int num = Integer.parseInt(st.nextToken());
                if (num != 0)
                {
                    allZero = false;
                    sb.append(" " + num);
                }
            }
            if (!allZero)
            {
                System.out.println(sb.toString().trim());
            } else
            {
                System.out.println(0);
            }
        }

    }
}
