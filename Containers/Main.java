package UVa.Containers;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by DELL on 18-Oct-15.
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
        int caseNumber = 0;
        String line = in.nextLine();
        while (!line.equals("end"))
        {
            String stacks = "";
            if (line.length() == 1)
            {
                out.println("Case " + (++caseNumber) + ": 1");
            }
            else
            {
                for (int i = 0; i < line.length(); i++)
                {
                    char current = line.charAt(i);
                    boolean isFound = false;
                    int position = -1;
                    for (int j = 0; stacks.indexOf(current) == -1 && j < stacks.length(); j++)
                    {
                        if (current < stacks.charAt(j))
                        {
                            isFound = true;
                            position = j;
                            break;
                        }
                    }
                    if (!isFound && stacks.indexOf(current) == -1)
                    {
                        stacks += current;
                    }
                    else if (isFound)
                    {
                        stacks = stacks.replaceFirst(stacks.charAt(position) + "", current + "");
                    }
                }
                out.println("Case " + (++caseNumber) + ": " + stacks.length());
            }
            line = in.nextLine();
        }
    }
}

