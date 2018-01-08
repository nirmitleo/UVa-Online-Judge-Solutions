package UVa.RareOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by DELL on 28-Feb-16.
 */
public class Main
{
    boolean a[][];
    boolean visited[];

    Stack<Integer> sort;
    TreeMap<Character, Integer> pair;
    TreeMap<Integer, Character> reversePair;
    ArrayList<String> lines;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        while ((line = br.readLine()) != null)
        {
            if ( line.trim().length() == 0 )
            {
                break;
            }
            int index = 0;
            sort = new Stack<Integer>();
            pair = new TreeMap<Character, Integer>();
            reversePair = new TreeMap<Integer, Character>();
            lines = new ArrayList<String>();
            while (!line.startsWith("#"))
            {
                lines.add(line);
                for (int i = 0; i < line.length(); i++)
                {
                    char key = line.charAt(i);
                    if ( pair.get(key) == null )
                    {
                        pair.put(key, index);
                        reversePair.put(index, key);
                        index = index + 1;
                    }
                }
                line = br.readLine();
            }
            int n = pair.size();
            a = new boolean[n][n];
            visited = new boolean[n];
            for (int i = 1; i < lines.size(); i++)
            {
                String line1 = lines.get(i - 1);
                String line2 = lines.get(i);
                int count1 = 0;
                int count2 = 0;
                while (count1 < line1.length() && count2 < line2.length())
                {
                    if ( line1.charAt(count1) != line2.charAt(count2) )
                    {
                        int from = pair.get(line1.charAt(count1));
                        int to = pair.get(line2.charAt(count2));
                        if ( from != to )
                        {
                            a[from][to] = true;
                            break;
                        }
                    }
                    count1++;
                    count2++;
                }
            }
            for (int i = 0; i < visited.length; i++)
            {
                if ( !visited[i] )
                {
                    tsort(i);
                }
            }
            while (!sort.isEmpty())
            {
                System.out.print(reversePair.get(sort.pop()));
            }
            System.out.println();
        }
    }

    public void tsort(int start)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty())
        {
            start = stack.peek();
            int i = 0;
            for (; i < visited.length; i++)
            {
                if ( a[start][i] && !visited[i] )
                {
                    visited[i] = true;
                    stack.push(i);
                    break;
                }
            }
            if ( i == visited.length )
            {
                sort.push(start);
                stack.pop();
            }
        }
    }
}
