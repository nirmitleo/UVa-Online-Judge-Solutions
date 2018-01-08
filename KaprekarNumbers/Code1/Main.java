package UVa.KaprekarNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 04/07/2017.
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
        int N = 40000;
        int M = 16;
        ArrayList<Integer> K = new ArrayList<Integer>();
        K.add(9);
        for (int i = 10, j = 0; i <= N; i++)
        {
            String num = (i * 1L * i) + "";
            for (int k = 1; k < num.length() - 1; k++)
            {
                String a = num.substring(0, k);
                String b = num.substring(k);
                if (a.length() > 0 && b.length() > 0)
                {
                    int p = Integer.parseInt(a);
                    int q = Integer.parseInt(b);
                    if (p > 0 && q > 0 && p + q == i)
                    {
                        K.add(i);
                    }
                }
            }
        }
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int start = Math.min(a, b);
            int end = Math.max(a, b);

            int count = 0;
            StringBuilder sb = new StringBuilder("case #" + t + "\n");
            for (int i = 0; i < K.size(); i++)
            {
                int num = K.get(i);
                if (num >= start && num <= end)
                {
                    count++;
                    sb.append(num + "\n");
                }
            }
            if (count == 0)
            {
                sb.append("no kaprekar numbers\n");
            }
            if (t == test)
            {
                System.out.print(sb);
            }
            else
            {
                System.out.println(sb);
            }

        }
    }
}
