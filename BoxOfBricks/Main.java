package UVa.BoxOfBricks;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by DELL on 17-Oct-15.
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream, true);

        Main demo = new Main();
        demo.solve(in, out);
        out.println();
        out.close();
    }

    public void solve(InputReader in, PrintWriter out)
    {
        int counter = 0;
        while (true)
        {
            int n = in.nextInt();
            if (n == 0)
            {
                return;
            }
            int a[] = new int[n];
            int sum = 0;
            for (int i = 0; i < a.length; i++)
            {
                a[i] = in.nextInt();
                sum += a[i];
            }
            int avg = sum / a.length;
            int count = 0;
            for (int i = 0; i < a.length; i++)
            {
                if (avg - a[i] > 0)
                {
                    count += avg - a[i];
                }
            }
            if (counter == 0)
            {
                out.println("Set #" + (++counter));
            }
            else
            {
                out.println("\n" + "Set #" + (++counter));
            }
            out.println("The minimum number of moves is " + count + ".");
        }
    }
}

class InputReader
{
    BufferedReader br;
    StringTokenizer st;

    InputReader(InputStream inputStream)
    {
        br = new BufferedReader(new InputStreamReader(inputStream), 32768);
    }

    public String next()
    {
        while (st == null || !st.hasMoreTokens())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt()
    {
        return Integer.parseInt(next());
    }
}
