package UVa.CD;

import java.util.Scanner;

/**
 * Created by DELL on 15-Jan-16.
 */
public class Main
{
    int length[];
    boolean trace[][];

    public static void main(String ra[])
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        demo.solve(in);
    }

    public void solve(Scanner in)
    {
        while (in.hasNext())
        {
            int diff = in.nextInt();
            int n = in.nextInt();
            length = new int[n];
            for (int i = 0; i < length.length; i++)
            {
                length[i] = in.nextInt();
            }
            trace = new boolean[n][diff + 1];
            int ans = solve(0, diff);
            String traceAns = "";

            for (int i = 0, j = diff; i < length.length; i++)
            {
                if (trace[i][j])
                {
                    traceAns += length[i] + " ";
                    j -= length[i];
                }
            }
            System.out.println(traceAns + "sum:" + (diff - ans));
        }
    }

    public int solve(int index, int diff)
    {
        if (index == length.length)
        {
            return diff;
        }
        if (length[index] > diff)
        {
            return solve(index + 1, diff);
        }
        int diff1 = solve(index + 1, diff - length[index]);
        int diff2 = solve(index + 1, diff);
        int min = Math.min(diff1, diff2);
        trace[index][diff] = (min == diff1);
        return min;
    }
}
