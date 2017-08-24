package UVa.ExcusesExcuses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by DELL on 07-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        int test = 1;
        while ((line = br.readLine()) != null)
        {
            String tokens[] = line.split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            HashMap<String, Integer> dict = new HashMap<String, Integer>();
            while (n-- > 0)
            {
                dict.put(br.readLine(), 1);
            }
            TreeSet<Lines> result = new TreeSet<Lines>();
            while (m-- > 0)
            {
                int count = 0;
                line = br.readLine();
                tokens = line.split("[^A-Za-z]+");
                for (int i = 0; i < tokens.length; i++)
                {
                    if (tokens[i].equals(""))
                    {
                        continue;
                    }
                    count += (dict.get(tokens[i].toLowerCase()) != null) ? 1 : 0;
                }
                result.add(new Lines(line, count));
            }
            System.out.println("Excuse Set #" + (test++));
            Lines first = result.pollFirst();
            int max = first.count;
            System.out.println(first.line);
            while (!result.isEmpty())
            {
                Lines temp = result.pollFirst();
                if (temp.count != max)
                {
                    break;
                }
                System.out.println(temp.line);
            }
            System.out.println();
        }
    }
}

class Lines implements Comparable<Lines>
{
    String line;
    int count;

    Lines(String line, int count)
    {
        this.line = line;
        this.count = count;
    }

    public int compareTo(Lines that)
    {
        int diff = that.count - this.count;
        return diff == 0 ? this.line.compareTo(that.line) : diff;
    }
}