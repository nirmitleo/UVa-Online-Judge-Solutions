package UVa.MagicNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 15/07/2017.
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
        in.readLine();
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
            long N = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder("");
            for (long s2 = 1; ; s2++)
            {
                long s1 = s2 * N;
                if (s1 >= 1e10)
                {
                    break;
                }
                if (check(s1, s2))
                {
//                    set.add(new Vertex(s1, s2));
                    sb.append(s1 + " / " + s2 + " = " + N);
                    sb.append("\n");
                }
            }
//            String result = sb.toString().trim();
            if (t == test)
            {
                System.out.print(sb);
            } else
            {
                System.out.println(sb);
            }
        }
    }


    public boolean check(long s1, long s2)
    {
        boolean[] num = new boolean[10];
        while (s1 > 0)
        {
            int d = (int) (s1 % 10);
            if (num[d])
            {
                return false;
            }
            num[d] = true;
            s1 /= 10;
        }
        num = new boolean[10];
        while (s2 > 0)
        {
            int d = (int) (s2 % 10);
            if (num[d])
            {
                return false;
            }
            num[d] = true;
            s2 /= 10;
        }
        return true;
    }
}
