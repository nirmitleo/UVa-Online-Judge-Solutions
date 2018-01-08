package UVa.PolyominoComposer.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by DELL on 01-May-16.
 */
public class Main
{
    private ArrayList<Point> trace;
    private boolean parent[][];
    private boolean child[][];
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
        while (true)
        {
            trace = new ArrayList<Point>();
            tokens = br.readLine().trim().split("[ ]+");
            int parentRow = Integer.parseInt(tokens[0]);
            int childRow = Integer.parseInt(tokens[1]);

            if (parentRow == childRow && parentRow == 0)
            {
                return;
            }

            parent = new boolean[parentRow][parentRow];
            child = new boolean[childRow][childRow];

            for (int i = 0; i < parent.length; i++)
            {
                line = br.readLine().trim();
                for (int j = 0; j < line.length(); j++)
                {
                    parent[i][j] = line.charAt(j) == '*';
                }
            }

            for (int i = 0; i < child.length; i++)
            {
                line = br.readLine().trim();
                for (int j = 0; j < line.length(); j++)
                {
                    child[i][j] = line.charAt(j) == '*';
                }
            }

            Point startSmall = getStartPosition(child);
            for (int i = 0; i < child.length; i++)
            {
                for (int j = 0; j < child.length; j++)
                {
                    if (child[i][j])
                    {
                        Point temp = new Point(i, j);
                        trace.add(temp.subtract(startSmall));
                        child[temp.x][temp.y] = false;
                    }
                }
            }

            boolean result = traceParent();
            if (!result || getStartPosition(parent) != null)
            {
                System.out.println("0");
            } else
            {
                System.out.println("1");
            }
        }
    }

    public boolean traceParent()
    {
        for (int i = 0; i < parent.length; i++)
        {
            for (int j = 0; j < parent.length; j++)
            {
                if (parent[i][j])
                {
                    for (int k = 0; k < trace.size(); k++)
                    {
                        Point temp = trace.get(i);
                        int x = temp.x + i;
                        int y = temp.y + j;
                        if (!(x >= 0 && y >= 0 && x < parent.length && y < parent.length) || !parent[x][y])
                        {
                            return false;
                        }
                        parent[x][y] = false;
                    }
                }
            }
        }
        return true;
    }


    public Point getStartPosition(boolean image[][])
    {
        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j < image.length; j++)
            {
                if (image[i][j])
                {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
}

class Point implements Comparable<Point>
{
    int x;
    int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point that)
    {
        int xDiff = this.x - that.x;
        if (xDiff == 0)
        {
            return this.y - that.y;
        }
        return xDiff;
    }

    public Point subtract(Point that)
    {
        return new Point(this.x - that.x, this.y - that.y);
    }

    public Point add(Point that)
    {
        return new Point(this.x + that.x, this.y + that.y);
    }

    public String toString()
    {
        return "Player x = " + this.x + ",  y = " + this.y;
    }
}