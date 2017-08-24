package UVa.HammingDistanceProblem;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by DELL on 16-Jan-16.
 */
public class Main
{
    TreeSet<String> ans;
    int n;
    int h;

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while (test-- > 0)
        {
            Main demo = new Main();
            demo.solve(in);
            if (test != 0)
            {
                System.out.println();
            }
        }
    }

    public void solve(Scanner in)
    {
        n = in.nextInt();
        h = in.nextInt();
        ans = new TreeSet<String>();
        solve("0");
        solve("1");
        while (!ans.isEmpty())
        {
            System.out.println(ans.pollFirst());
        }
    }

    public void solve(String bitString)
    {
        if (bitString.length() == n)
        {
            if (countOnes(bitString) == h)
            {
                ans.add(bitString);
            }
            return;
        }
        if (countOnes(bitString) > h)
        {
            return;
        }
        solve(bitString + "0");
        solve(bitString + "1");
    }

    public int countOnes(String s)
    {
        int n = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '1')
            {
                n++;
            }
        }
        return n;
    }
}
