package UVa.RankTheLanguages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by DELL on 23-Jan-16.
 */
public class Main
{
    int row;
    int col;
    char map[][];
    TreeMap<Character, Language> cache;
    TreeSet<Language> ranks;

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
        for (int t = 1; t <= test; t++)
        {
            tokens = br.readLine().split(" ");
            row = Integer.parseInt(tokens[0]);
            col = Integer.parseInt(tokens[1]);
            map = new char[row][col];
            cache = new TreeMap<Character, Language>();
            ranks = new TreeSet<Language>();
            for (int i = 0; i < map.length; i++)
            {
                String tempLine = br.readLine();
                for (int j = 0; j < map[i].length; j++)
                {
                    map[i][j] = tempLine.charAt(j);
                }
            }
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[i].length; j++)
                {
                    if (map[i][j] != '\u0000')
                    {
                        char key = map[i][j];
                        count(i, j, key);
                        if (cache.get(key) == null)
                        {
                            cache.put(key, new Language(key, 1));
                        }
                        else
                        {
                            Language temp = cache.get(key);
                            temp.size++;
                        }
                    }
                }
            }
            for (Map.Entry<Character, Language> entry : cache.entrySet())
            {
                ranks.add(entry.getValue());
            }
            System.out.println("World #" + t);
            while (!ranks.isEmpty())
            {
                Language temp = ranks.pollFirst();
                System.out.println(temp.name + ": " + temp.size);
            }
        }
    }

    public void count(int x, int y, char language)
    {
        if (x < 0 || y < 0 || x >= row || y >= col || map[x][y] == '\u0000' || map[x][y] != language)
        {
            return;
        }
        map[x][y] = '\u0000';
        count(x, y + 1, language);
        count(x, y - 1, language);
        count(x + 1, y, language);
        count(x - 1, y, language);
    }

}

class Language implements Comparable<Language>
{
    char name;
    int size;

    public Language(char name, int size)
    {
        this.name = name;
        this.size = size;
    }

    public int compareTo(Language that)
    {
        if (this.size != that.size)
        {
            return that.size - this.size;
        }
        else
        {
            return this.name - that.name;
        }
    }
}