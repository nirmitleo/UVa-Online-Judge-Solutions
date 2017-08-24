package UVa.GameShowMath.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 08/06/2017.
 */
public class Main
{
    private final static int LIMIT = 32000;
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        outer:
        for (int t = 1; t <= test; t++)
        {
            TreeSet<State> set = new TreeSet<State>();

            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int result = Integer.parseInt(st.nextToken());

            State start = new State(a[0], 1, a[0] +"");
            set.add(start);
            for (int i = 1; i < n; i++)
            {
                TreeSet<State> temp = new TreeSet<State>();
                while (!set.isEmpty())
                {
                    State now = set.pollFirst();
                    int nextValue = now.value + a[i];
                    if (Math.abs(nextValue) <= LIMIT)
                    {
                        temp.add(new State(nextValue, now.level + 1, now.op + "+" + a[i]));
                    }

                    nextValue = now.value - a[i];
                    if (Math.abs(nextValue) <= LIMIT)
                    {
                        temp.add(new State(nextValue, now.level + 1, now.op + "-" + a[i]));
                    }

                    nextValue = now.value * a[i];
                    if (Math.abs(nextValue) <= LIMIT)
                    {
                        temp.add(new State(nextValue, now.level + 1, now.op + "*" + a[i]));
                    }

                    if (now.value % a[i] == 0)
                    {
                        temp.add(new State(now.value / a[i], now.level + 1, now.op + "/" + a[i]));
                    }
                }
                set = temp;
            }
            while (!set.isEmpty())
            {
                State now = set.pollFirst();
                if (now.value == result)
                {
                    System.out.println(now.op + "=" + result);
                    continue outer;
                }
            }
            System.out.println("NO EXPRESSION");
        }
    }

    class State implements Comparable<State>
    {
        int level;
        int value;
        String op;

        public State(int value, int level, String op)
        {
            this.value = value;
            this.level = level;
            this.op = op;
        }

        public int compareTo(State that)
        {
            int levelDiff = Integer.compare(this.level, that.level);
            return levelDiff != 0 ? levelDiff : Integer.compare(this.value, that.value);
        }

    }
}
