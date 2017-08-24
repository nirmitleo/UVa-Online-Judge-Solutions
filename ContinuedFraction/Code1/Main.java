package UVa.ContinuedFraction.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 23/06/2017.
 */
public class Main
{
    private final static double EPS = 1e-8;

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
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (; ; )
            {
                int n = N / D;
                int r = N % D;
                result.add(n);
                N = D;
                D = r;
                if (D == 0)
                {
                    break;
                }
            }
            String s = "[";
            for (int i = 0; i < result.size(); i++)
            {
                if (i == 0)
                {
                    s += result.get(i) + ";";
                } else
                {
                    s += result.get(i) + ",";
                }
            }
            System.out.println(s.substring(0, s.length() - 1) + "]");
        }
    }
}
