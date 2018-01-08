package UVa.MiceAndMaze.Code1;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.*;

public class MiceAndMazeTestCase
{
    private Random r = new Random();

    @TestCase
    public Collection<Test> createTests()
    {
        int test = 1;
        StringBuilder sb = new StringBuilder(test + "\n\n");
        ArrayList<Test> tests = new ArrayList<>();
        for (int t = 1; t <= test; t++)
        {
            int V = getRandom(5, 7);
            int sink = getRandom(1, V);
            int timer = getRandom(1, V);
            sb.append(V + "\n");
            sb.append(sink + "\n");
            sb.append(timer + "\n");

            int E = getRandom(V - 1, (V * (V - 1)) / 2);
            sb.append(E + "\n");
            ArrayList<Integer> vertex = new ArrayList<>();
            for (int i = 1; i <= V; i++)
            {
                vertex.add(i);
            }
            TreeSet<Edge> edges = new TreeSet<>();
            Collections.shuffle(vertex);
            for (int i = 1; i < vertex.size(); i++)
            {
                int from = vertex.get(i - 1);
                int to = vertex.get(i);
                int cap = getRandom(1, V);
                edges.add(new Edge(from, to, cap));
            }
            int count = edges.size();
            while (count < E)
            {
                int from = vertex.get(getRandom(0, V - 1));
                int to = vertex.get(getRandom(0, V - 1));
                if (from != to)
                {
                    int cap = getRandom(1, V);
                    edges.add(new Edge(from, to, cap));
                }
                count = edges.size();
            }
            while (!edges.isEmpty())
            {
                sb.append(edges.pollFirst() + "\n");
            }
            tests.add(new Test(sb.toString()));
        }
        return tests;
    }

    public int getRandom(int min, int max)
    {
        return r.nextInt(max - min + 1) + min;
    }

    class Edge implements Comparable<Edge>
    {
        int from;
        int to;
        int cap;

        public Edge(int from, int to, int cap)
        {
            this.from = from;
            this.to = to;
            this.cap = cap;
        }

        public int compareTo(Edge that)
        {
            int fromDiff = Integer.compare(this.from, that.from);
            return fromDiff != 0 ? fromDiff : Integer.compare(this.to, that.to);
        }

        public String toString()
        {
            return from + " " + to + " " + cap;
        }
    }
}
