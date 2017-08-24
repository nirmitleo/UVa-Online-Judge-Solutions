package UVa.Dominator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by DELL on 19-Jan-16.
 */
public class Main
{
    int size;
    boolean graph[][];
    boolean visited[];
    boolean solution[][];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String arpg[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++)
        {
            size = Integer.parseInt(br.readLine());
            graph = new boolean[size][size];
            solution = new boolean[size][size];
            for (int i = 0; i < graph.length; i++)
            {
                String tokens[] = br.readLine().split(" ");
                for (int j = 0; j < graph[i].length; j++)
                {
                    graph[i][j] = (tokens[j].equals("1"));
                }
            }
            for (int i = 0; i < size; i++)
            {
                dfs(0, i);
                for (int j = i; j < size; j++)
                {
                    solution[i][j] = !visited[j];
                    solution[i][j] = (i == j) || solution[i][j];
                }
            }
            System.out.println("Case " + t + ":");
            System.out.print("+");
            for (int k = 0; k <= 2 * graph[0].length - 2; k++)
            {
                System.out.print("-");
            }
            System.out.println("+");
            for (int i = 0; i < solution.length; i++)
            {
                for (int j = 0; j < solution[i].length; j++)
                {
                    if (solution[i][j])
                    {
                        System.out.print("|Y");
                    }
                    else
                    {
                        System.out.print("|N");
                    }
                }
                System.out.print("|\n+");
                for (int k = 0; k <= 2 * graph[0].length - 2; k++)
                {
                    System.out.print("-");
                }
                System.out.println("+");
            }
        }
    }

    public void dfs(int root, int turnOffNode)
    {
        Stack<Integer> stack = new Stack<Integer>();
        visited = new boolean[size];

        stack.push(root);
        visited[root] = true;

        while (!stack.isEmpty())
        {
            root = stack.peek();
            if (root != turnOffNode)
            {
                int index = 0;
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
            else
            {
                stack.pop();
            }
        }
    }
}
