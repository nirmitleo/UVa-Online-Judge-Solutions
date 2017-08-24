package UVa.AntiBruteForceLock;

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
    String pair[];
    PriorityQueue<Edge> edges;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String r[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        int cost = 0;
        while (test-- > 0)
        {
            String tokens[] = br.readLine().split(" ");
            pair = new String[Integer.parseInt(tokens[0])];
            rank = new int[tokens.length - 1];
            p = new int[tokens.length - 1];
            edges = new PriorityQueue<Edge>();
            for (int i = 1; i < tokens.length; i++)
            {
                pair[i - 1] = tokens[i];
                p[i - 1] = i - 1;
            }
            cost = Integer.MAX_VALUE;
            for (int i = 0; i < pair.length; i++)
            {
                cost = Math.min(cost, getRolls("0000", pair[i]));
                for (int j = i + 1; j < pair.length; j++)
                {
                    int value = getRolls(pair[i], pair[j]);
                    edges.add(new Edge(i, j, value));
                }
            }
            while (!edges.isEmpty())
            {
                Edge temp = edges.poll();
                if (!isSameSet(temp.from, temp.to))
                {
                    unionSet(temp.from, temp.to);
                    cost += temp.value;
                }
            }
            System.out.println(cost);
        }
    }


    public int getRolls(String start, String end)
    {
        int sum = 0;
        for (int i = 0; i < start.length(); i++)
        {
            int s = Integer.parseInt(start.charAt(i) + "");
            int e = Integer.parseInt(end.charAt(i) + "");
            if (s == e)
            {
                continue;
            }
            int diff = Math.abs(e - s);
            sum += Math.min(diff, 10 - diff);
        }
        return sum;
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