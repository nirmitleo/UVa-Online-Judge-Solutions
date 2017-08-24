package UVa.BackToIntermediateMath.Code1;

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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            double D = Integer.parseInt(st.nextToken());
            double V = Integer.parseInt(st.nextToken());
            double U = Integer.parseInt(st.nextToken());

            double X = Math.sqrt((U * U) - (V * V));
            if (X == 0 || U < V || V == 0 || U == 0)
            {
                System.out.println("Case " + t + ": can't determine");
                continue;
            }
            double t1 = D / U;
            double t2 = D / X;
            System.out.println("Case " + t + ": " + String.format("%.3f", t2 - t1));
        }

    }
}
