package UVa.Minefield.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.*;

public class Minefield
{
    private int V;
    private int vIndex;
    private ArrayList[] g;
    private TreeMap<Point, Integer> map;
    private final static long INFINITY = ((long) 1e15);

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (; ; )
        {
            String s = in.next();
            if (s == null || s.contains("*"))
            {
                return;
            }
            //Read the source point i.e. P1(0, 0)//
            Point p1 = new Point(0, 0);

            //Read the sink point i.e. P2(W, H)//
            int w = Integer.parseInt(s);
            int h = in.nextInt();
            Point p2 = new Point(w, h);

            //The following code ensures that I don't read any duplicate points//
            //TreeMap - removes duplicate, and maps a given "Player" to "VertexID"//
            //TreeSet - avoids duplicate//
            vIndex = 0;
            map = new TreeMap<>();
            V = in.nextInt();
            TreeSet<Point> set = new TreeSet<>();
            int source = getVertexID(p1);
            set.add(p1);
            for (int i = 0; i < V; i++)
            {
//                    String line = in.br.readLine();
//                    StringTokenizer st = new StringTokenizer(line);
//                    long x = getIntegerFromDouble(st.nextToken());
//                    long y = getIntegerFromDouble(st.nextToken());
//                    double x = getDouble(st.nextToken());
//                    double y = getDouble(st.nextToken());
                double x = in.nextDouble();
                double y = in.nextDouble();
                Point p = new Point(x, y);
                getVertexID(p);
                set.add(p);
            }
            int sink = getVertexID(p2);
            set.add(p2);

            //Initializing my Adjacency list//
            V = set.size();
            g = createGraph(V);
            Point[] points = new Point[V];
            for (int i = 0; i < V; i++)
            {
                points[i] = set.pollFirst();
            }

            //O(n^2) to make the connections (or edges)//
            for (int i = 0; i < V; i++)
            {
                //the mapping done earlier is now helping us to address a Player with VertexID//
                int from = map.get(points[i]);
                for (int j = i + 1; j < V; j++)
                {
                    double d = getDist(points[i], points[j]);
                    if (d < 1.5 || Math.abs(d - 1.5) < 1e-7)
                    {
                        //the mapping done earlier is now helping us to address a Player with VertexID//
                        int to = map.get(points[j]);
                        addEdge(from, to, d);
                    }
                }
            }

//            double dist = getDouble(in.next());
            double dist = in.nextDouble();
            double d = dijkstra(source, sink);
            //I could reach the sink//
            if (d < dist || Math.abs(d - dist) < 1e-7)
            {
                out.println("I am lucky!");
            } else
            {
                //I could reach the sink but the distance is too long//
                out.println("Boom!");
            }
        }
    }

    public double getDouble(String s)
    {
        //Assuming the format will ##.##//
//        int dot = s.indexOf(".");
//        int beforeDot = Integer.parseInt(s.substring(0, dot));
//        int afterDot = Integer.parseInt(s.substring(dot + 1));
//        return Double.parseDouble(beforeDot + "." + afterDot);
        return Double.parseDouble(s);
    }

    public long getIntegerFromDouble(String s)
    {
        //Assuming the format will ##.##//
        int dot = s.indexOf(".");
        int beforeDot = Integer.parseInt(s.substring(0, dot));
        int afterDot = Integer.parseInt(s.substring(dot + 1));
        return beforeDot * 100 + afterDot;
    }

    public double dijkstra(int source, int sink)
    {
        double[] dist = new double[V];
        Arrays.fill(dist, INFINITY);

        PriorityQueue<Vertex> q = new PriorityQueue<>();

        dist[source] = 0;
        q.add(new Vertex(source, 0));

        while (!q.isEmpty())
        {
            Vertex U = q.poll();
            if (U.dist > dist[U.id])
            {
                continue;
            }
            ArrayList<Edge> next = g[U.id];
            for (Edge e : next)
            {
                if (dist[e.to] > dist[e.from] + e.dist)
                {
                    dist[e.to] = dist[e.from] + e.dist;
                    Vertex V = new Vertex(e.to, dist[e.to]);
                    q.add(V);
                }
            }
        }
        return dist[sink];
    }

    public void addEdge(int from, int to, double dist)
    {
        Edge ab = new Edge(from, to, dist);
        Edge ba = new Edge(to, from, dist);

        g[from].add(ab);
        g[to].add(ba);
    }

    public double getDist(Point p, Point q)
    {
        return Math.sqrt(sq(p.x - q.x) + sq(p.y - q.y));
    }

    public double sq(double x)
    {
        return x * x;
    }

    public int getVertexID(Point name)
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
        double dist;

        public Edge(int from, int to, double dist)
        {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    public class Vertex implements Comparable<Vertex>
    {
        int id;
        double dist;

        public Vertex(int id, double dist)
        {
            this.id = id;
            this.dist = dist;
        }

        public int compareTo(Vertex that)
        {
            return Double.compare(this.dist, that.dist);
        }
    }

    public class Point implements Comparable<Point>
    {
        double x;
        double y;

        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point that)
        {
            int xDiff = Double.compare(this.x, that.x);
            return xDiff != 0 ? xDiff : Double.compare(this.y, that.y);
        }

        public String toString()
        {
            return "X = " + x + ", Y = " + y;
        }
    }
}
