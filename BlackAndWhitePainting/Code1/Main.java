package UVa.BlackAndWhitePainting.Code1;

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
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            long rows = Long.parseLong(st.nextToken());
            long cols = Long.parseLong(st.nextToken());
            boolean isWhite = Integer.parseInt(st.nextToken()) == 1;
            if (rows == 0 && cols == 0 && !isWhite)
            {
                return;
            }

            long result = (rows - 8 + 1);
            result *= (cols - 8 + 1);
            if (result % 2 != 0)
            {
                result = result / 2;
                result = (isWhite) ? result + 1 : result;
                System.out.println(result);
            } else
            {
                System.out.println(result / 2);
            }
        }

    }
}
