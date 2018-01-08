package UVa.IlGiocoDellX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 22-Jan-16.
 */
public class Main
{
    char map[][];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 0;
        while (true)
        {
            int size = Integer.parseInt(br.readLine());
            if (size == 0)
            {
                break;
            }
            map = new char[size][size];
            for (int i = 0; i < size; i++)
            {
                String line = br.readLine();
                for (int j = 0; j < map[i].length; j++)
                {
                    map[i][j] = line.charAt(j);
                }
            }
            boolean isBlackWinner = false;
            for (int i = 0; i < map[0].length; i++)
            {
                if (map[0][i] == 'b')
                {
                    if (visitNearby(0, i))
                    {
                        isBlackWinner = true;
                        break;
                    }
                }
            }
            if (isBlackWinner)
            {
                System.out.println((++test) + " B");
            }
            else
            {
                System.out.println((++test) + " W");
            }
        }
    }

    public boolean visitNearby(int x, int y)
    {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] != 'b')
        {
            return false;
        }
        if (x == map.length - 1 && map[x][y] == 'b')
        {
            return true;
        }
        map[x][y] = 'x';
        return visitNearby(x - 1, y - 1) || visitNearby(x - 1, y) || visitNearby(x, y - 1) || visitNearby(x, y + 1) || visitNearby(x + 1, y) || visitNearby(x + 1, y + 1);
    }
}
