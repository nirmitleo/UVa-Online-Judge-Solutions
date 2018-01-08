package UVa.Rails;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

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
        while (true)
        {
            int n = Integer.parseInt(in.nextLine());
            while (true && n != 0)
            {
                Stack<Integer> st = new Stack<Integer>();
                String line = in.nextLine();
                String outgoing[] = line.split("\\s+");
                if (outgoing[0].equals("0"))
                {
                    break;
                }
                else
                {
                    int coach = 1;
                    boolean isPossible = true;
                    for (int i = 0; i < outgoing.length; i++)
                    {
                        int temp = Integer.parseInt(outgoing[i]);
                        while (coach < temp)
                        {
                            st.push(coach++);
                        }
                        if (coach == temp)
                        {
                            coach++;
                            continue;
                        }
                        else if (temp == (int) st.peek())
                        {
                            st.pop();
                            continue;
                        }
                        else
                        {
                            isPossible = false;
                            break;
                        }
                    }
                    if (isPossible)
                    {
                        out.println("Yes");
                    }
                    else
                    {
                        out.println("No");
                    }
                }
            }
            if (n == 0)
            {
                break;
            }
            else
            {
                out.println();
            }
        }
    }
}
