package UVa.PhilipJFryProblem.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;

public class PhilipJFryProblem
{
    private int n;
    private int B;
    private int T;
    private Trip[] trips;
    private int[][] dp;
    private final static int INVALID = ((int) 1e7);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            B = 0;
            T = 0;
            n = in.nextInt();
            if (n == 0)
            {
                return;
            }
            trips = new Trip[n];
            for (int i = 0; i < n; i++)
            {
                trips[i] = readTrip(in);
                B += trips[i].balls;
            }
            dp = new int[n][B + 1];
            for (int i = 0; i < n; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }
            int res = go(0, 0);
            out.println(res);
        }
    }

    private int go(int pos, int left)
    {
        if (pos == n)
        {
            return 0;
        }
        if (dp[pos][left] != INVALID)
        {
            return dp[pos][left];
        }
        int aux1 = INVALID;
        int aux2 = INVALID;
        if (left > 0)
        {
            int next = trips[pos].time / 2;
            aux1 = next + go(pos + 1, left - 1 + trips[pos].balls);
        }
        aux2 = trips[pos].time + go(pos + 1, left + trips[pos].balls);
        return dp[pos][left] = Math.min(aux1, aux2);
    }

    private Trip readTrip(FastScanner in)
    {
        int time = in.nextInt();
        int balls = in.nextInt();
        return new Trip(time, balls);
    }

    class Trip
    {
        int time;
        int balls;

        public Trip(int time, int balls)
        {
            this.time = time;
            this.balls = balls;
        }
    }
}
