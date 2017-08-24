package UVa.Blocks.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 19/07/2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
//        demo.test1();
        demo.go();
    }

    public void go() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int V = Integer.parseInt(st.nextToken());
            int best = Integer.MAX_VALUE;
            for (int i = 1; i <= V; i++)
            {
                for (int j = i; j <= V; j++)
                {
                    for (int k = j; k <= V; k++)
                    {
                        for (int l = k; l <= V; l++)
                        {
                            for (int m = l; m <= V; m++)
                            {
                                for (int n = m; n <= V; n++)
                                {
                                    if (i + j + k + l + m + n == V)
                                    {
                                        best = Math.max(best, i * j + j * k + k * l + l * m + m * n + n * i);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(best);
        }
    }

    public void solve() throws IOException
    {
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int V = Integer.parseInt(st.nextToken());
            int best = Integer.MAX_VALUE;
            for (int a = 1; a <= V; a++)
            {
                for (int b = a; b <= V; b++)
                {
                    int c = V / a / b;
                    int r = V % (a * b);
                    if (r == 0)
                    {
                        best = Math.min(best, (a * b + b * c + a * c) * 2);
                    }
                }
            }
            System.out.println(best);
        }

    }
}
