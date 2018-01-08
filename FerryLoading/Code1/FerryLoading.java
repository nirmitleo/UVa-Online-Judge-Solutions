package UVa.FerryLoading.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Arrays;

public class FerryLoading
{
    private final static int INVALID = -((int) 1e7);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int L = in.nextInt() * 100;
            Integer[] len = readFerries(in);

            int n = len.length - 1;
            int[][] dp = new int[n + 1][L + 1];
            for (int i = 0; i < n + 1; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }

            int x = -1;
            int y = -1;
            dp[0][0] = 0;
            for (int i = 0; i <= n - 1; i++)
            {
                for (int j = 0; j <= L; j++)
                {
                    if (dp[i][j] != INVALID)
                    {
                        int left = j;
                        int right = dp[i][j] - left;
                        if (right + len[i + 1] <= L)
                        {
                            if (dp[i + 1][j] < dp[i][j] + len[i + 1])
                            {
                                dp[i + 1][j] = dp[i][j] + len[i + 1];
                                x = i + 1;
                            }
                        }
                        if (left + len[i + 1] <= L)
                        {
                            if (dp[i + 1][j + len[i + 1]] < dp[i][j] + len[i + 1])
                            {
                                dp[i + 1][j + len[i + 1]] = dp[i][j] + len[i + 1];
                                x = i + 1;
                            }
                        }
                    }
                }
            }
            if (t > 1)
            {
                out.println();
            }
            if (x < 0)
            {
                out.println(0);
            } else
            {
                for (int j = L; j >= 0; j--)
                {
                    if (dp[x][j] != INVALID)
                    {
                        y = j;
                        break;
                    }
                }
                int cnt = x;
                StringBuilder sb = new StringBuilder("");
                while (x > 0)
                {
                    if (dp[x - 1][y] + len[x] == dp[x][y])
                    {
                        sb.insert(0, "port\n");
                        x = x - 1;
                    } else
                    {
                        sb.insert(0, "starboard\n");
                        y = y - len[x];
                        x = x - 1;
                    }
                }
                out.println(cnt);
                out.print(sb);
            }
        }
    }

    private Integer[] readFerries(FastScanner in)
    {
        ArrayList<Integer> list = new ArrayList<>();
        while (true)
        {
            int num = in.nextInt();
            if (num == 0)
            {
                Integer[] a = new Integer[list.size()];
                list.toArray(a);
                Integer[] b = new Integer[list.size() + 1];
                System.arraycopy(a, 0, b, 1, list.size());
                return b;
            }
//            num = num / 100;
            list.add(num);
        }
    }
}
