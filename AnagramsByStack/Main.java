package UVa.AnagramsByStack;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
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
        while (in.hasNext())
        {
            String input = in.next();
            String target = in.next();
            if (input.length() != target.length())
            {
                out.println("[");
                out.println("]");
                continue;
            }
            String anagram = "";
            int startIndex = 0;
            String stack = "";
            PriorityQueue<String> combination = new PriorityQueue<String>();

            char start = target.charAt(0);
            for (int i = 0; i < input.length(); i++)
            {
                if (start != input.charAt(i))
                {
                    stack += input.charAt(i) + "";
                    anagram += "i ";
                    startIndex++;
                }
                else
                {
                    break;
                }
            }
            anagram(anagram, input, startIndex, "", target, stack, combination);
            out.println("[");
            while (!combination.isEmpty())
            {
                out.println(combination.poll());
            }
            out.println("]");
        }
    }

    public void anagram(String anagram, String input, int i, String output, String target, String stack, PriorityQueue<String> combination)
    {
        if (target.equals(output))
        {
            combination.add(anagram.trim());
            return;
        }
        if (i < input.length())
        {
            anagram(anagram + "i ", input, i + 1, output, target, stack + input.charAt(i) + "", combination);
        }
        if (!stack.isEmpty())
        {
            output += stack.charAt(stack.length() - 1);
            if (target.indexOf(output) == 0)
            {
                anagram(anagram + "o ", input, i, output, target, stack.substring(0, stack.length() - 1), combination);
            }
            else
            {
                return;
            }
        }
    }
}
