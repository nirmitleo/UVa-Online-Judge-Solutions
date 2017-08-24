package UVa.FillTheSquare.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[][] map = new char[n][n];
            for (int i = 0; i < n; i++)
            {
                line = in.readLine().trim();
                map[i] = line.toCharArray();
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (map[i][j] == '.')
                    {
                        for (char a = 'A'; a <= 'Z'; a++)
                        {
                            if (i - 1 >= 0 && map[i - 1][j] == a)
                            {
                                continue;
                            }
                            if (j + 1 < n && map[i][j + 1] == a)
                            {
                                continue;
                            }
                            if (i + 1 < n && map[i + 1][j] == a)
                            {
                                continue;
                            }
                            if (j - 1 >= 0 && map[i][j - 1] == a)
                            {
                                continue;
                            }
                            map[i][j] = a;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case " + t + ":");
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

    }
}
