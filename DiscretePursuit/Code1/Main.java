package UVa.DiscretePursuit.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 22/06/2017.
 */
public class Main
{

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
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int A = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Pair T = new Pair(0, 0, A, 0, 0);
            Pair start = new Pair(0, 0, 0, 0, 0);

            int now = 0;
            LinkedList<Pair> q = new LinkedList<>();
            q.add(start);
            while (!q.isEmpty())
            {
                Pair pos = q.poll();
                if (now == pos.level)
                {
                    if (pos.x == T.x && pos.y == T.y)
                    {
                        System.out.println(pos.level);
                        break;
                    } else
                    {
                        Pair best = null;
                        for (int i = -1; i <= 1; i++)
                        {
                            for (int j = -1; j <= 1; j++)
                            {
                                int cu = pos.x - pos.px;
                                int cv = pos.y - pos.py;
                                int nextX = pos.x + cu + i;
                                int nextY = pos.y + cv + j;
                                Pair next = new Pair(pos.x, pos.y, nextX, nextY, pos.level + 1);

                                if (best == null)
                                {
                                    best = next;
                                } else
                                {
                                    int diffX = Math.abs(nextX - (T.x + u));
                                    if (diffX <= Math.abs(best.x - (T.x + u)))
                                    {
                                        if (diffX < Math.abs(best.x - (T.x + u)))
                                        {
                                            best = next;
                                        } else
                                        {
                                            int diffY = Math.abs(nextY - (T.y + v));
                                            if (diffY <= Math.abs(best.y - (T.y + v)))
                                            {
                                                if (diffY <= Math.abs(best.y - (T.y + v)))
                                                {
                                                    best = next;
                                                } else
                                                {
                                                    System.out.println("hi");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        q.addLast(best);
                    }
                } else
                {
                    T.x += u;
                    T.y += v;
                    q.addFirst(pos);
                    now = pos.level;
                    //System.out.println("level = " + now);
                }
            }
        }

    }

    class Pair
    {
        int px;
        int py;
        int x;
        int y;
        int level;

        public Pair(int px, int py, int x, int y, int level)
        {
            this.px = px;
            this.py = py;
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public String toString()
        {
            return "Prev x = " + px + " Prev y = " + py + "\n" + "Current x = " + x + " Current y = " + y;
        }
    }
}
