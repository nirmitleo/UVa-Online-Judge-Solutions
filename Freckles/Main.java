package UVa.Freckles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by DELL on 10-Feb-16.
 */
public class Main
{
    int p[];
    int rank[];
    Node node[];
    PriorityQueue<Edge> edges;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        String line = "";
        boolean isFirst = true;
        while (test-- > 0)
        {
            br.readLine();
            line = br.readLine();
            int n = Integer.parseInt(line);
            node = new Node[n];
            p = new int[n];
            rank = new int[n];
            edges = new PriorityQueue<Edge>();
            for (int i = 0; i < node.length; i++)
            {
                String tokens[] = br.readLine().split(" ");
                node[i] = new Node(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
                p[i] = i;
            }
            for (int i = 0; i < node.length; i++)
            {
                for (int j = i + 1; j < node.length; j++)
                {
                    Node from = node[i];
                    Node to = node[j];
                    double value = Math.sqrt(Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2));
                    Edge temp = new Edge(i, j, value);
                    edges.add(temp);
                }
            }
            double cost = 0;
            while (!edges.isEmpty())
            {
                Edge temp = edges.poll();
                if (!isSameSet(temp.to, temp.from))
                {
                    unionSet(temp.to, temp.from);
                    cost += temp.value;
                }
            }
            System.out.printf("%.2f\n", cost);
            if (test != 0)
            {
                System.out.println();
            }
        }
    }

    public int findSet(int i)
    {
        return p[i] == i ? i : (p[i] = findSet(p[i]));
    }

    public boolean isSameSet(int i, int j)
    {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j)
    {
        if (!isSameSet(i, j))
        {
            int x = findSet(i);
            int y = findSet(j);
            if (rank[x] > rank[y])
            {
                p[y] = x;
            }
            else
            {
                p[x] = y;
                if (rank[x] == rank[y])
                {
                    rank[y]++;
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>
{
    int from;
    int to;
    double value;

    public Edge(int from, int to, double value)
    {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public int compareTo(Edge that)
    {
        double diff = this.value - that.value;
        return diff < 0 ? -1 : diff > 0 ? 1 : 0;
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
