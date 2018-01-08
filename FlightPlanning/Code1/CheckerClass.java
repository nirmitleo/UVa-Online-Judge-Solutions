package UVa.FlightPlanning.Code1;

import Spark.GraphUtils.Graphs.IntegerGraph;
import net.egork.chelper.checkers.Checker;
import net.egork.chelper.tester.Verdict;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CheckerClass implements Checker
{
    private int V;
    private int[] dist;
    private int[] path;
    private IntegerGraph g;
    private final static int INF = ((int) 1e7);

    public CheckerClass(String parameters)
    {
    }

    public Verdict check(String input, String expectedOutput, String actualOutput)
    {
        StringTokenizer in = new StringTokenizer(input);
        StringTokenizer out = new StringTokenizer(actualOutput);

        boolean res = true;
        int test = nextInt(in);
        for (int t = 1; t <= test; t++)
        {
            V = nextInt(in);
            dist = new int[V];
            path = new int[V];
            g = new IntegerGraph(V, 0);
            for (int i = 0; i < V - 1; i++)
            {
                int from = nextInt(in) - 1;
                int to = nextInt(in) - 1;
                g.addEdge(from, to, true);
            }

            TreeSet<Solution> solutions = new TreeSet<>();

            ArrayList<Pair> list = getDiameterPairs();
            for (Pair p : list)
            {
                int u = p.u;
                int v = p.v;
                ArrayList<Integer> route = getRoute(u, v);
                int n = route.size();
                for (int i = 1; i < n; i++)
                {
                    int from = route.get(i - 1);
                    int to = route.get(i);
                    g.removeEdge(from, to, true);

                    for (int j = 0; j < n; j++)
                    {
                        int x = route.get(j);
                        for (int k = j + 1; k < n; k++)
                        {
                            int y = route.get(k);
                            if ((x == from && y == to) || g.isConnected(x, y))
                            {
                                continue;
                            }
                            g.addEdge(x, y, true);
                            int d = getDiameter();
                            Solution sol = new Solution(d, x, y, from, to);
                            if (solutions.isEmpty())
                            {
                                solutions.add(sol);
                            } else
                            {
                                if (sol.d == solutions.first().d)
                                {
                                    solutions.add(sol);
                                } else if (sol.d < solutions.first().d)
                                {
                                    solutions = new TreeSet<>();
                                    solutions.add(sol);
                                }
                            }
                            g.removeEdge(x, y, true);
                        }
                    }
                    g.addEdge(from, to, true);
                }
            }

            int d = nextInt(out);
            int a = nextInt(out) - 1;
            int b = nextInt(out) - 1;
            int x = nextInt(out) - 1;
            int y = nextInt(out) - 1;

            if (d != solutions.first().d)
            {
                return Verdict.WA;
            }
            Solution s = new Solution(d, x, y, a, b);
            if (!solutions.contains(s))
            {
                return Verdict.WA;
            }
        }
        return Verdict.OK;
    }


    private ArrayList<Integer> getRoute(int source, int sink)
    {
        init(source);
        dfs(source);
        ArrayList<Integer> route = new ArrayList<>();
        while (sink != source)
        {
            route.add(sink);
            sink = path[sink];
        }
        route.add(sink);

        return route;
    }

    private int getDiameter()
    {
        init(0);
        dfs(0);
        int source = -1;
        int d = getMaxDist();
        for (int i = 0; i < V; i++)
        {
            if (dist[i] == d)
            {
                source = i;
            }
        }

        init(source);
        dfs(source);
        d = getMaxDist();
        return d;
    }

    private ArrayList<Pair> getDiameterPairs()
    {
        init(0);
        dfs(0);

        int d = getMaxDist();
        TreeSet<Integer> d1 = new TreeSet<>();
        for (int i = 0; i < V; i++)
        {
            if (dist[i] == d)
            {
                d1.add(i);
            }
        }

        init(d1.first());
        dfs(d1.first());
        d = getMaxDist();
        TreeSet<Integer> d2 = new TreeSet<>();
        for (int i = 0; i < V; i++)
        {
            if (dist[i] == d)
            {
                d2.add(i);
            }
        }
        d1.removeAll(d2);

        Integer[] x = new Integer[d1.size()];
        Integer[] y = new Integer[d2.size()];
        d1.toArray(x);
        d2.toArray(y);
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < x.length; i++)
        {
            for (int j = 0; j < y.length; j++)
            {
                list.add(new Pair(x[i], y[j], d));
            }
        }
        return list;
    }

    private int getMaxDist()
    {
        int d = -1;
        for (int i = 0; i < V; i++)
        {
            d = Math.max(d, dist[i]);
        }
        return d;
    }

    private void init(int source)
    {
        for (int i = 0; i < V; i++)
        {
            path[i] = i;
            dist[i] = INF;
        }
        dist[source] = 0;
    }

    private void dfs(int u)
    {
        ArrayList<Integer> next = g.internalGraph[u];
        for (int i = 0; i < next.size(); i++)
        {
            int v = next.get(i);
            if (dist[v] == INF)
            {
                dist[v] = dist[u] + 1;
                path[v] = u;
                dfs(v);
            }
        }
    }

    private class Pair
    {
        int u;
        int v;
        int dist;

        public Pair(int u, int v, int dist)
        {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
    }

    class Solution implements Comparable<Solution>
    {
        int d;
        int addV1;
        int addV2;
        int removeV1;
        int removeV2;

        public Solution(int d, int addV1, int addV2, int removeV1, int removeV2)
        {
            this.d = d;
            this.addV1 = Math.min(addV1, addV2);
            this.addV2 = Math.max(addV1, addV2);
            this.removeV1 = Math.min(removeV1, removeV2);
            this.removeV2 = Math.max(removeV1, removeV2);
        }

        public int compareTo(Solution that)
        {
            int dDiff = Integer.compare(this.d, that.d);
            if (dDiff == 0)
            {
                int addV1Diff = Integer.compare(this.addV1, that.addV1);
                if (addV1Diff == 0)
                {
                    int addV2Diff = Integer.compare(this.addV2, that.addV2);
                    if (addV2Diff == 0)
                    {
                        int removeV1Diff = Integer.compare(this.removeV1, that.removeV1);
                        return removeV1Diff != 0 ? removeV1Diff : Integer.compare(this.removeV2, that.removeV2);
                    }
                    return addV2Diff;
                }
                return addV1Diff;
            }
            return dDiff;
        }
    }

    private String next(StringTokenizer st)
    {
        return st.nextToken();
    }

    private Integer nextInt(StringTokenizer st)
    {
        return Integer.parseInt(next(st));
    }
}
