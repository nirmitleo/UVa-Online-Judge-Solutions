package UVa.GameOfEuler.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class GameOfEuler
{
    private int N = 16;
    private int M = (1 << 16);
    private Boolean[][] dp;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            dp = new Boolean[N][M];
            int state = readBoard(in);
            boolean res = go(0, state);
            if (res)
            {
                out.println("WINNING");
            } else
            {
                out.println("LOSING");
            }
        }
    }

    private boolean go(int pos, int state)
    {
        if (Integer.bitCount(state) == 16)
        {
            return pos % 2 != 0;
        }
        if (dp[pos][state] != null)
        {
            return dp[pos][state];
        }
        boolean res = pos % 2 != 0;

        //put the pin horizontal//
        //Size = 1, 2, 3, 4//
        for (int S = 1; S <= 4; S++)
        {
            for (int i = 0; i < N; i++)
            {
                if (!isBitSet(state, i))
                {
                    int right = getRight(i);
                    if (right - i + 1 >= S && check(state, i, S, true))
                    {
                        int s = getState(state, i, S, true);
                        if (pos % 2 == 0)
                        {
                            res |= go(pos + 1, s);
                        } else
                        {
                            res &= go(pos + 1, s);
                        }
                    }

                    int bottom = getBottom(i);
                    if (bottom >= S && check(state, i, S, false))
                    {
                        int s = getState(state, i, S, false);
                        if (pos % 2 == 0)
                        {
                            res |= go(pos + 1, s);
                        } else
                        {
                            res &= go(pos + 1, s);
                        }
                    }
                }

            }
        }
        return dp[pos][state] = res;
    }

    private int getState(int state, int s, int howMany, boolean isRight)
    {
        for (int i = 0; i < howMany; i = ((isRight) ? i + 1 : i + 4))
        {
            int p = s + i;
            state |= (1 << p);
        }
        return state;
    }

    private boolean check(int state, int s, int howMany, boolean isRight)
    {
        for (int i = 0; i < howMany; i = ((isRight) ? i + 1 : i + 4))
        {
            int p = s + i;
            boolean res = !isBitSet(state, p);
            if (!res)
            {
                return false;
            }
        }
        return true;
    }

    private int getBottom(int i)
    {
        return 5 - getTop(i);
    }

    private int getRight(int i)
    {
        return getLeft(i) + 3;
    }

    private int getTop(int i)
    {
        return (i / 4) + 1;
    }

    private int getLeft(int i)
    {
        return (i / 4) * 4;
    }

    private boolean isBitSet(int state, int pos)
    {
        return (state & (1 << pos)) > 0;
    }


    private int readBoard(FastScanner in)
    {
        int state = 0;
        for (int i = 0; i < 4; i++)
        {
            String s = in.next();
            for (int j = 0; j < 4; j++)
            {
                int pos = i * 4 + j;
                if (s.charAt(j) == 'X')
                {
                    state |= (1 << pos);
                }
            }
        }
        return state;
    }
}
