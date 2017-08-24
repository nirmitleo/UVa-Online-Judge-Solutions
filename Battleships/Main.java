package UVa.Battleships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 23-Jan-16.
 */
public class Main
{
    int size;
    char map[][];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++)
        {
            size = Integer.parseInt(br.readLine());
            map = new char[size][size];
            for (int i = 0; i < map.length; i++)
            {
                String tempLine = br.readLine();
                for (int j = 0; j < map[i].length; j++)
                {
                    map[i][j] = tempLine.charAt(j);
                }
            }

            int count = 0;
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[i].length; j++)
                {
                    if (map[i][j] == 'x')
                    {
                        count++;
                        count(i, j);
                    }
                }
            }
            System.out.println("Case " + t + ": " + count);
        }
    }

    public void count(int x, int y)
    {
        if (x < 0 || y < 0 || x >= size || y >= size || map[x][y] == '.')
        {
            return;
        }
        map[x][y] = '.';
        count(x - 1, y);
        count(x + 1, y);
        count(x, y + 1);
        count(x, y - 1);
    }


}
