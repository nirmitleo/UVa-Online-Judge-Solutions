package UVa.DrivingRange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by DELL on 12-Feb-16.
 */
public class Main
{
    int count;
    int p[];
    int rank[];
    PriorityQueue<Edge> edges;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        while ((line = br.readLine()) != null)
        {
            String tokens[] = line.split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            if (n == m && n == 0)
            {
                break;
            }
            if (m == 0)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            count = n;
            p = new int[n];
            rank = new int[n];
            edges = new PriorityQueue<Edge>();
            for (int i = 0; i < p.length; i++)
            {
                p[i] = i;
            }
            for (int i = 0; i < m; i++)
            {
                tokens = br.readLine().split(" ");
                edges.add(new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
            }
            int max = 0;
            while (!edges.isEmpty())
            {
                Edge temp = edges.poll();
                if (!isSameSet(temp.from, temp.to))
                {
                    unionSet(temp.from, temp.to);
                    max = Math.max(temp.value, max);
                }
            }
            if (count == 1)
            {
                System.out.println(max);
            }
            else
            {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public int findSet(int i)
    {
        return i == p[i] ? i : (p[i] = findSet(p[i]));
    }

    public boolean isSameSet(int i, int j)
    {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j)
    {
        if (!isSameSet(i, j))
        {
            count--;
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
    int value;

    Edge(int from, int to, int value)
    {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public int compareTo(Edge that)
    {
        return this.value - that.value;
    }
}