package UVa.MinimalCoverage.Code2;


import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Collections;

public class MinimalCoverage
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int M = in.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();
            while (true)
            {
                int left = in.nextInt();
                int right = in.nextInt();
                if (left == 0 && right == 0)
                {
                    break;
                }
                Pair p = new Pair(Math.min(left, right), Math.max(left, right));
                if (p.right < 0)
                {
                    continue;
                }
                pairs.add(p);
            }

            Collections.sort(pairs);

            int now = 0;
            int next = -1;
            int count = 0;
            String sb = "";
            Pair best = null;
            for (int i = 0; i < pairs.size(); )
            {
                Pair p = pairs.get(i);
                if (p.left <= now)
                {
                    if (p.right > next)
                    {
                        next = p.right;
                        best = p;
                    }
                    i++;
                } else
                {
                    if (best == null)
                    {
                        break;
                    }
                    count++;
                    now = next;
                    sb += best.left + " " + best.right + "\n";
                    best = null;
                }
                if (now >= M)
                {
                    break;
                }
            }
            if (best != null)
            {
                count++;
                now = best.right;
                sb += best.left + " " + best.right + "\n";
            }
            String ans = "";
            if (now >= M)
            {
                ans += count + "\n";
                ans += sb.trim();

            } else
            {
                ans += 0 + "\n";
            }
            if (t == 1)
            {
                out.print(ans);
            } else
            {
                out.println("\n" + ans.trim());
            }

        }
    }

    class Pair implements Comparable<Pair>
    {
        int left;
        int right;

        public Pair(int left, int right)
        {
            this.left = left;
            this.right = right;
        }

        public int compareTo(Pair that)
        {
            int leftDiff = Integer.compare(this.left, that.left);
            return leftDiff != 0 ? leftDiff : Integer.compare(that.right, this.right);
        }

        public String toString()
        {
            return "Left = " + left + " Right = " + right;
        }

    }
}
