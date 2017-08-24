package UVa.GasStations.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 18/06/2017.
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
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            if (L == 0 && G == 0)
            {
                return;
            }

            Pair[] g = new Pair[G];
            for (int i = 0; i < G; i++)
            {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                g[i] = new Pair(x - r, x + r);
            }

            Arrays.sort(g, new Comparator<Pair>()
            {
                @Override
                public int compare(Pair o1, Pair o2)
                {
                    int leftDiff = Integer.compare(o1.left, o2.left);
                    if (leftDiff == 0)
                    {
                        return Integer.compare(o2.right, o1.right);
                    }
                    return leftDiff;
                }
            });

            int count = 0;
            int left = 0;
            int best = -1;
            for (int i = 0; i < G; )
            {
                Pair p = g[i];
                if (p.left <= left)
                {
                    best = Math.max(best, p.right);
                    i++;
                } else
                {
                    if (best <= left)
                    {
                        break;
                    } else
                    {
                        count++;
                        left = best;
                        best = -1;
                        if (left >= L)
                        {
                            break;
                        }
                    }
                }
            }
            if (best > left)
            {
                count++;
                left = best;
            }
            if (left < L)
            {
                count = -1;
            }
            if (count == -1)
            {
                System.out.println(count);
            } else
            {
                System.out.println(G - count);
            }
        }

    }

    class Pair
    {
        int left;
        int right;

        public Pair(int left, int right)
        {
            this.left = left;
            this.right = right;
        }
    }
}
