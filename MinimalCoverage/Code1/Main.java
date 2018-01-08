package UVa.MinimalCoverage.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 17/06/2017.
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
            int M = Integer.parseInt(in.readLine().trim());
            ArrayList<Pair> lines = new ArrayList<Pair>();
            for (; ; )
            {
                st = new StringTokenizer(in.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                if (left == 0 && right == 0)
                {
                    break;
                }
                if (Math.max(left, right) > 0)
                {
                    lines.add(new Pair(left, right));
                }
            }

            Collections.sort(lines, new Comparator<Pair>()
            {
                public int compare(Pair a, Pair b)
                {
                    int leftDiff = Integer.compare(a.left, b.left);
                    if (leftDiff == 0)
                    {
                        return Integer.compare(b.right, a.right);
                    }
                    return leftDiff;
                }
            });

            ArrayList<Pair> result = new ArrayList<Pair>();
            int best = 0;
            int maxRight = -1;
            Pair q = null;
            for (int i = 0; i < lines.size(); )
            {
                Pair p = lines.get(i);
                if (p.left <= best)
                {
                    if (maxRight < p.right)
                    {
                        maxRight = p.right;
                        q = p;
                    }
                    i++;
                } else
                {
                    if (maxRight < 0)
                    {
                        break;
                    } else
                    {
                        best = maxRight;
                        maxRight = -1;
                        result.add(q);
                        q = null;
                        if (best >= M)
                        {
                            break;
                        }
                    }
                }
            }
            if (maxRight > best)
            {
                best = maxRight;
                result.add(q);
            }

            String output = "";
            if (best < M)
            {
                output += 0 + "\n";
            } else
            {
                output += result.size() + "\n";
                for (int i = 0; i < result.size(); i++)
                {
                    Pair p = result.get(i);
                    output += p.left + " " + p.right + "\n";
                }
            }
            output = output.trim();

            if (t == 1)
            {
                System.out.println(output);
            } else
            {
                System.out.println("\n" + output);
            }

        }


    }

    class Pair
    {
        int left;
        int right;

        public Pair(int left, int right)
        {
            this.left = left;
            this.right = right;
        }

        public String toString()
        {
            return "Left = " + left + " Right = " + right;
        }
    }
}
