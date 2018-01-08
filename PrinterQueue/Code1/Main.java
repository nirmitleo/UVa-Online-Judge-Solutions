package UVa.PrinterQueue.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 11/06/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] p = new int[10];
            LinkedList<Item> q = new LinkedList<>();
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
            {
                int pp = Integer.parseInt(st.nextToken());
                p[pp]++;
                q.addLast(new Item(i, pp));
            }

            int time = 1;
            outer:
            for (; ; )
            {
                Item job = q.pollFirst();
                for (int i = job.p + 1; i <= 9; i++)
                {
                    if (p[i] > 0)
                    {
                        q.addLast(job);
                        continue outer;
                    }
                }

                if (job.id == m)
                {
                    break;
                }
                p[job.p]--;
                time++;
            }
            System.out.println(time);
        }
    }

    class Item
    {
        int id;
        int p;

        public Item(int id, int p)
        {
            this.id = id;
            this.p = p;
        }
    }
}
