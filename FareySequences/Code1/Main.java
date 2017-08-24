package UVa.FareySequences.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 06/07/2017.
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
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            TreeSet<Pair> set = new TreeSet<Pair>();
            for (int N = 1; N <= n - 1; N++)
            {
                for (int D = N; D <= n; D++)
                {
                    set.add(new Pair(N, D));
                }
            }
            for (int c = 1; !set.isEmpty(); c++)
            {
                Pair p = set.pollFirst();
                if (c == k)
                {
                    System.out.println(p.N + "/" + p.D);
                    break;
                }
            }
        }
    }

    public void test() throws IOException
    {
        TreeSet<Pair> set = new TreeSet<Pair>();
        for (int N = 1; N <= 4; N++)
        {
            for (int D = N; D <= 5; D++)
            {
                set.add(new Pair(N, D));
            }
        }

        while (!set.isEmpty())
        {
            Pair p = set.pollFirst();
            System.out.println(p);
        }
    }

    class Pair implements Comparable<Pair>
    {
        int N;
        int D;
        double value;

        public Pair(int N, int D)
        {
            this.N = N;
            this.D = D;
            this.value = N / (D * 1.0);
        }

        public int compareTo(Pair that)
        {
            int valueDiff = Double.compare(this.value, that.value);
            return valueDiff;
        }

        public String toString()
        {
            return N + "/" + D;
        }
    }
}
