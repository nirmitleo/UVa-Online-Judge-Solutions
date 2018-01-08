package UVa.PlayingWithWheels.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class PlayingWithWheels
{
    private int N = 4;
    private HashSet<State> set;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            int[] now = new int[N];
            for (int i = 0; i < N; i++)
            {
                now[i] = in.nextInt();
            }
            State source = new State(now, 0);

            now = new int[N];
            for (int i = 0; i < N; i++)
            {
                now[i] = in.nextInt();
            }
            State sink = new State(now);

            int M = in.nextInt();
            set = new HashSet<>();
            for (int i = 0; i < M; i++)
            {
                now = new int[N];
                for (int j = 0; j < N; j++)
                {
                    now[j] = in.nextInt();
                }
                set.add(new State(now));
            }

            int dist = bfs(source, sink);
            out.println(dist);
        }
    }

    public int bfs(State source, State sink)
    {
        LinkedList<State> q = new LinkedList<>();
        q.add(source);

        HashSet<State> was = new HashSet<>();
        was.add(source);

        while (!q.isEmpty())
        {
            State U = q.pollFirst();
            if (U.equals(sink))
            {
                return U.dist;
            }
            int[] now = U.now;
            for (int i = 0; i < N; i++)
            {
                int[] a = now.clone();
                a[i] = (a[i] + 9) % 10;

                State V = new State(a);
                if (!set.contains(V))
                {
                    if (!was.contains(V))
                    {
                        was.add(V);
                        V.dist = U.dist + 1;
                        q.add(V);
                        if (V.equals(sink))
                        {
                            return V.dist;
                        }
                    }
                }

                a = now.clone();
                a[i] = (a[i] + 1) % 10;
                V = new State(a);
                if (!set.contains(V))
                {
                    if (!was.contains(V))
                    {
                        was.add(V);
                        V.dist = U.dist + 1;
                        q.add(V);
                        if (V.equals(sink))
                        {
                            return V.dist;
                        }
                    }
                }
            }
        }
        return -1;
    }

    class State
    {
        int[] now;
        int dist;

        public State(int[] now, int dist)
        {
            this.now = now;
            this.dist = dist;
        }

        public State(int[] now)
        {
            this.now = now;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            State state = (State) o;

            return Arrays.equals(now, state.now);
        }

        @Override
        public int hashCode()
        {
            return Arrays.hashCode(now);
        }
    }
}
