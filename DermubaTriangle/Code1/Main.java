package UVa.DermubaTriangle.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 04/07/2017.
 */
public class Main
{
    private int N = 46340;
    private int MAX = 2147483647;
    private double S = 1 / Math.sqrt(3);
    private double B = S * 2;

    private long[] start;
    private long[] end;
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }


    public void solve() throws IOException
    {
        start = new long[N + 1];
        end = new long[N + 1];
        for (int i = 0; i <= N; i++)
        {
            start[i] = i * 1L * i;
            end[i] = start[i] + (2 * i);
        }
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            Long source = Math.min(a, b);
            Long sink = Math.max(a, b);

            double x1 = getX(source);
            double y1 = getY(source);

            double x2 = getX(sink);
            double y2 = getY(sink);
            System.out.println(x1 + " " + y1);
            System.out.println(x2 + " " + y2);

            System.out.println(Math.hypot(x1 - x2, y1 - y2));
        }
    }

    public double getX(long pos)
    {
        int row = getRow(pos);
        long mid = start[row] + end[row];
        mid /= 2;
        return (pos - mid) * 2 * S;
    }

    public double getY(long pos)
    {
        long now = 0;
        double dist = 0;
        int row = getRow(pos);
        while (true)
        {
            int nowRow = getRow(now);
            if (nowRow == row)
            {
                return dist;
            }
            if (isUp(now, nowRow))
            {
                dist += 2 * S;
            } else
            {
                dist += 2 * B;
            }
            now = now + (nowRow + 1) * 2;
        }
    }


    public boolean isUp(long pos, int row)
    {
        return start[row] % 2 == pos % 2;
    }

    public int getRow(long pos)
    {
        if (pos == 0)
        {
            return 0;
        }
        int low = -1;
        int high = N + 1;
        while (high - low > 1)
        {
            int mid = low + (high - low) / 2;

            if (start[mid] <= pos)
            {
                low = mid;
            } else
            {
                high = mid;
            }
        }
        return low;
    }
}
