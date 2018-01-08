package UVa.Jugs.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 16/06/2017.
 */
public class Main
{
    private int A;
    private int B;
    private int N;
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
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            State start = new State(0, 0, "");

            TreeSet<State> was = new TreeSet<State>();
            LinkedList<State> q = new LinkedList<>();
            q.add(start);
            was.add(start);
            for (; !q.isEmpty(); )
            {
                State now = q.poll();
                //System.out.println(now);
                if (now.jugB == N)
                {
                    System.out.print(now.trace + "success\n");
                    break;
                }

                State next = null;
                //Fill jugA//
                if (now.jugA < A)
                {
                    next = new State(A, now.jugB, now.trace + "fill A\n");
                    if (!was.contains(next))
                    {
                        was.add(next);
                        q.add(next);
                    }
                }

                //Fill jugB//
                if (now.jugB < B)
                {
                    next = new State(now.jugA, B, now.trace + "fill B\n");
                    if (!was.contains(next))
                    {
                        was.add(next);
                        q.add(next);
                    }
                }

                //Empty A//
                if (now.jugA > 0)
                {
                    next = new State(0, now.jugB, now.trace + "empty A\n");
                    if (!was.contains(next))
                    {
                        was.add(next);
                        q.add(next);
                    }
                }

                //Empty B//
                if (now.jugB > 0)
                {
                    next = new State(now.jugA, 0, now.trace + "empty B\n");
                    if (!was.contains(next))
                    {
                        was.add(next);
                        q.add(next);
                    }
                }

                //Pour A to B//
                if (now.jugA > 0 && now.jugB < B)
                {
                    int diff = Math.min(now.jugA, B - now.jugB);
                    next = new State(now.jugA - diff, now.jugB + diff, now.trace + "pour A B\n");
                    if (!was.contains(next))
                    {
                        was.add(next);
                        q.add(next);
                    }
                }

                //Pour B to A//
                if (now.jugB > 0 && now.jugA < A)
                {
                    int diff = Math.min(now.jugB, A - now.jugA);
                    next = new State(now.jugA + diff, now.jugB - diff, now.trace + "pour B A\n");
                    if (!was.contains(next))
                    {
                        was.add(next);
                        q.add(next);
                    }
                }
            }
        }
    }

    class State implements Comparable<State>
    {
        int jugA;
        int jugB;
        //int level;
        String trace;

        public State(int jugA, int jugB, String trace)
        {
            this.jugA = jugA;
            this.jugB = jugB;
            //this.level = level;
            this.trace = trace;
        }

        public int compareTo(State that)
        {
//            int levelDiff = Integer.compare(this.level, that.level);
//            if (levelDiff == 0)
//            {
//                Integer aDiff = Integer.compare(this.jugA, that.jugA);
//                return aDiff != 0 ? aDiff : Integer.compare(this.jugB, that.jugB);
//            }
//            return levelDiff;
            Integer aDiff = Integer.compare(this.jugA, that.jugA);
            return aDiff != 0 ? aDiff : Integer.compare(this.jugB, that.jugB);
        }

        public String toString()
        {
            //return "Jug A = " + jugA + ", Jug B = " + jugB + ", Level = " + level + ", trace = " + trace + "\n";
            return "Jug A = " + jugA + ", Jug B = " + jugB + ", trace = " + trace + "\n";
        }

    }

}
