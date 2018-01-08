package UVa.FormingQuizTeams.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;

public class FormingQuizTeams
{
    private int T;
    private int N;
    private double[][] dp;
    private Player[] players;
    private final static double INVALID = 1e8;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (int t = 1; ; t++)
        {
            T = in.nextInt();
            if (T == 0)
            {
                return;
            }
            N = (T << 1);

            players = new Player[N];
            for (int i = 0; i < N; i++)
            {
                players[i] = readPoint(in);
            }
            dp = new double[N][1 << N];
            for (int i = 0; i < N; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }
            double res = go(0, 0);
            out.printf("Case " + t + ": %.2f\n", res);
        }
    }

    private double go(int pos, int mask)
    {
        if (Integer.bitCount(mask) == N)
        {
            return 0;
        }
        if (dp[pos][mask] != INVALID)
        {
            return dp[pos][mask];
        }
        if (isBitSet(mask, pos))
        {
            return go(pos + 1, mask);
        }

        double res = INVALID;
        for (int i = pos + 1; i < N; i++)
        {
            if (!isBitSet(mask, i))
            {
                int next = mask;
                next |= (1 << i);
                next |= (1 << pos);
                double d = getDist(players[i], players[pos]);
                double aux = go(pos + 1, next) + d;
                res = Math.min(res, aux);
            }
        }
        return dp[pos][mask] = res;
    }

    private boolean isBitSet(int mask, int pos)
    {
        return (mask & (1 << pos)) > 0;
    }


    private Player readPoint(FastScanner in)
    {
        in.next();
        int x = in.nextInt();
        int y = in.nextInt();
        return new Player(x, y);
    }

    private double getDist(Player p1, Player p2)
    {
        return Math.sqrt(sq(p1.x - p2.x) + sq(p1.y - p2.y));
    }

    private int sq(int x)
    {
        return x * x;
    }

    class Player
    {
        int x;
        int y;

        public Player(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    class Team
    {
        int p1;
        int p2;

        public Team(int p1, int p2)
        {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}
