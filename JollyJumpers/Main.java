package UVa.JollyJumpers;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by DELL on 17-Oct-15.
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream, true);

        Main demo = new Main();
        demo.solve(in, out);

        out.close();
    }

    public void solve(Scanner in, PrintWriter out)
    {
        while (in.hasNextInt())
        {
            int n = in.nextInt();
            boolean jolly = true;
            int numbers[] = new int[n];
            boolean difference[] = new boolean[n];
            for (int i = 0; i < numbers.length; i++)
            {
                numbers[i] = in.nextInt();
            }
            for (int i = 1; i < numbers.length; i++)
            {
                int delta = Math.abs(numbers[i] - numbers[i - 1]);
                if (delta < difference.length)
                {
                    difference[delta] = true;
                }
            }
            for (int i = 1; i < difference.length; i++)
            {
                if (!difference[i])
                {
                    jolly = false;
                    break;
                }
            }
            if (!jolly)
            {
                out.println("Not jolly");
            }
            else
            {
                out.println("Jolly");
            }
        }
    }
}


