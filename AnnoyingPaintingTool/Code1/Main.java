package UVa.AnnoyingPaintingTool.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 21/06/2017.
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
        //demo.testG();
    }

    public void testG()
    {
        Random r = new Random();
        int N = r.nextInt(5) + 1;
        int row = r.nextInt(3) + 1;
        int col = r.nextInt(3) + 1;
        System.out.println(N + " " + N + " " + row + " " + col);
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                System.out.print(r.nextInt(2));
            }
            System.out.println();
        }
        System.out.println(0 + " " + 0 + " " + 0 + " " + 0 + " ");
    }

    public void solve() throws IOException
    {
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            if (R + C + row + col == 0)
            {
                return;
            }

            int[][] map = new int[R][C];
            int[][] now = new int[R][C];
            for (int i = 0; i < R; i++)
            {
                st = new StringTokenizer(in.readLine());
                line = st.nextToken();
                for (int j = 0; j < C; j++)
                {
                    if (line.charAt(j) == '1')
                    {
                        map[i][j] = 1;
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i + row <= R; i++)
            {
                for (int j = 0; j + col <= C; j++)
                {
                    if (map[i][j] != now[i][j])
                    {
                        count++;
                        for (int r = i; r < i + row; r++)
                        {
                            for (int c = j; c < j + col; c++)
                            {
                                now[r][c] ^= 1;
                            }
                        }
                    }
                }
            }
            if (equals(map, now))
            {
                result = Math.min(result, count);
            }
            for (int j = 0; j + col <= C; j++)
            {
                for (int i = 0; i + row <= R; i++)
                {
                    if (map[i][j] != now[i][j])
                    {
                        count++;
                        for (int r = i; r < i + row; r++)
                        {
                            for (int c = j; c < j + col; c++)
                            {
                                now[r][c] ^= 1;
                            }
                        }
                    }
                }
            }
            if (equals(map, now))
            {
                result = Math.min(result, count);
            }
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);

        }

    }

    public boolean equals(int map[][], int now[][])
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                if (map[i][j] != now[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
