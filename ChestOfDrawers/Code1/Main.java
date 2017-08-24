package UVa.ChestOfDrawers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 10/06/2017.
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
        int N = 65;
        int S = 65;
        long[][] locked = new long[N + 1][S + 1];
        long[][] unlocked = new long[N + 1][S + 1];

        locked[0][0] = 1;
        for (int i = 0; i <= N - 1; i++)
        {
            for (int j = 0; j <= S - 1; j++)
            {
                locked[i + 1][j + 1] += locked[i][j];
                unlocked[i][j + 1] += locked[i][j];

                locked[i][j + 1] += unlocked[i][j];
                unlocked[i][j + 1] += unlocked[i][j];
            }
        }

        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (s + n < 0)
            {
                return;
            }
            System.out.println(locked[n][s] + unlocked[n][s]);
        }


    }
}
