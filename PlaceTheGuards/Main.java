package UVa.PlaceTheGuards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            String tokens[] = br.readLine().split(" ");
            v = Integer.parseInt(tokens[0]);
            e = Integer.parseInt(tokens[1]);
            queue = new int[v];
            colors = new int[v];
            a = new boolean[v][v];
            for (int i = 0; i < e; i++)
            {
                tokens = br.readLine().split(" ");
                int to = Integer.parseInt(tokens[0]);
                int from = Integer.parseInt(tokens[1]);
                a[to][from] = a[from][to] = true;
            }
            System.out.println(compute());
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
                if (result == -1)
                {
                    return -1;
                }
                count += result;
            }
        }
        return count;
    }

    public int bfs(int start)
    {
        int color1 = 1;
        int color2 = 0;
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
                            color2++;
                        }
                        else
                        {
                            colors[i] = 1;
                            color1++;
                        }
                        queue[++rear] = i;
                    }
                    else if (colors[i] == colors[start])
                    {
                        return -1;
                    }
                }
            }
        }
        if (color1 != 0 && color2 != 0)
        {
            return Math.min(color1, color2);
        }
        else if (color1 == 0)
        {
            return color2;
        }
        else
        {
            return color1;
        }
    }
}
