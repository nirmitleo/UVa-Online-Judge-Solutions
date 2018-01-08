package UVa.KMultipleFreeSet.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 03/07/2017.
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
//        demo.test1();
    }

    public void solve() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int D = N / K;
            int result = N - D;
            TreeSet<Integer> set = new TreeSet<Integer>();
            for (int i = 1; i <= D; i++)
            {
                set.add(i * K);
            }
            int count = 0;
            while (!set.isEmpty())
            {
                int n = set.pollLast();
                if (set.contains(n / K))
                {
                    count++;
                    result++;
                    set.remove(n / K);
                }
            }
            System.out.println(result + " count = " + count);
        }
    }
}
