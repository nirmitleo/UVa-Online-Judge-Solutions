package UVa.ForwardingEmails.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by DELL on 30-Jun-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int size;
    private boolean graph[][];

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while ((line = br.readLine()) != null)
        {
            int test = Integer.parseInt(line.trim());

            for (int t = 1; t <= test; t++)
            {
                size = Integer.parseInt(br.readLine());
                graph = new boolean[size][size];
                for (int i = 0; i < size; i++)
                {
                    tokens = br.readLine().trim().split("[ ]+");
                    int from = Integer.parseInt(tokens[0]) - 1;
                    int to = Integer.parseInt(tokens[1]) - 1;
                    if (from >= 0 && from < size && to >= 0 && to < size)
                    {
                        graph[from][to] = true;
                    }
                }
                int node = -1;
                int best = -1;
                for (int i = 0; i < size; i++)
                {
                    int count = dfs(i);
                    if (count > best)
                    {
                        best = count;
                        node = i;
                    }
                }
                System.out.println("Case " + t + ": " + (node + 1));
            }
            return;
        }
    }

    public int dfs(int start)
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[size];

        int count = 1;
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty())
        {
            int from = stack.peek();
            int i = 0;
            for (; i < size; i++)
            {
                if (graph[from][i] && !visited[i])
                {
                    count++;
                    stack.push(i);
                    visited[i] = true;
                    break;
                }
            }
            if (i == size)
            {
                stack.pop();
            }
        }
        return count;
    }
}

