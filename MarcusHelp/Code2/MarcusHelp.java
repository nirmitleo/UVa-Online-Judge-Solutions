package UVa.MarcusHelp.Code2;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.TreeSet;

public class MarcusHelp
{
    private int row;
    private int col;
    private char[][] map;
    private String s = "IEHOVA#";
    private TreeSet<String> set;

    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            row = in.nextInt();
            col = in.nextInt();
            map = new char[row][col];

            int sx = -1;
            int sy = -1;
            int ex = -1;
            int ey = -1;
            set = new TreeSet<>();
            for (int i = 0; i < row; i++)
            {
                String b = in.next();
                for (int j = 0; j < col; j++)
                {
                    map[i][j] = b.charAt(j);
                    if (map[i][j] == '#')
                    {
                        ex = i;
                        ey = j;
                    } else if (map[i][j] == '@')
                    {
                        sx = i;
                        sy = j;
                    }
                }
            }
            go(0, sx, sy, "");
            out.println(set.pollFirst().trim());
        }
    }

    private void go(int pos, int x, int y, String p)
    {
        if (pos == s.length())
        {
            set.add(p);
            return;
        }
        char ch = s.charAt(pos);
        if (x - 1 >= 0 && map[x - 1][y] == ch)
        {
            go(pos + 1, x - 1, y, p + " forth");
        }
        if (y + 1 < col && map[x][y + 1] == ch)
        {
            go(pos + 1, x, y + 1, p + " right");
        }
        if (y - 1 >= 0 && map[x][y - 1] == ch)
        {
            go(pos + 1, x, y - 1, p + " left");
        }
    }
}
