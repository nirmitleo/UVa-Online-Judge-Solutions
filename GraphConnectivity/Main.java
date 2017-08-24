package UVa.GraphConnectivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main
{
    int size;
    boolean visited[];
    boolean graph[][];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();

    }

    /**
     * @throws IOException
     */
    public void solve() throws IOException
    {
        String line = "";
        int test = Integer.parseInt(br.readLine());
        br.readLine();
        for (int t = 1; t <= test; t++)
        {
            size = br.readLine().charAt(0) - 64;
            visited = new boolean[size];
            graph = new boolean[size][size];

            while ((line = br.readLine()) != null)
            {
                if (line.equals(""))
                {
                    break;
                }
                int fromNode = line.charAt(0) - 65;
                int toNode = line.charAt(1) - 65;
                // System.out.println("size = " + size + " fromNode = " + fromNode + " toNode = " + toNode);
                graph[fromNode][toNode] = true;
                graph[toNode][fromNode] = true;
            }
            int count = 0;
            for (int i = 0; i < visited.length; i++)
            {
                if (!visited[i])
                {
                    count++;
                    dfs(i);
                }
            }
            if (t == test)
            {
                System.out.println(count);
            }
            else
            {
                System.out.println(count + "\n");
            }
        }
        br.close();
    }

    public void dfs(int root)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        visited[root] = true;
        while (!stack.isEmpty())
        {
            int index = 0;
            root = stack.peek();
            for (; index < visited.length; index++)
            {
                if (!visited[index] && graph[root][index])
                {
                    stack.push(index);
                    visited[index] = true;
                    break;
                }
            }
            if (index == visited.length)
            {
                stack.pop();
            }
        }
    }

}
