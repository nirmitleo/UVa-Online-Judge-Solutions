package UVa.AncientMessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 24-Jan-16.
 */

public class Main
{
    int count;
    int row;
    int col;
    char map[][];
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 1;
        while (true)
        {
            count = 0;
            tokens = br.readLine().split(" ");
            row = Integer.parseInt(tokens[0]);
            col = (Integer.parseInt(tokens[1]) * 4);
            if (row == 0 && col == 0)
            {
                break;
            }
            map = new char[row][col];
            for (int i = 0; i < map.length; i++)
            {
                String tempLine = toBinary(br.readLine());
                for (int j = 0; j < map[i].length; j++)
                {
                    map[i][j] = tempLine.charAt(j);
                }
            }
            //System.out.println("Original map");
            //printMap();
            boolean isBackgroundRemoved = false;
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[i].length; j++)
                {
                    if (map[i][j] == '0')
                    {
                        fill(i, j, map[i][j]);
                        isBackgroundRemoved = true;
                        break;
                    }
                }
                if (isBackgroundRemoved)
                {
                    break;
                }
            }
            //System.out.println("Background removed");
            //printMap();
            String ans = "";
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[i].length; j++)
                {
                    if (map[i][j] == '1')
                    {
                        secondFill(i, j, map[i][j]);
                        //System.out.println(count);
                        switch (count)
                        {
                            case 0:
                                ans += "W";
                                break;
                            case 1:
                                ans += "A";
                                break;
                            case 2:
                                ans += "K";
                                break;
                            case 3:
                                ans += "J";
                                break;
                            case 4:
                                ans += "S";
                                break;
                            case 5:
                                ans += "D";
                                break;
                        }
                        count = 0;
                    }
                }
            }
            System.out.println("Case " + (test++) + ": " + ans);
            //System.out.println("final map");
            //printMap();
        }
    }


    public void printMap()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public String toBinary(String input)
    {
        String ans = "";
        for (int i = 0; i < input.length(); i++)
        {
            switch (input.charAt(i))
            {
                case '0':
                    ans += "0000";
                    break;
                case '1':
                    ans += "0001";
                    break;
                case '2':
                    ans += "0010";
                    break;
                case '3':
                    ans += "0011";
                    break;
                case '4':
                    ans += "0100";
                    break;
                case '5':
                    ans += "0101";
                    break;
                case '6':
                    ans += "0110";
                    break;
                case '7':
                    ans += "0111";
                    break;
                case '8':
                    ans += "1000";
                    break;
                case '9':
                    ans += "1001";
                    break;
                case 'a':
                    ans += "1010";
                    break;
                case 'b':
                    ans += "1011";
                    break;
                case 'c':
                    ans += "1100";
                    break;
                case 'd':
                    ans += "1101";
                    break;
                case 'e':
                    ans += "1110";
                    break;
                case 'f':
                    ans += "1111";
                    break;
            }
        }
        return ans;
    }

    public void secondFill(int x, int y, char color)
    {
        if (x < 0 || y < 0 || x >= row || y >= col || map[x][y] == '5')
        {
            return;
        }
        if (map[x][y] == '0')
        {
            count++;
            fill(x, y, map[x][y]);
        }
        else
        {
            map[x][y] = '5';
            secondFill(x - 1, y, color);
            secondFill(x + 1, y, color);
            secondFill(x, y - 1, color);
            secondFill(x, y + 1, color);
        }
    }


    public void fill(int x, int y, char color)
    {
        if (x < 0 || y < 0 || x >= row || y >= col || map[x][y] == '5')
        {
            return;
        }
        if (map[x][y] == color)
        {
            map[x][y] = '5';
            fill(x - 1, y, color);
            fill(x + 1, y, color);
            fill(x, y - 1, color);
            fill(x, y + 1, color);
        }
    }
}
