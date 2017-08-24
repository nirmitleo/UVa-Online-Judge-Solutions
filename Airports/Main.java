package UVa.Airports;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by DELL on 10-Feb-16.
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
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++)
        {
            String tokens[] = br.readLine().split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            int airportCost = Integer.parseInt(tokens[2]);
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
                int to = Integer.parseInt(tokens[0]) - 1;
                int from = Integer.parseInt(tokens[1]) - 1;
                int value = Integer.parseInt(tokens[2]);
                edges.add(new Edge(to, from, value));
            }
            int cost = 0;
            while (!edges.isEmpty())
            {
                Edge temp = edges.poll();
                if ( !isSameSet(temp.to, temp.from) && temp.value < airportCost )
                {
                    unionSet(temp.to, temp.from);
                    cost += temp.value;
                }
            }
            cost += (count * airportCost);
            System.out.println("Case #" + t + ": " + cost + " " + count);
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
        if ( !isSameSet(i, j) )
        {
            count--;
            int x = findSet(i);
            int y = findSet(j);
            if ( rank[x] > rank[y] )
            {
                p[y] = x;
            } else
            {
                p[x] = y;
                if ( rank[x] == rank[y] )
                {
                    rank[y]++;
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>
{
    int to;
    int from;
    int value;

    Edge(int to, int from, int value)
    {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    public int compareTo(Edge that)
    {
        return this.value - that.value;
    }

}
