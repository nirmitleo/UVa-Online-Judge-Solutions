package UVa.MapMaker;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by DELL on 15-Oct-15.
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        TaskA a = new TaskA();
        a.solve(in, out);

        out.close();
    }
}

class TaskA
{
    public void solve(InputReader in, PrintWriter out)
    {
        int N = in.nextInt();
        int R = in.nextInt();
        NewArray a[] = new NewArray[N];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = new NewArray(in.next(), in.nextInt(), in.nextInt(), in.nextInt());
            a[i].bounds = new int[a[i].dimension * 2];
            a[i].elements = new int[a[i].dimension];
            a[i].c = new int[a[i].dimension + 1];
            for (int j = 0; j < a[i].bounds.length; j++)
            {
                a[i].bounds[j] = in.nextInt();
            }
        }
        for (int i = 0; i < R; i++)
        {
            String name = in.next();
            for (int j = 0; j < a.length; j++)
            {
                if (a[j].name.equalsIgnoreCase(name))
                {
                    for (int k = 0; k < a[j].elements.length; k++)
                    {
                        a[j].elements[k] = in.nextInt();
                    }
                    int c[] = a[j].c;
                    c[c.length - 1] = a[j].size;
                    for (int k = c.length - 2; k >= 0; k--)
                    {
                        if (k == 0)
                        {
                            c[k] = a[j].baseAddress;
                            for (int ic = 1; ic < c.length; ic++)
                            {
                                c[k] -= c[ic] * a[j].bounds[2 * (ic - 1)];
                            }
                        }
                        else
                        {
                            c[k] = c[k + 1] * (a[j].bounds[2 * k + 1] - a[j].bounds[2 * k] + 1);
                        }
                    }
                    int ref = c[0];
                    for (int l = 1; l < c.length; l++)
                    {
                        ref += c[l] * a[j].elements[l - 1];
                    }
                    String result = a[j].name + "[";
                    for (int z = 0; z < a[j].elements.length; z++)
                    {
                        if (z != a[j].elements.length - 1)
                        {
                            result += a[j].elements[z] + ", ";
                        }
                        else
                        {
                            result += a[j].elements[z];
                        }
                    }
                    result += "] = " + ref;
                    out.println(result);
                    break;
                }

            }


        }

        int i = 0;
    }

}

class NewArray
{
    String name;
    int baseAddress;
    int size;
    int dimension;
    int bounds[];
    int elements[];
    int c[];

    public NewArray(String name, int baseAddress, int size, int dimension)
    {
        this.name = name;
        this.baseAddress = baseAddress;
        this.size = size;
        this.dimension = dimension;
    }
}


class InputReader
{
    BufferedReader br;
    StringTokenizer st;

    public InputReader(InputStream inputStream)
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