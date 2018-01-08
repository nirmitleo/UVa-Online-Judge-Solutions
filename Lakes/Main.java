package UVa.Lakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by DELL on 22-Jan-16.
 */
public class Main
{

    int R;
    int C;
    boolean map[][];
    ArrayList<String> inputString;

    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        br.readLine();
        for (int t = 1; t <= test; t++)
        {
            tokens = br.readLine().split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);

            String line = "";
            inputString = new ArrayList<String>();

            R = 0;
            C = 0;

            while (!(line = br.readLine()).equals(""))
            {
                R++;
                inputString.add(line);
            }
            C = inputString.get(0).length();
            map = new boolean[R][C];
            for (int i = 0; i < map.length; i++)
            {
                String tempLine = inputString.get(i);
                for (int j = 0; j < map[i].length; j++)
                {
                    map[i][j] = tempLine.charAt(j) == '0';
                }
            }
            if (t != test)
            {
                System.out.println(count(row, col) + "\n");
            }
            else
            {
                System.out.println(count(row, col));
            }
        }
    }

    public int count(int x, int y)
    {
        if (x < 0 || y < 0 || x >= R || y >= C || !map[x][y])
        {
            return 0;
        }
        map[x][y] = false;
        return 1 + count(x - 1, y) + count(x - 1, y + 1) + count(x, y + 1) + count(x + 1, y + 1) + count(x + 1, y) + count(x + 1, y - 1) + count(x, y - 1) + count(x - 1, y - 1);
    }

}
