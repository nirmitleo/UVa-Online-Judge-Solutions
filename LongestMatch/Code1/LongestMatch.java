package UVa.LongestMatch.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LongestMatch
{
    private int id;
    private TreeMap<String, Integer> map;
    private TreeMap<Integer, String> reverseMap;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (int t = 1; ; t++)
        {
            id = 0;
            map = new TreeMap<>();
            reverseMap = new TreeMap<>();
            int[] a = getIntArray(in);
            if (a == null)
            {
                return;
            }
            int[] b = getIntArray(in);
            int n = a.length - 1;
            int m = b.length - 1;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i < n + 1; i++)
            {
                for (int j = 0; j < m + 1; j++)
                {
                    if (i == 0 || j == 0)
                    {
                        continue;
                    }
                    if (i > 0 && j > 0)
                    {
                        if (a[i] == b[j])
                        {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        } else
                        {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }
                }
            }
            String s = "";
            if (dp[n][m] == 0)
            {
                s += "Blank!";
            } else
            {
                s += "Length of longest match: " + dp[n][m];
            }
            out.println(String.format("%2d. %s", t, s));
        }
    }

    private int getID(String name)
    {
        Integer i = map.get(name);
        if (i == null)
        {
            map.put(name, id);
            reverseMap.put(id, name);
            id++;
            return id - 1;
        }
        return i;
    }

    private int[] toIntArray(ArrayList<Integer> list, int offset)
    {
        int[] a = new int[list.size() + offset];
        a[0] = -1;
        for (int i = 0; i < list.size(); i++)
        {
            a[i + offset] = list.get(i);
        }
        return a;
    }

    private int[] getIntArray(FastScanner in)
    {
        try
        {
            String line = in.br.readLine();
            if (line == null)
            {
                return null;
            }
            line = cleanString(line);
            StringTokenizer st = new StringTokenizer(line);
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (st.hasMoreTokens())
            {
                String name = st.nextToken();
                list.add(getID(name));
            }
            return toIntArray(list, 1);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private String cleanString(String s)
    {
        String t = "";
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch))
            {
                t += ch;
            } else
            {
                t += ' ';
            }
        }
        return t;
    }
}
