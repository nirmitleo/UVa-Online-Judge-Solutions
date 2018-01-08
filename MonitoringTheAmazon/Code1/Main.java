package UVa.MonitoringTheAmazon.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by DELL on 01-Jul-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n;
    private TreeMap<Integer, TreeSet<Point>> graph;
    private TreeMap<Integer, Point> nodes;
    private boolean was[];
    private Point first;

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while ((line = br.readLine()) != null)
        {
            n = Integer.parseInt(line.trim());
            if (n == 0)
            {
                return;
            }

            nodes = new TreeMap<Integer, Point>();
            graph = new TreeMap<Integer, TreeSet<Point>>();
            was = new boolean[n];

            tokens = br.readLine().trim().split("[ ]+");
            for (int i = 0; i < tokens.length; i += 2)
            {
                int x = Integer.parseInt(tokens[i]);
                int y = Integer.parseInt(tokens[i + 1]);
                Point t = new Point(i / 2, x, y, 0);
                graph.put(i / 2, new TreeSet<Point>());
                nodes.put(i / 2, t);
            }

            for (Map.Entry<Integer, Point> entry : nodes.entrySet())
            {
                Point from = entry.getValue();

                int id = from.id;
                TreeSet<Point> connected = graph.get(id);
                TreeSet<Point> temp = new TreeSet<Point>();
                for (Map.Entry<Integer, Point> entry2 : nodes.entrySet())
                {
                    Point to = entry2.getValue();
                    if (from != to)
                    {
                        to.dist = getDistance(from, to);
                        temp.add(to);
                    }
                }
                int count = 0;
                while (count < 2 && !temp.isEmpty())
                {
                    connected.add(temp.pollFirst());
                    count++;
                }
            }

            dfs(0);
            boolean isFound = true;
            for (int i = 0; i < was.length; i++)
            {
                if (!was[i])
                {
                    System.out.println("There are stations that are unreachable.");
                    isFound = false;
                    break;
                }
            }
            if (isFound)
            {
                System.out.println("All stations are reachable.");
            }
        }
    }

    public void dfs(int start)
    {
        Stack<Integer> stack = new Stack<Integer>();

        was[start] = true;
        stack.push(start);

        while (!stack.isEmpty())
        {
            start = stack.peek();
            TreeSet<Point> connected = graph.get(start);
            while (!connected.isEmpty())
            {
                Point t = connected.pollFirst();
                was[t.id] = true;
                stack.push(t.id);
                break;
            }
            if (connected.size() == 0)
            {
                stack.pop();
            }
        }
    }

    public int getDistance(Point a, Point b)
    {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}


class Point implements Comparable<Point>
{
    int id;
    int x;
    int y;
    int dist;

    public Point(int id, int x, int y, int dist)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int compareTo(Point that)
    {
        if (this.dist != that.dist)
        {
            return this.dist - that.dist;
        } else if (this.x != that.x)
        {
            return this.x - that.x;
        }
        return this.y - that.y;
    }
}