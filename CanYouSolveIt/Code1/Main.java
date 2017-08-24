package UVa.CanYouSolveIt.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 03/07/2017.
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
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            long p = position(x1, y1);
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            long q = position(x2, y2);

            long result = 0;
            if (p > q)
            {
                result = p - q;
            } else
            {
                result = q - p;
            }
            System.out.println("Case " + t + ": " + result);
        }

    }

    public long position(int x, int y)
    {
        int sum = x + y;
        long last = T(sum + 1);

        int X = sum;
        int Y = 0;
        while (X != x && Y != y)
        {
            last--;
            X--;
            Y++;
        }
        return last;
    }

    public long T(long n)
    {
        long result = n * (n + 1);
        return (result / 2);
    }
}
