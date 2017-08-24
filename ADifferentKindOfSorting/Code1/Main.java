package UVa.ADifferentKindOfSorting.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/07/2017.
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
        int N = 2000000;
        Pair[] f = new Pair[N + 1];
        for (int i = 0; i < N + 1; i++)
        {
            f[i] = new Pair(i, 1);
        }
        for (int i = 2; i < N + 1; i++)
        {
            int num = i;
            for (int j = 2; j * j <= num; j++)
            {
                int count = 0;
                while (num % j == 0)
                {
                    count++;
                    num /= j;
                }
                if (count > 0)
                {
                    f[i].f += count;
                }
            }
            if (num > 1)
            {
                f[i].f += 1;
            }
        }
        Arrays.sort(f);

        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            System.out.println("Case " + t + ": " + f[n].n);
        }


    }

    class Pair implements Comparable<Pair>
    {
        int n;
        int f;

        public Pair(int n, int f)
        {
            this.n = n;
            this.f = f;
        }

        public int compareTo(Pair that)
        {
            int fDiff = Integer.compare(this.f, that.f);
            return fDiff != 0 ? fDiff : Integer.compare(this.n, that.n);
        }
    }
}
