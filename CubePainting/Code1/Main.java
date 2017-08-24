package UVa.CubePainting.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 10/06/2017.
 */
public class Main
{
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
        for (; ; )
        {
            String line = in.readLine();
            if (line == null)
            {
                return;
            }
            line = line.trim();
            set = new TreeSet<>();
            String now = line.substring(0, 6);
            String rot = line.substring(6);

            set.add(now);
            for (int i = 1; i < 3; i++)
            {
                String r = xAxis(now, i);
                for (int j = 1; j < 3; j++)
                {
                    String s = yAxis(r, j);
                    String t = zAxis(r, j);
                    for (int k = 1; k < 3; k++)
                    {
                        zAxis(s, k);
                        yAxis(t, k);
                    }
                }
            }
            for (int i = 1; i < 3; i++)
            {
                String r = yAxis(now, i);
                for (int j = 1; j < 3; j++)
                {
                    String s = xAxis(r, j);
                    String t = zAxis(r, j);
                    for (int k = 1; k < 3; k++)
                    {
                        zAxis(s, k);
                        xAxis(t, k);
                    }
                }
            }
            for (int i = 1; i < 3; i++)
            {
                String r = zAxis(now, i);
                for (int j = 1; j < 3; j++)
                {
                    String s = xAxis(r, j);
                    String t = yAxis(r, j);
                    for (int k = 1; k < 3; k++)
                    {
                        yAxis(s, k);
                        xAxis(t, k);
                    }
                }
            }


            if (set.contains(rot))
            {
                System.out.println("TRUE");
            } else
            {
                System.out.println("FALSE");
            }
        }
    }

    public String xAxis(String now, int round)
    {
        if (round == 1)
        {
            String r = "" + now.charAt(4) + now.charAt(0) + now.charAt(2) + now.charAt(3) + now.charAt(5) + now.charAt(1);
            set.add(r);
            return r;
        } else if (round == 2)
        {
            String r = "" + now.charAt(5) + now.charAt(4) + now.charAt(2) + now.charAt(3) + now.charAt(1) + now.charAt(0);
            set.add(r);
            return r;
        } else
        {
            String r = "" + now.charAt(1) + now.charAt(5) + now.charAt(2) + now.charAt(3) + now.charAt(0) + now.charAt(4);
            set.add(r);
            return r;
        }
    }

    public String yAxis(String now, int round)
    {
        if (round == 1)
        {
            String r = "" + now.charAt(0) + now.charAt(2) + now.charAt(4) + now.charAt(1) + now.charAt(3) + now.charAt(5);
            set.add(r);
            return r;
        } else if (round == 2)
        {
            String r = "" + now.charAt(0) + now.charAt(4) + now.charAt(3) + now.charAt(2) + now.charAt(1) + now.charAt(5);
            set.add(r);
            return r;
        } else
        {
            String r = "" + now.charAt(0) + now.charAt(3) + now.charAt(1) + now.charAt(4) + now.charAt(2) + now.charAt(5);
            set.add(r);
            return r;
        }
    }

    public String zAxis(String now, int round)
    {
        if (round == 1)
        {
            String r = "" + now.charAt(3) + now.charAt(1) + now.charAt(0) + now.charAt(5) + now.charAt(4) + now.charAt(2);
            set.add(r);
            return r;
        } else if (round == 2)
        {
            String r = "" + now.charAt(5) + now.charAt(1) + now.charAt(3) + now.charAt(2) + now.charAt(4) + now.charAt(0);
            set.add(r);
            return r;
        } else
        {
            String r = "" + now.charAt(2) + now.charAt(1) + now.charAt(5) + now.charAt(0) + now.charAt(4) + now.charAt(3);
            set.add(r);
            return r;
        }

    }


}
