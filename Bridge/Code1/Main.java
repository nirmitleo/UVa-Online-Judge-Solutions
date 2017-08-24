package UVa.Bridge.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 18/06/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            in.readLine();
            int n = Integer.parseInt(in.readLine().trim());
            TreeSet<Pair> q1 = new TreeSet<>();
            TreeSet<Pair> q2 = new TreeSet<>();
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int time = Integer.parseInt(st.nextToken());
                q1.add(new Pair(i, time));
            }

            int best = 0;
            StringBuilder result = new StringBuilder("");
            while (!q1.isEmpty())
            {
                if (q1.size() == 1)
                {
                    int time = q1.pollFirst().time;
                    best += time;
                    result.append(time + "\n");
                } else if (q1.size() == 2)
                {
                    Pair A = q1.pollFirst();
                    Pair B = q1.pollFirst();
                    best += B.time;
                    result.append(A.time + " " + B.time + "\n");
                } else if (q1.size() == 3)
                {
                    Pair A = q1.pollFirst();
                    Pair B = q1.pollFirst();
                    Pair C = q1.pollFirst();
                    best += A.time + B.time;
                    result.append(A.time + " " + B.time + "\n");
                    result.append(A.time + "\n");
                    q1.add(A);
                    q1.add(C);
                    q2.add(B);
                } else
                {
                    Pair A = q1.pollFirst();
                    Pair B = q1.pollFirst();
                    Pair D = q1.pollLast();
                    Pair C = q1.pollLast();

                    if (A.time + C.time <= 2 * B.time)
                    {
                        result.append(A.time + " " + D.time + "\n");
                        best += D.time;
                        result.append(A.time + "\n");
                        best += A.time;
                        result.append(A.time + " " + C.time + "\n");
                        best += C.time;
                        result.append(A.time + "\n");
                        best += A.time;
                    } else
                    {
                        result.append(A.time + " " + B.time + "\n");
                        best += B.time;
                        result.append(A.time + "\n");
                        best += A.time;
                        result.append(C.time + " " + D.time + "\n");
                        best += D.time;
                        result.append(B.time + "\n");
                        best += B.time;
                    }

                    q1.add(A);
                    q1.add(B);
                    q2.add(C);
                    q2.add(D);
                }
            }
            if (t == 1)
            {
                System.out.print(best + "\n" + result);
            } else
            {
                System.out.print("\n" + best + "\n" + result);
            }

        }
    }

    class Pair implements Comparable<Pair>
    {
        int index;
        int time;

        public Pair(int index, int time)
        {
            this.index = index;
            this.time = time;
        }

        public int compareTo(Pair that)
        {
            int timeDiff = Integer.compare(this.time, that.time);
            return timeDiff != 0 ? timeDiff : Integer.compare(this.index, that.index);
        }

        public String toString()
        {
            return "Time = " + time;
        }
    }
}
