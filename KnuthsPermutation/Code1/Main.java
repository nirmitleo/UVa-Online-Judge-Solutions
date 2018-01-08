package UVa.KnuthsPermutation.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 16/06/2017.
 */
public class Main
{
    private int N;
    private String s;
    private ArrayList<String> result;


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
        for (int t = 1; ; t++)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            s = line.trim();
            N = s.length();
            result = new ArrayList<>();
            go(1, s.charAt(0) + "");
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < result.size(); i++)
            {
                sb.append(result.get(i) + "\n");
            }
            if (t == 1)
            {
                System.out.print(sb);
            } else
            {
                System.out.print("\n" + sb);
            }
        }
    }

    public void go(int i, String p)
    {
        if (i == N)
        {
            result.add(p);
            return;
        }
        char ch = s.charAt(i);
        go(i + 1, ch + p);
        for (int j = 1; j < p.length(); j++)
        {
            go(i + 1, p.substring(0, j) + ch + p.substring(j));
        }
        go(i + 1, p + ch);
    }
}
