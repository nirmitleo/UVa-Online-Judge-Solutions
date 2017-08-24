package UVa.Continents;

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
    char map[][];

    char fillSymbol;

    String tokens[];

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    BufferedReader br;

    public void solve() throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        boolean isDimensionsRead = false;
        boolean isMapRead = false;
        while ((line = br.readLine()) != null)
        {
            if (!isDimensionsRead)
            {
                tokens = line.split(" ");
                row = Integer.parseInt(tokens[0]);
                col = Integer.parseInt(tokens[1]);
                map = new char[row][col];
                isDimensionsRead = true;
                continue;
            }
            if (!isMapRead)
            {
                for (int i = 0; i < map.length; i++)
                {

                    String tempLine = (i == 0) ? line : br.readLine();
                    for (int j = 0; j < map[i].length; j++)
                    {
                        map[i][j] = tempLine.charAt(j);
                    }
                }
                isMapRead = true;
                continue;
            }
            if (line.equals(""))
            {
                isDimensionsRead = false;
                isMapRead = false;
                continue;
            }
            tokens = line.split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            fillSymbol = map[x][y];
            fill(x, y);
            int count = 0;
            int max = 0;
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[i].length; j++)
                {
                    if (map[i][j] == fillSymbol)
                    {
                        count = fill(i, j);
                        max = Math.max(count, max);
                        // printOut();
                    }
                }
            }
            System.out.println(max);
        }
    }


    public void printOut()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int fill(int x, int y)
    {
        /*x = (x < 0) ? row - 1 : x;
        x = (x >= row) ? 0 : x;*/
        y = (y < 0) ? col - 1 : y;
        y = (y >= col) ? 0 : y;
        if (x < 0 || x >= row || map[x][y] != fillSymbol)
        {
            return 0;
        }
        map[x][y] = ' ';
        return 1 + fill(x, y + 1) + fill(x, y - 1) + fill(x - 1, y) + fill(x + 1, y);
    }
}
