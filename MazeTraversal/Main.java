package UVa.MazeTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 19-Jan-16.
 */
public class Main
{
    int row;
    int col;
    boolean map[][];
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
        while (test-- > 0)
        {
            tokens = br.readLine().split(" ");
            row = Integer.parseInt(tokens[0]);
            col = Integer.parseInt(tokens[1]);
            map = new boolean[row][col];

            for (int i = 0; i < map.length; i++)
            {
                String tempLine = br.readLine();
                for (int j = 0; j < tempLine.length(); j++)
                {
                    map[i][j] = tempLine.charAt(j) != '*';
                }
            }

            tokens = br.readLine().split(" ");
            row = Integer.parseInt(tokens[0]) - 1;
            col = Integer.parseInt(tokens[1]) - 1;
            int orientation = 0;
            String line = br.readLine();
            while (!line.equals(""))
            {
                boolean isEnd = false;

                for (int i = 0; i < line.length(); i++)
                {
                    char instruction = line.charAt(i);
                    if (instruction != ' ')
                    {
                        if (instruction == 'Q')
                        {
                            isEnd = true;
                            break;
                        }
                        if (instruction == 'R')
                        {
                            orientation = (orientation + 1) % 4;
                        }
                        else if (instruction == 'L')
                        {
                            orientation = (orientation + 4 - 1) % 4;
                        }
                        else if (instruction == 'F')
                        {
                            if (orientation == 0 && row - 1 >= 0 && map[row - 1][col])
                            {
                                row = row - 1;
                            }
                            else if (orientation == 1 && col + 1 < map[0].length && map[row][col + 1])
                            {
                                col = col + 1;
                            }
                            else if (orientation == 2 && row + 1 < map.length && map[row + 1][col])
                            {
                                row = row + 1;
                            }
                            else if (orientation == 3 && col - 1 >= 0 && map[row][col - 1])
                            {
                                col = col - 1;
                            }
                        }
                    }
                }
                if (isEnd)
                {
                    break;
                }
                line = br.readLine();
            }
            char oo = 'N';
            switch (orientation)
            {
                case 1:
                    oo = 'E';
                    break;
                case 2:
                    oo = 'S';
                    break;
                case 3:
                    oo = 'W';
                    break;
            }
            System.out.println((row + 1) + " " + (col + 1) + " " + oo);
        }
    }

    public int getOrientation(char o)
    {
        switch (o)
        {
            case 'N':
                return 0;
            case 'E':
                return 1;
            case 'S':
                return 2;
            case 'W':
                return 3;
        }
        return -1;
    }
}
