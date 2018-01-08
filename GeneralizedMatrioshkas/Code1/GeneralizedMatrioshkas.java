package UVa.GeneralizedMatrioshkas.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Stack;
import java.util.StringTokenizer;

public class GeneralizedMatrioshkas
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        outer:
        for (; ; )
        {
            String line = in.nextLine();
            if (line == null)
            {
                return;
            }

            Stack<Pair> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens())
            {
                int n = Integer.parseInt(st.nextToken());
                if (n < 0)
                {
                    if (stack.isEmpty())
                    {
                        stack.push(new Pair(n, Math.abs(n)));
                    } else
                    {
                        Pair top = stack.pop();
                        if (top.cap + n > 0)
                        {
                            top.cap += n;
                            stack.push(top);
                            stack.push(new Pair(n, Math.abs(n)));
                        } else
                        {
                            out.println(":-( Try again.");
                            continue outer;
                        }
                    }
                } else
                {
                    if (stack.isEmpty())
                    {
                        out.println(":-( Try again.");
                        continue outer;
                    } else
                    {
                        Pair top = stack.pop();
                        if (top.m * -1 != n)
                        {
                            out.println(":-( Try again.");
                            continue outer;
                        }
                    }
                }
            }
            if (stack.isEmpty())
            {
                out.println(":-) Matrioshka!");
            } else
            {
                out.println(":-( Try again.");
            }
        }
    }

    class Pair
    {
        int m;
        int cap;

        public Pair(int m, int cap)
        {
            this.m = m;
            this.cap = cap;
        }
    }
}
