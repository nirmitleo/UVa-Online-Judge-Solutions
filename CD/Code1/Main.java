package UVa.CD.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/06/2017.
 */
public class Main
{
    private int n;
    private int best;
    private String result;
    private int[] tracks;
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
            if (line == null || line.trim().length() == 0)
            {
                return;
            }

            st = new StringTokenizer(line);
            int left = Integer.parseInt(st.nextToken());
            best = left;
            n = Integer.parseInt(st.nextToken());
            tracks = new int[n];
            for (int i = 0; i < n; i++)
            {
                tracks[i] = Integer.parseInt(st.nextToken());
            }

            go(0, left, "");
            System.out.println(result.substring(1) + " sum:" + (left - best));

        }

    }

    public void go(int i, int left, String trace)
    {
        if (i == n)
        {
            if (best > left)
            {
                best = left;
                result = trace;
            }
        } else
        {
            go(i + 1, left, trace);
            if (left - tracks[i] >= 0)
            {
                go(i + 1, left - tracks[i], trace + " " + tracks[i]);
            }
        }
    }
}
