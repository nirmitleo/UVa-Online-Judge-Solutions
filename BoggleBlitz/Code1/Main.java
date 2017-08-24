package UVa.BoggleBlitz.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 13/06/2017.
 */
public class Main
{
    private int row;
    private int col;
    private char map[][];
    private boolean was[][];
    private TreeSet<String> set;

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
            while (true)
            {
                line = in.readLine();
                if (line == null)
                {
                    return;
                }
                if (line.trim().length() != 0)
                {
                    break;
                }
            }

            st = new StringTokenizer(line);
            set = new TreeSet<String>(new Comparator<String>()
            {
                public int compare(String a, String b)
                {
                    int lenDiff = Integer.compare(a.length(), b.length());
                    return lenDiff != 0 ? lenDiff : a.compareTo(b);
                }
            });

            col = row = Integer.parseInt(st.nextToken());
            map = new char[row][col];
            was = new boolean[row][col];
            for (int i = 0; i < row; i++)
            {
                map[i] = in.readLine().toCharArray();
            }

            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    go(i, j, "" + map[i][j]);
                }
            }

            StringBuilder result = new StringBuilder("");
            while (!set.isEmpty())
            {
                result.append(set.pollFirst() + "\n");
            }
            if (t == 1)
            {
                System.out.print(result);
            } else
            {
                System.out.print("\n" + result);
            }
        }
    }

    public void go(int x, int y, String word)
    {
        if (word.length() >= 3)
        {
            set.add(word);
        }
        was[x][y] = true;
        for (int dx = -1; dx <= 1; dx++)
        {
            for (int dy = -1; dy <= 1; dy++)
            {
                if (x + dx < row && x + dx >= 0 && y + dy < col && y + dy >= 0 && !was[x + dx][y + dy] && map[x + dx][y + dy] > map[x][y])
                {
                    go(x + dx, y + dy, word + map[x + dx][y + dy]);
                }
            }
        }
        was[x][y] = false;
    }

}
