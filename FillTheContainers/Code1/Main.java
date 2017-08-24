package UVa.FillTheContainers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 26-05-2017.
 */
public class Main
{

    private int n;
    private int m;
    private int[] c;
    private int[] v;
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
        while (true)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }

            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            v = new int[n];
            c = new int[m];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
            {
                v[i] = Integer.parseInt(st.nextToken());
            }

            int low = 0;
            int high = (int) 1e9;
            while (high - low > 1)
            {
                int cc = low + (high - low) / 2;
                if (check(cc))
                {
                    high = cc;
                } else
                {
                    low = cc;
                }
            }
            System.out.println(high);
        }
    }

    public boolean check(int cc)
    {
        Arrays.fill(c, cc);
        int j = 0;
        for (int i = 0; i < n; )
        {
            if (c[j] - v[i] >= 0)
            {
                c[j] -= v[i];
                i++;
            } else
            {
                j++;
            }
            if (j == m)
            {
                return false;
            }
        }
        return true;
    }
}
