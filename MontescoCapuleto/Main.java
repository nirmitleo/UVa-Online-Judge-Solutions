package UVa.MontescoCapuleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 13-Feb-16.
 */
public class Main
{
    int v;
    int e;
    int queue[];
    int colors[];
    boolean a[][];
    TreeMap<Integer, String> lines;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        //br = new BufferedReader(new FileReader(new File("./src/UVa/MontescoCapuleto/input.txt")));
        int test = Integer.parseInt(br.readLine());
        br.readLine();
        for (int t = 0; t < test; t++)
        {
            v = Integer.parseInt(br.readLine());
            lines = new TreeMap<Integer, String>();
            for (int i = 0; i < v; i++)
            {
                String l = br.readLine();
                lines.put(i, l);
            }

            queue = new int[lines.size()];
            colors = new int[lines.size()];
            a = new boolean[lines.size()][lines.size()];
            for (Map.Entry<Integer, String> entry : lines.entrySet())
            {
                int from = entry.getKey();
                String tokens[] = entry.getValue().split(" ");
                for (int i = 1; i < tokens.length; i++)
                {
                    int to = Integer.parseInt(tokens[i]) - 1;
                    if (from >= 0 && to >= 0 && from < a.length && to < a[i].length)
                    {
                        a[from][to] = a[to][from] = true;
                    }
                }
            }
            if (t == 0)
            {
                System.out.print(compute());
            }
            else
            {
                System.out.print("\n" + compute());
            }
            String line = "";
            if ((line = br.readLine()) == null)
            {
                break;
            }
        }
    }

    public int compute()
    {
        int count = 0;
        for (int i = 0; i < colors.length; i++)
        {
            if (colors[i] == 0)
            {
                int result = bfs(i);
                count += result;
            }
        }
        return count;
    }

    public int bfs(int start)
    {
        int count1 = 1;
        int count2 = 0;
        int front = -1;
        int rear = -1;
        queue[++rear] = start;
        colors[start] = 1;
        while (front != rear)
        {
            start = queue[++front];
            for (int i = 0; i < colors.length; i++)
            {
                if (i != start && a[start][i])
                {
                    if (colors[i] == 0)
                    {
                        if (colors[start] == 1)
                        {
                            colors[i] = 2;
                            count2++;
                        }
                        else
                        {
                            colors[i] = 1;
                            count1++;
                        }
                        queue[++rear] = i;
                    }
                    else if (colors[i] == colors[start])
                    {
                        return 0;
                    }
                }
            }
        }
        return Math.max(count1, count2);
    }
}
