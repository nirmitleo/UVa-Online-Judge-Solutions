package UVa.GopherAndHawks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by DELL on 17-Feb-16.
 */
public class Main
{
    int maxDistance;
    double a[][];
    int queue[];
    int layer[];
    boolean visited[];
    ArrayList<Node> nodes;
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while (true)
        {
            tokens = br.readLine().split(" ");
            int v = Integer.parseInt(tokens[0]);
            int time = Integer.parseInt(tokens[1]);
            if (v == time && v == 0)
            {
                break;
            }
            maxDistance = v * time * 60;
            nodes = new ArrayList<Node>();
            while (true)
            {
                String line = br.readLine();
                if (line.trim().length() == 0)
                {
                    break;
                }
                tokens = line.split(" ");
                double x = Double.parseDouble(tokens[0]);
                double y = Double.parseDouble(tokens[1]);
                nodes.add(new Node(x, y));
            }
            a = new double[nodes.size()][nodes.size()];
            visited = new boolean[nodes.size()];
            layer = new int[nodes.size()];
            queue = new int[nodes.size()];
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a[i].length; j++)
                {
                    a[i][j] = -1;
                }
            }
            for (int i = 0; i < nodes.size(); i++)
            {
                Node from = nodes.get(i);
                for (int j = i + 1; j < nodes.size(); j++)
                {
                    Node to = nodes.get(j);
                    double xDiff = (from.x - to.x) * (from.x - to.x);
                    double yDiff = (from.y - to.y) * (from.y - to.y);
                    a[i][j] = a[j][i] = Math.sqrt(xDiff + yDiff);
                }
            }
            bfs(0, 1);
            if (visited[1] && layer[1] != 0)
            {
                System.out.println("Yes, visiting " + (layer[1] - 1) + " other holes.");
            }
            else
            {
                System.out.println("No.");
            }
        }
    }

    public void bfs(int start, int end)
    {
        int front = -1;
        int rear = -1;
        queue[++rear] = start;
        visited[start] = true;
        while (rear != front)
        {
            start = queue[++front];
            for (int i = 0; i < visited.length; i++)
            {
                if (i != start && a[start][i] != -1 && a[start][i] < maxDistance && !visited[i])
                {
                    queue[++rear] = i;
                    visited[i] = true;
                    layer[i] = layer[start] + 1;
                    if (i == end)
                    {
                        return;
                    }
                }
            }
        }

    }
}

class Node
{
    double x;
    double y;

    public Node(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}
