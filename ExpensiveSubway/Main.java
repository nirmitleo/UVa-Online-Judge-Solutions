package UVa.ExpensiveSubway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by DELL on 12-Feb-16.
 */
public class Main
{
    int p[];
    int count;
    int rank[];
    PriorityQueue<Edge> edges;
    TreeMap<String, Integer> cities;
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
            String tokens[] = br.readLine().split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            if (n == m && n == 0)
            {
                break;
            }
            count = n;
            p = new int[n];
            rank = new int[n];
            cities = new TreeMap<String, Integer>();
            edges = new PriorityQueue<Edge>();
            for (int i = 0; i < n; i++)
            {
                p[i] = i;
                cities.put(br.readLine(), i);
            }
            for (int i = 0; i < m; i++)
            {
                tokens = br.readLine().split(" ");
                int city1 = cities.get(tokens[0]);
                int city2 = cities.get(tokens[1]);
                int value = Integer.parseInt(tokens[2]);
                edges.add(new Edge(city1, city2, value));
            }
            int cost = 0;
            while (!edges.isEmpty())
            {
                Edge temp = edges.poll();
                if (!isSameSet(temp.from, temp.to))
                {
                    cost += temp.value;
                    unionSet(temp.from, temp.to);
                }
            }
            if (count > 1)
            {
                System.out.println("Impossible");
            }
            else
            {
                System.out.println(cost);
            }
            br.readLine();
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

    public Edge(int from, int to, int value)
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