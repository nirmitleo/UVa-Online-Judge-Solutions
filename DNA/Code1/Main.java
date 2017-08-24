package UVa.DNA.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 15/06/2017.
 */
public class Main
{
    private int N;
    private String first;
    private TreeSet<String> set;
    private char[] dna = new char[]{'A', 'T', 'G', 'C'};
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
            st = new StringTokenizer(in.readLine());
            set = new TreeSet<>();
            N = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            first = in.readLine().trim();

            set.add(first);
            for (int i = 1; i <= left; i++)
            {
                go(0, i, "");
            }

            System.out.println(set.size());
            while (!set.isEmpty())
            {
                System.out.println(set.pollFirst());
            }
        }

    }

    public void go(int i, int left, String p)
    {
        if (i == N)
        {
            if (left == 0)
            {
                set.add(p);
            }
        } else
        {
            char ch = first.charAt(i);
            for (int j = 0; j < dna.length; j++)
            {
                if (ch == dna[j])
                {
                    go(i + 1, left, p + ch);
                } else
                {
                    go(i + 1, left - 1, p + dna[j]);
                }
            }
        }
    }
}
