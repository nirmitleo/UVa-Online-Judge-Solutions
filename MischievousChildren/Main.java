package UVa.MischievousChildren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
/*
    1) Dont forget to remove the package statement
    2) Remove the public access specifier from the UpperBound class.
    
    Train insane or remain the same!
*/

public class Main
{
    String line = "";
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        TreeMap<Integer, Long> fact = new TreeMap<Integer, Long>();
        fact.put(0, 1L);
        fact.put(1, 1L);
        for (int i = 2; i <= 20; i++)
        {
            long ans = fact.get(i - 1) * i;
            fact.put(i, ans);
        }
        int n = Integer.parseInt(br.readLine());
        for (int t = 1; t <= n; t++)
        {
            long result = 1;
            String word = br.readLine();
            result = fact.get(word.length());
            int a[] = new int[26];
            for (int i = 0; i < word.length(); i++)
            {
                a[word.charAt(i) - 'A']++;
            }
            for (int i = 0; i < a.length; i++)
            {
                result = result / fact.get(a[i]);
            }
            System.out.println("Data set " + t + ": " + result);
        }
    }

}
