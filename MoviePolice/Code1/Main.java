package UVa.MoviePolice.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 18/07/2017.
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

    public void test()
    {
        Random r = new Random();
        int n = r.nextInt(7);
        System.out.println(n + " " + 1);
        for (int i = 0; i < n + 1; i++)
        {
            int len = r.nextInt(10) + 5;
            if (i == n)
            {
                len -= 3;
            }
            String s = "";
            for (int j = 0; j < len; j++)
            {
                int num = r.nextInt();
                if (num % 2 == 0)
                {
                    s += "0";
                } else
                {
                    s += "1";
                }
            }
            System.out.println(s);
        }
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
            int M = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            String[] m = new String[M];
            for (int i = 0; i < M; i++)
            {
                m[i] = in.readLine().trim();
            }

            for (int q = 0; q < Q; q++)
            {
                int best = 0;
                int score = Integer.MAX_VALUE;
                String s = in.readLine().trim();
                for (int i = 0; i < M; i++)
                {
                    if (m[i].length() >= s.length())
                    {
                        for (int start = 0; start + s.length() <= m[i].length(); start++)
                        {
                            int now = 0;
                            for (int j = start, k = 0; j < m[i].length() && k < s.length(); j++, k++)
                            {
                                if (s.charAt(k) != m[i].charAt(j))
                                {
                                    now++;
                                }
                            }
                            if (now < score)
                            {
                                score = now;
                                best = i + 1;
                            }
                        }
                    }
                }
                System.out.println(best);
            }
        }

    }
}
