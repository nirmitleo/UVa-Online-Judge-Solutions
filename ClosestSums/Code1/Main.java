package UVa.ClosestSums.Code1;

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
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                a[i] = Integer.parseInt(st.nextToken());
            }

            StringBuilder sb = new StringBuilder("Case " + t + ":\n");
            st = new StringTokenizer(in.readLine());
            int q = Integer.parseInt(st.nextToken());
            while (q-- > 0)
            {
                st = new StringTokenizer(in.readLine());
                int S = Integer.parseInt(st.nextToken());

                int first = -1;
                int second = -1;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++)
                {
                    for (int j = i + 1; j < n; j++)
                    {
                        if (i != j)
                        {
                            int delta = Math.abs(S - (a[i] + a[j]));
                            if (delta < min)
                            {
                                first = a[i];
                                second = a[j];
                                min = delta;
                            }
                        }
                    }
                }
                sb.append("Closest sum to " + S + " is " + (first + second) + ".\n");
            }
            System.out.print(sb);
        }

    }
}
