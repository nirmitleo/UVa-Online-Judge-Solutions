package UVa.BombsNoTheyAreMines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by DELL on 17-Feb-16.
 */
public class Main
{
    int path[][];
    boolean a[][];
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        boolean isFirst = true;
        while (true)
        {
            tokens = br.readLine().split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            if (row == 0 && col == 0)
            {
                break;
            }
            a = new boolean[row][col];
            path = new int[row][col];
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++)
            {
                tokens = br.readLine().split(" ");
                int from = Integer.parseInt(tokens[0]);
                for (int j = 2; j < tokens.length; j++)
                {
                    int to = Integer.parseInt(tokens[j]);
                    a[from][to] = true;
                }
            }
            tokens = br.readLine().split(" ");
            int sx = Integer.parseInt(tokens[0]);
            int sy = Integer.parseInt(tokens[1]);
            Node start = new Node(sx, sy);
            tokens = br.readLine().split(" ");
            int ex = Integer.parseInt(tokens[0]);
            int ey = Integer.parseInt(tokens[1]);
            Node end = new Node(ex, ey);
            bfs(start, end);
            /*if (isFirst)
            {
                System.out.print(path[end.x][end.y]);
                isFirst = false;
            }
            else
            {*/
            System.out.println(path[end.x][end.y]);
            //}
        }
    }

    public void bfs(Node start, Node end)
    {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(start);
        a[start.x][start.y] = true;
        while (!queue.isEmpty())
        {
            start = queue.poll();
            if (start.x + 1 < a.length && !a[start.x + 1][start.y])
            {
                queue.add(new Node(start.x + 1, start.y));
                path[start.x + 1][start.y] = path[start.x][start.y] + 1;
                a[start.x + 1][start.y] = true;
                if (start.x + 1 == end.x && start.y == end.y)
                {
                    return;
                }
            }
            if (start.x - 1 >= 0 && !a[start.x - 1][start.y])
            {
                queue.add(new Node(start.x - 1, start.y));
                path[start.x - 1][start.y] = path[start.x][start.y] + 1;
                a[start.x - 1][start.y] = true;
                if (start.x - 1 == end.x && start.y == end.y)
                {
                    return;
                }
            }
            if (start.y + 1 < a[0].length && !a[start.x][start.y + 1])
            {
                queue.add(new Node(start.x, start.y + 1));
                path[start.x][start.y + 1] = path[start.x][start.y] + 1;
                a[start.x][start.y + 1] = true;
                if (start.x == end.x && start.y + 1 == end.y)
                {
                    return;
                }
            }
            if (start.y - 1 >= 0 && !a[start.x][start.y - 1])
            {
                queue.add(new Node(start.x, start.y - 1));
                path[start.x][start.y - 1] = path[start.x][start.y] + 1;
                a[start.x][start.y - 1] = true;
                if (start.x == end.x && start.y - 1 == end.y)
                {
                    return;
                }
            }
        }
    }
}

class Node
{
    int x;
    int y;

    public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
