package UVa.MemoryOverflow;

import java.util.Scanner;

/**
 * Created by DELL on 15-Dec-15.
 */
public class Main
{
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        int test = in.nextInt();
        int counter = 0;
        while (test-- > 0)
        {
            int n = in.nextInt();
            int k = in.nextInt();
            String persons = in.next();
            System.out.println("Case " + (++counter) + ": " + demo.solve(persons, k));
        }
    }

    public int solve(String persons, int k)
    {
        int rem = 0;
        int alpha[] = new int[27];
        for (int i = 0; i < persons.length(); i++)
        {
            int person = persons.charAt(i);
            if (alpha[person - 64] != 0 && alpha[person - 64] - 1 >= i - k)
            {
                rem++;
            }
            alpha[person - 64] = i + 1;
        }
        return rem;
    }
}
