package UVa.AMatchMakingProblem.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 20/06/2017.
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
            int M = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            if (M + F == 0)
            {
                return;
            }
            int min = 61;
            for (int i = 0; i < M; i++)
            {
                min = Math.min(min, Integer.parseInt(in.readLine().trim()));
            }
            for (int i = 0; i < F; i++)
            {
                in.readLine();
            }
            if (M <= F)
            {
                System.out.println("Case " + t + ": " + 0);
            } else
            {
                System.out.println("Case " + t + ": " + (M - F) + " " + min);
            }
        }

    }
}
