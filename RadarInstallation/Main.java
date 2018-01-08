package UVa.RadarInstallation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DELL on 20-Mar-16.
 */
public class Main
{
    int n;
    int d;
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 0;
        while (true)
        {
            tokens = br.readLine().trim().split("[ ]+");
            n = Integer.parseInt(tokens[0]);
            d = Integer.parseInt(tokens[1]);

            if (n == d && d == 0)
            {
                break;
            }
            Point a[] = new Point[n];
            for (int i = 0; i < a.length; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                a[i] = new Point(x, y);
            }
            Arrays.sort(a);


            int count = 0;
            int connected = 0;
            while (connected < a.length)
            {
                int bestX = 0;
                ArrayList<Point> bestCovered = new ArrayList<Point>();
                for (int i = a[0].x - 1; i <= a[a.length - 1].x + 1; i++)
                {
                    int x = i;
                    int y = 0;
                    ArrayList<Point> covered = new ArrayList<Point>();
                    for (int j = 0; j < a.length; j++)
                    {
                        if (!a[j].isVisited && isWithinReach(x, y, a[j].x, a[j].y))
                        {
                            covered.add(a[j]);
                        }
                    }
                    if (bestCovered.size() < covered.size())
                    {
                        bestX = i;
                        bestCovered = covered;
                    }
                }
                if (bestCovered.size() == 0)
                {
                    count = -1;
                    break;
                }
                System.out.println(bestCovered.size() + " from x = " + bestX);
                for (int i = 0; i < bestCovered.size(); i++)
                {
                    Point temp = bestCovered.get(i);
                    System.out.println(temp.x + " " + temp.y);
                    temp.isVisited = true;
                }
                connected += bestCovered.size();
                count++;
            }
            if (test == 0)
            {
                System.out.print("Case " + (++test) + ": " + count);
            } else
            {
                System.out.print("\nCase " + (++test) + ": " + count);
            }
            if (br.readLine() == null)
            {
                break;
            }
        }
    }


    public boolean isWithinReach(int x, int y, int xx, int yy)
    {
        return Math.sqrt(Math.pow(x - xx, 2) + Math.pow(y - yy, 2)) <= d;
    }
}

class Point implements Comparable<Point>
{
    int x;
    int y;
    boolean isVisited;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point that)
    {
        int xDiff = this.x - that.x;
        if (xDiff < 0)
        {
            return -1;
        } else if (xDiff > 0)
        {
            return +1;
        }
        return this.y - that.y;
    }
}
