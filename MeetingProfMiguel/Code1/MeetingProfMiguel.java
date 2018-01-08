package UVa.MeetingProfMiguel.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;
import java.util.TreeSet;

public class MeetingProfMiguel
{
    private int N = 26;
    private final static int INF = ((int) 1e8);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            int n = in.nextInt();
            if (n == 0)
            {
                return;
            }

            int[][] Y = new int[N][N];
            int[][] M = new int[N][N];
            for (int i = 0; i < N; i++)
            {
                Arrays.fill(Y[i], INF);
                Arrays.fill(M[i], INF);
                Y[i][i] = 0;
                M[i][i] = 0;
            }

            while (n-- > 0)
            {
                char type = in.next().charAt(0);
                boolean b = in.next().charAt(0) == 'B';
                int from = getVertex(in);
                int to = getVertex(in);
                int w = in.nextInt();
                if (from == to)
                {
                    continue;
                }

                if (type == 'Y')
                {
                    Y[from][to] = w;
                    if (b)
                    {
                        Y[to][from] = w;
                    }
                } else
                {
                    M[from][to] = w;
                    if (b)
                    {
                        M[to][from] = w;
                    }
                }
            }

            for (int k = 0; k < N; k++)
            {
                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < N; j++)
                    {
                        Y[i][j] = Math.min(Y[i][j], Y[i][k] + Y[k][j]);
                        M[i][j] = Math.min(M[i][j], M[i][k] + M[k][j]);
                    }
                }
            }
            int y = getVertex(in);
            int o = getVertex(in);
            int best = INF;
            for (int i = 0; i < N; i++)
            {
                best = Math.min(best, Y[y][i] + M[o][i]);
            }
            if (best == INF)
            {
                out.println("You will never meet.");
            } else
            {
                TreeSet<Character> set = new TreeSet<>();
                for (int i = 0; i < N; i++)
                {
                    if (Y[y][i] + M[o][i] == best)
                    {
                        set.add(getName(i));
                    }
                }
                StringBuilder sb = new StringBuilder("");
                sb.append(best);
                while (!set.isEmpty())
                {
                    sb.append(" " + set.pollFirst());
                }
                out.println(sb);
            }
        }
    }

    private char getName(int id)
    {
        return ((char) (id + 'A'));
    }

    private int getVertex(FastScanner in)
    {
        return in.next().charAt(0) - 'A';
    }
}
