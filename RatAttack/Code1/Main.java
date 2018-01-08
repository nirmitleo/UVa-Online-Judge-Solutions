package UVa.RatAttack.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 19/07/2017.
 */
public class Main
{
    private final static int N = 1025;
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            if (line.trim().length() == 0)
            {
                line = in.readLine();
                if (line == null || line.trim().length() == 0)
                {
                    return;
                }
            }
            st = new StringTokenizer(line);
            int d = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] killed = new int[N][N];

            int X = Integer.MAX_VALUE;
            int Y = Integer.MAX_VALUE;
            int best = -1;
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());

                int x1 = Math.max(0, x - d);
                int y1 = Math.max(0, y - d);
                int x2 = Math.min(N - 1, x + d);
                int y2 = Math.min(N - 1, y + d);
                for (int xx = x1; xx <= x2; xx++)
                {
                    for (int yy = y1; yy <= y2; yy++)
                    {
                        killed[xx][yy] += count;
                        if (best <= killed[xx][yy])
                        {
                            if (best < killed[xx][yy])
                            {
                                best = killed[xx][yy];
                                X = xx;
                                Y = yy;
                            }
                            if (best == killed[xx][yy])
                            {
                                if (xx < X)
                                {
                                    X = xx;
                                    Y = yy;
                                    continue;
                                }
                                if (xx == X && yy < Y)
                                {
                                    Y = yy;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(X + " " + Y + " " + best);


        }

    }


}
