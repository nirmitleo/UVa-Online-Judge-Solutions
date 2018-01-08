package UVa.MoliuNumberGenerator.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 22/06/2017.
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
        //demo.test1();
    }

    public void test()
    {
        for (int i = 10; i <= 200; i++)
        {
            State ans = bfs(i);
            System.out.println(i + " steps = " + ans.level + " path = " + ans.path);
        }
    }

    public State bfs(int target)
    {
        TreeSet<Long> was = new TreeSet<Long>();
        LinkedList<State> q = new LinkedList<State>();

        q.add(new State(0, 0, ""));
        was.add(0L);
        while (!q.isEmpty())
        {
            State u = q.pollFirst();
            if (u.value == target)
            {
                return u;
            }
            long v1 = u.value + 1;
            if (!was.contains(v1))
            {
                was.add(v1);
                q.add(new State(v1, u.level + 1, u.path + " +1(" + v1 + ")"));
            }
            long v2 = u.value * 2;
            if (!was.contains(v2))
            {
                was.add(v2);
                q.add(new State(v2, u.level + 1, u.path + " x2(" + v2 + ")"));
            }

            if (u.value > 0)
            {
                long v3 = u.value - 1;
                if (!was.contains(v3))
                {
                    was.add(v3);
                    q.add(new State(v3, u.level + 1, u.path + " -1(" + v3 + ")"));
                }
            }
        }
        return null;
    }

    class State implements Comparable<State>
    {
        long value;
        int level;
        String path;

        public State(long value, int level, String path)
        {
            this.value = value;
            this.level = level;
            this.path = path;
        }

        public int compareTo(State that)
        {
            int levelDiff = Integer.compare(this.level, that.level);
            return levelDiff == 0 ? Long.compare(this.value, that.value) : levelDiff;
        }
    }


    public void solve() throws IOException
    {
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            long n = Long.parseLong(st.nextToken());
            if (n == 0)
            {
                System.out.println(0);
                continue;
            }
            int c = 1;
            for (; n > 1; c++)
            {
                if (n == 3)
                {
                    n = n - 1;
                } else if (n % 2 == 0)
                {
                    n /= 2;
                } else
                {
                    long high = Long.lowestOneBit(n + 1);
                    long low = Long.lowestOneBit(n - 1);
                    if (high > low)
                    {
                        n = n + 1;
                    } else
                    {
                        n = n - 1;
                    }
                }
            }
            System.out.println(c);
        }
    }
}
