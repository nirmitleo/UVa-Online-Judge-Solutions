package UVa.GasStation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DELL on 21-Mar-16.
 */
public class Main
{
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String r[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();

    }

    public void solve() throws IOException
    {
        while (true)
        {
            tokens = br.readLine().split("[ ]+");
            int length = Integer.parseInt(tokens[0]);
            int n = Integer.parseInt(tokens[1]);
            if (length == 0 && n == 0)
            {
                break;
            }
            ArrayList<Station> queue = new ArrayList<Station>();
            for (int i = 0; i < n; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int position = Integer.parseInt(tokens[0]);
                int radius = Integer.parseInt(tokens[1]);

                queue.add(new Station(position, radius));
            }
            Collections.sort(queue);

            int start = 0;
            int end = length;
            int count = n;

            while (start < end)
            {
                Station best = null;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < queue.size(); i++)
                {
                    Station temp = queue.get(i);
                    if (!temp.isVisited)
                    {
                        int left = temp.left;
                        int right = temp.right;
                        if (left <= start && Math.abs(start - left) <= min && right > max)
                        {
                            max = right;
                            min = start - left;
                            best = temp;
                        }
                    }
                }
                if (best == null)
                {
                    count = -1;
                    break;
                }
                best.isVisited = true;
                start = best.right;
                count--;
            }
            System.out.println(count);
        }
    }

}

class Station implements Comparable<Station>
{
    int left;
    int right;
    boolean isVisited;

    public Station(int position, int radius)
    {
        this.left = position - radius;
        this.right = position + radius;
    }

    public int compareTo(Station that)
    {
        int leftDiff = this.left - that.left;
        if (leftDiff < 0)
        {
            return -1;
        } else if (leftDiff > 0)
        {
            return +1;
        }
        return that.right - this.right;
    }
}
