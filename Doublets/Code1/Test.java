package UVa.Doublets.Code1;

import java.util.Random;
import java.util.TreeSet;

/**
 * Created by Nirmit on 23/08/2017.
 */
public class Test
{
    private Random r = new Random();
    private String[] names = {"booster", "rooster", "roaster", "coasted", "roasted"};

    public static void main(String[] a)
    {
        Test demo = new Test();
        demo.solve();
    }

    public void solve()
    {
        for (int t = 1; t <= 1; t++)
        {
            TreeSet<String> set = new TreeSet<>();

            //Change one character//
            for (int i = 1; i <= 5; i++)
            {
                int index = getRandom(0, names.length - 1);
                set.add(changeCharacter(names[index]));
            }

            int n = set.size();
            String[] words = new String[n];
            String s = "";
            for (int i = 0; i < n; i++)
            {
                words[i] = set.pollFirst();
                s += words[i] + "\n";
            }
            s += "\n";
            for (int i = 0; i < 5; i++)
            {
                int from = getRandom(0, n - 1);
                int to = getRandom(0, n - 1);
                s += words[from] + " " + words[to] + "\n";
            }
            System.out.println(s);
        }
    }

    public String changeCharacter(String name)
    {
        char[] a = name.toCharArray();
        int index = getRandom(0, a.length - 1);
        char ch = ((char) (getRandom(0, 25) + 'a'));
        a[index] = ch;
        return new String(a);
    }

    public int getRandom(int min, int max)
    {
        return r.nextInt(max - min + 1) + min;
    }
}
