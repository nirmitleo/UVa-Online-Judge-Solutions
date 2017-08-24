package UVa.AnotherNewFunction.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 13/07/2017.
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
        int N = (int) 2e6;
        int[] e = new int[N + 1];
        int[] d = new int[N + 1];
        int[] D = new int[N + 1];
        for (int i = 0; i < N + 1; i++)
        {
            e[i] = i;
        }

        for (int i = 2; i <= N; i++)
        {
            if (e[i] == i)
            {
                for (int j = i; j <= N; j += i)
                {
                    e[j] -= e[j] / i;
                }
            }
//            System.out.println(i);
            int count = 1;
            int now = i;
            while (now > 1)
            {
                now = e[now];
                if (d[now] != 0)
                {
                    count += d[now];
                    break;
                }
            }
            d[i] = count;
            D[i] = D[i - 1] + d[i];
        }
//        System.out.println("done");
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(D[right] - D[left - 1]);
        }

    }
}
