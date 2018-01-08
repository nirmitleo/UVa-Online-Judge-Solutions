package UVa.Multitasking.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/06/2017.
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
        int N = (int) 1e6;
        outer:
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (s + r == 0)
            {
                return;
            }
            ArrayList<Pair> intervals = new ArrayList<Pair>();
            for (int i = 0; i < s; i++)
            {
                st = new StringTokenizer(in.readLine());
                int begin = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals.add(new Pair(begin, end));
            }
            for (int i = 0; i < r; i++)
            {
                st = new StringTokenizer(in.readLine());
                int begin = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int repeat = Integer.parseInt(st.nextToken());

                while (begin <= N)
                {
                    intervals.add(new Pair(begin, end));
                    begin += repeat;
                    end += Math.min(N, repeat);
                }
            }
            Collections.sort(intervals);
            for (int i = 0; i < intervals.size(); i++)
            {
                Pair p1 = intervals.get(i);
                for (int j = i + 1; j < intervals.size(); j++)
                {
                    Pair p2 = intervals.get(j);
                    if (p1.end < p2.start)
                    {
                        break;
                    }
                    if (p1.start >= p2.start && p1.start < p2.end)
                    {
                        System.out.println("CONFLICT");
                        continue outer;
                    }
                    if (p1.end > p2.start && p1.end <= p2.end)
                    {
                        System.out.println("CONFLICT");
                        continue outer;
                    }
                }
            }
            System.out.println("NO CONFLICT");
        }

    }

    class Pair implements Comparable<Pair>
    {
        int start;
        int end;

        public Pair(int start, int end)
        {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair that)
        {
            int endDiff = Integer.compare(this.end, that.end);
            return endDiff != 0 ? endDiff : Integer.compare(this.start, that.start);
        }

        public String toString()
        {
            return "start time = " + start + ", end time = " + end;
        }
    }
}
