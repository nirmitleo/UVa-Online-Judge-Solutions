package UVa.FewestFlops.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FewestFlops
{
    private final static int INVALID = ((int) 1e7);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int K = in.nextInt();
            String s = in.next();
//            System.out.println(s);
            int n = s.length() / K;

            TreeMap<Character, Integer>[] blocks = new TreeMap[n];
            for (int i = 0; i < n; i++)
            {
                blocks[i] = getMap(s.substring(0, K));
                s = s.substring(K);
            }

            int[][] dp = new int[n][26];
            for (int i = 0; i < n; i++)
            {
                Arrays.fill(dp[i], INVALID);
            }
            for (Map.Entry<Character, Integer> entry : blocks[0].entrySet())
            {
                int key = entry.getKey() - 'a';
                dp[0][key] = blocks[0].size();
            }
            for (int i = 0; i < n - 1; i++)
            {
                TreeMap<Character, Integer> next = blocks[i + 1];
                for (int j = 0; j < 26; j++)
                {
                    if (dp[i][j] != INVALID)
                    {
                        char key = ((char) (j + 'a'));
                        int count = dp[i][j] + next.size();
                        count = next.containsKey(key) ? count - 1 : count;
                        for (Map.Entry<Character, Integer> entry : next.entrySet())
                        {
                            char last = entry.getKey();
                            dp[i + 1][last - 'a'] = Math.min(dp[i + 1][last - 'a'], count);
                        }
                    }
                }
            }
            int best = INVALID;
            for (int i = 0; i < 26; i++)
            {
                best = Math.min(best, dp[n - 1][i]);
            }
            out.println(best);
        }
    }


    private TreeMap<Character, Integer> getMap(String s)
    {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            Integer count = map.get(ch);
            count = (count == null) ? 1 : count + 1;
            map.put(ch, count);
        }
        return map;
    }

}
