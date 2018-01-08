package UVa.Fill.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Fill
{
    private int A;
    private int B;
    private int C;
    private int D;
    private int target;
    private int totalPour;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            target = 0;
            totalPour = 0;
            A = in.nextInt();
            B = in.nextInt();
            C = in.nextInt();
            D = in.nextInt();
            Vertex source = new Vertex(0, 0, C, 0);
            dijkstra(source);
            out.println(totalPour + " " + target);
        }
    }

    public void dijkstra(Vertex source)
    {
        int[] distA = new int[source.C + 1];
        int[] distB = new int[source.C + 1];
        int[] distC = new int[source.C + 1];
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        Arrays.fill(distC, Integer.MAX_VALUE);

        PriorityQueue<Vertex> q = new PriorityQueue<>();

        distA[source.A] = 0;
        distB[source.B] = 0;
        distC[source.C] = 0;

        q.add(source);

        while (!q.isEmpty())
        {
            Vertex U = q.poll();
            boolean ok1 = U.dist > distA[U.A];
            boolean ok2 = U.dist > distB[U.B];
            boolean ok3 = U.dist > distC[U.C];
            if (ok1 && ok2 && ok3)
            {
                continue;
            }

            /*
                If A > 0, then
                1) Pour into B
                2) Pour into C
             */
            if (U.A > 0)
            {
                int pour = Math.min(U.A, B - U.B);
                if (pour > 0)
                {
                    Vertex V = new Vertex(U.A - pour, U.B + pour, U.C, U.dist + pour);
                    boolean ok = false;
                    if (distA[U.A - pour] > U.dist + pour)
                    {
                        ok = true;
                        distA[U.A - pour] = U.dist + pour;
                    }
                    if (distB[U.B + pour] > U.dist + pour)
                    {
                        ok = true;
                        distB[U.B + pour] = U.dist + pour;
                    }
                    if (ok)
                    {
                        q.add(V);
                    }
                }

                pour = Math.min(U.A, C - U.C);
                if (pour > 0)
                {
                    Vertex V = new Vertex(U.A - pour, U.B, U.C + pour, U.dist + pour);
                    boolean ok = false;
                    if (distA[U.A - pour] > U.dist + pour)
                    {
                        ok = true;
                        distA[U.A - pour] = U.dist + pour;
                    }
                    if (distC[U.C + pour] > U.dist + pour)
                    {
                        ok = true;
                        distC[U.C + pour] = U.dist + pour;
                    }
                    if (ok)
                    {
                        q.add(V);
                    }
                }
            }

            if (U.B > 0)
            {
                int pour = Math.min(U.B, A - U.A);
                if (pour > 0)
                {
                    Vertex V = new Vertex(U.A + pour, U.B - pour, U.C, U.dist + pour);
                    boolean ok = false;
                    if (distA[U.A + pour] > U.dist + pour)
                    {
                        ok = true;
                        distA[U.A + pour] = U.dist + pour;
                    }
                    if (distB[U.B - pour] > U.dist + pour)
                    {
                        ok = true;
                        distB[U.B - pour] = U.dist + pour;
                    }
                    if (ok)
                    {
                        q.add(V);
                    }
                }

                pour = Math.min(U.B, C - U.C);
                if (pour > 0)
                {
                    Vertex V = new Vertex(U.A, U.B - pour, U.C + pour, U.dist + pour);
                    boolean ok = false;
                    if (distB[U.B - pour] > U.dist + pour)
                    {
                        ok = true;
                        distB[U.B - pour] = U.dist + pour;
                    }
                    if (distC[U.C + pour] > U.dist + pour)
                    {
                        ok = true;
                        distC[U.C + pour] = U.dist + pour;
                    }
                    if (ok)
                    {
                        q.add(V);
                    }
                }
            }

            if (U.C > 0)
            {
                int pour = Math.min(U.C, A - U.A);
                if (pour > 0)
                {
                    Vertex V = new Vertex(U.A + pour, U.B, U.C - pour, U.dist + pour);
                    boolean ok = false;
                    if (distA[U.A + pour] > U.dist + pour)
                    {
                        ok = true;
                        distA[U.A + pour] = U.dist + pour;
                    }
                    if (distC[U.C - pour] > U.dist + pour)
                    {
                        ok = true;
                        distC[U.C - pour] = U.dist + pour;
                    }
                    if (ok)
                    {
                        q.add(V);
                    }
                }

                pour = Math.min(U.C, B - U.B);
                if (pour > 0)
                {
                    Vertex V = new Vertex(U.A, U.B + pour, U.C - pour, U.dist + pour);
                    boolean ok = false;
                    if (distB[U.B + pour] > U.dist + pour)
                    {
                        ok = true;
                        distB[U.B + pour] = U.dist + pour;
                    }
                    if (distC[U.C - pour] > U.dist + pour)
                    {
                        ok = true;
                        distC[U.C - pour] = U.dist + pour;
                    }
                    if (ok)
                    {
                        q.add(V);
                    }
                }
            }
        }
        for (int i = D; i >= 0; i--)
        {
            if (distA[i] != Integer.MAX_VALUE || distB[i] != Integer.MAX_VALUE || distC[i] != Integer.MAX_VALUE)
            {
                target = i;
                totalPour = Math.min(distA[i], Math.min(distB[i], distC[i]));
                return;
            }
        }
    }

    class Vertex implements Comparable<Vertex>
    {
        int A;
        int B;
        int C;
        int dist;

        public Vertex(int A, int B, int C, int dist)
        {
            this.A = A;
            this.B = B;
            this.C = C;
            this.dist = dist;
        }

        public int compareTo(Vertex that)
        {
            int distDiff = Integer.compare(this.dist, that.dist);
            if (distDiff == 0)
            {
                int ADiff = Integer.compare(this.A, that.A);
                if (ADiff == 0)
                {
                    int BDiff = Integer.compare(this.B, that.B);
                    return BDiff != 0 ? BDiff : Integer.compare(this.C, that.C);
                }
                return ADiff;
            }
            return distDiff;
        }

        public String toString()
        {
            return A + " " + B + " " + C + " dist = " + dist;
        }

    }
}
