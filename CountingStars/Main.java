package UVa.CountingStars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 23-Jan-16.
 */
public class Main
{
    int row;
    int col;
    boolean map[][];

    String line;
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String r[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while (true)
        {
            tokens = br.readLine().split(" ");
            row = Integer.parseInt(tokens[0]);
            col = Integer.parseInt(tokens[1]);
            if (row == 0 && col == 0)
            {
                break;
            }
            map = new boolean[row][col];
            for (int i = 0; i < map.length; i++)
            {
                String tempLine = br.readLine();
                for (int j = 0; j < map[i].length; j++)
                {
                    map[i][j] = tempLine.charAt(j) == '*';
                }
            }
            int count = 0;
            int tempCount = 0;

            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[i].length; j++)
                {
                    if (map[i][j])
                    {
                        tempCount = count(i, j);
                        count = (tempCount == 1) ? count + 1 : count;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public int count(int x, int y)
    {
        if (x < 0 || y < 0 || x >= row || y >= col || !map[x][y])
        {
            return 0;
        }
        map[x][y] = false;
        return 1 + count(x - 1, y) + count(x - 1, y + 1) + count(x, y + 1) + count(x + 1, y + 1) + count(x + 1, y) + count(x + 1, y - 1) + count(x, y - 1) + count(x - 1, y - 1);
    }
}
