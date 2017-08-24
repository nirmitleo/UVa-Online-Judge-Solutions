package UVa.eCoins.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/06/2017.
 */
public class Main
{
    private int[] sq = new int[400 + 1];
    private final static int INVALID = (int) 1e9;
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
        for (int i = 0; i < sq.length; i++)
        {
            sq[i] = i * i;
        }
        while (true)
        {
            line = in.readLine();
            if (line.trim().length() != 0)
            {
                break;
            }
        }
        st = new StringTokenizer(line);
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            while (true)
            {
                line = in.readLine();
                if (line.trim().length() != 0)
                {
                    break;
                }
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            S *= S;
            ArrayList<Integer> temp = new ArrayList<>();
            int[] c2 = new int[n];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken());
                temp.add(c);
                c2[i] = Integer.parseInt(st.nextToken());
                c = Arrays.binarySearch(sq, S - (c2[i] * c2[i]));
                if (c >= 0 && c < sq.length)
                {
                    temp.add(c);
                }
            }

            int[] c1 = new int[temp.size()];
            for (int i = 0; i < c1.length; i++)
            {
                c1[i] = temp.get(i);
            }
            //System.out.println(Arrays.toString(c1));

            int[] dp1 = new int[S + 1];
            int[] dp2 = new int[S + 1];

            Arrays.fill(dp1, INVALID);
            Arrays.fill(dp2, INVALID);

            dp1[0] = 0;
            dp2[0] = 0;
            for (int i = 0; i < c1.length; i++)
            {
                for (int j = 0; j <= S; j++)
                {
                    if (dp1[j] != INVALID)
                    {
                        if (j + c1[i] <= S)
                        {
                            dp1[j + c1[i]] = Math.min(dp1[j + c1[i]], dp1[j] + 1);
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j <= S; j++)
                {
                    if (dp2[j] != INVALID)
                    {
                        if (j + c2[i] <= S)
                        {
                            dp2[j + c2[i]] = Math.min(dp2[j + c2[i]], dp2[j] + 1);
                        }
                    }
                }
            }
            //srcdp2[0] = 1;
            int best = INVALID;
            for (int i = 1; i <= S; i++)
            {
                if (dp1[i] != INVALID)
                {
                    int j = Arrays.binarySearch(sq, S - (i * i));
                    if (j >= 0 && j <= S && dp2[j] != INVALID)
                    {
                        System.out.println(i + " " + j);
                        System.out.println(dp1[i] + " " + dp2[j]);
                        best = Math.min(best, dp1[i] + dp2[j]);
                    }
                }
            }
            if (best == INVALID)
            {
                System.out.println("not possible");
            } else
            {
                System.out.println(best);
            }

        }

    }

}
