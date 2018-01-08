package UVa.IsBiggerSmarter.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class IsBiggerSmarter
{
    private final static int N = ((int) 1e3) + 10;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        ArrayList<Elephant> list = new ArrayList<>();
        for (int i = 0; ; i++)
        {
            Elephant e = readElephant(in);
            if (e == null)
            {
                break;
            }
            e.at = i + 1;
            list.add(e);
        }
        Collections.sort(list);

        int qh = 0;
        TreeSet[] q = createQueue(N);
        for (Elephant e : list)
        {
            int low = -1;
            int high = qh;
            while (high - low > 1)
            {
                int mid = low + (high - low) / 2;
                Elephant m = (Elephant) q[mid].last();
                if (check(m, e))
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
            if (low >= 0)
            {
                Elephant U = (Elephant) q[low].last();
                e.prev = U;
            }
            q[low + 1].add(e);
            qh = Math.max(qh, low + 2);
        }
        out.println(qh);
        StringBuilder sb = new StringBuilder("");
        Elephant now = (Elephant) q[qh - 1].last();
        while (now != null)
        {
            sb.insert(0, now.at + "\n");
            now = now.prev;
        }
        out.print(sb);
    }

    private boolean check(Elephant e1, Elephant e2)
    {
        return e1.w < e2.w && e1.iq > e2.iq;
    }

    private TreeSet[] createQueue(int N)
    {
        TreeSet[] q = new TreeSet[N];
        for (int i = 0; i < N; i++)
        {
            q[i] = new TreeSet<Elephant>();
        }
        return q;
    }

    private Elephant readElephant(FastScanner in)
    {
        String line = in.next();
        if (line == null)
        {
            return null;
        }
        int w = Integer.parseInt(line);
        int iq = in.nextInt();
        return new Elephant(w, iq);
    }


    private class Elephant implements Comparable<Elephant>
    {
        int w;
        int at;
        int iq;
        Elephant prev;

        public Elephant(int w, int iq)
        {
            this.w = w;
            this.iq = iq;
        }

        public Elephant(int w, int iq, int at)
        {
            this.w = w;
            this.at = at;
            this.iq = iq;
        }

        public int compareTo(Elephant that)
        {
            int wDiff = Integer.compare(this.w, that.w);
            return wDiff != 0 ? wDiff : Integer.compare(this.iq, that.iq);
        }

        public String toString()
        {
            return "W = " + w + " iq = " + iq;
        }
    }
}
