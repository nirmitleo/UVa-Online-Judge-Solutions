package UVa.BarCodes.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 08/06/2017.
 */
public class Main
{
    private int N;
    private int M;
    private int K;
    private long[][][] dp;
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
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dp = new long[N + 1][M + 1][K + 1];
            for (int i = 0; i < N + 1; i++)
            {
                for (int j = 0; j < M + 1; j++)
                {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            long result = go(N - 1, M - 1, K - 1);
            System.out.println(result);
        }
    }

//    public void bfs(int n, int m, int k, String s)
//    {
//        if (n == 0 && m == 0)
//        {
//            System.out.println(s);
//            return;
//        }
//        if (n == 0 || m < 0)
//        {
//            return;
//        }
//
//
//        //different color - check for max different limit//
//        //same color - check for max same length limit//
//        if (k > 0)
//        {
//            char ch = s.charAt(s.length() - 1);
//            bfs(n - 1, m, k - 1, s + ch);
//        }
//        if (m > 0)
//        {
//            char ch = s.charAt(s.length() - 1);
//            if (ch == 'W')
//            {
//                bfs(n - 1, m - 1, K - 1, s + "B");
//            } else
//            {
//                bfs(n - 1, m - 1, K - 1, s + "W");
//            }
//        }
//    }

    public long go(int n, int m, int k)
    {
        if (n == 0 && m == 0)
        {
            return dp[n][m][k] = 1L;
        }
        if (n == 0 || m < 0)
        {
            return 0L;
        }
        if (dp[n][m][k] != -1)
        {
            return dp[n][m][k];
        }

        long c = 0;

        //same color - check for max same length limit//
        if (k > 0)
        {
            c += go(n - 1, m, k - 1);
        }

        //different color - check for max different limit//
        if (m > 0)
        {
            c += go(n - 1, m - 1, K - 1);
        }
        return dp[n][m][k] = c;
    }
}
