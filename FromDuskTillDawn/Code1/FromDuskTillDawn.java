package UVa.FromDuskTillDawn.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.ArrayList;
import java.util.TreeMap;

public class FromDuskTillDawn
{
    private int V;
    private int E;
    private int vIndex;
    private ArrayList[] g;
    private TreeMap<String, Integer> map;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            vIndex = 0;
            E = in.nextInt();
            for (int i = 0; i < E; i++)
            {
                String name1 = in.next();
                String name2 = in.next();
                int time1 = in.nextInt();
                int time2 = in.nextInt();
                time2 += time1;
                time2 %= 24;
                if (time1 < 18 || time2 > 6)
                {
                    continue;
                }
                int from = getVertexID(name1);
                int to = getVertexID(name2);
                addEdge(from, to, time1, time2);
            }


        }
    }

    public void addEdge(int from, int to, int startTime, int endTime)
    {
        Edge ab = new Edge(from, to, startTime, endTime);
        g[from].add(ab);
    }

    public int getVertexID(String name)
    {
        Integer v = map.get(name);
        if (v == null)
        {
            map.put(name, vIndex);
            vIndex++;
            return vIndex - 1;
        }
        return v;
    }

    public ArrayList[] createGraph(int V)
    {
        ArrayList[] g = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList<Edge>();
        }
        return g;
    }

    public class Edge
    {
        int from;
        int to;
        int startTime;
        int endTime;

        public Edge(int from, int to, int startTime, int endTime)
        {
            this.from = from;
            this.to = to;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public class Vertex implements Comparable<Vertex>
    {
        int id;
        int time;
        int dist;

        public Vertex(int id, int time, int dist)
        {
            this.id = id;
            this.time = time;
            this.dist = dist;
        }

        public int compareTo(Vertex that)
        {
            int distDiff = Integer.compare(this.dist, that.dist);
            if (distDiff == 0)
            {
                int timeDiff = Integer.compare(this.time, that.time);
                return timeDiff != 0 ? timeDiff : Integer.compare(this.id, that.id);
            }
            return distDiff;
        }

    }
}
