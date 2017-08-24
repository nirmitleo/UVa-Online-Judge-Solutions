package UVa.Entropy.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 19-Apr-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while (!(line = br.readLine()).equals("****END_OF_INPUT****"))
        {
            int lamda = 0;
            TreeMap<String, Integer> map = new TreeMap<String, Integer>();
            while (true)
            {
                if (line.equals("****END_OF_TEXT****"))
                {
                    break;
                }
                tokens = line.trim().split("[^a-zA-z]+");
                lamda += tokens.length;
                for (int i = 0; i < tokens.length; i++)
                {
                    String key = tokens[i].toLowerCase().trim();
                    if (key.equals(""))
                    {
                        lamda--;
                        continue;
                    }
                    if (map.get(key) != null)
                    {
                        map.put(key, map.get(key) + 1);
                    } else
                    {
                        map.put(key, 1);
                    }
                }
                line = br.readLine();
            }
            double Emax = Math.log10(lamda);
            double Et = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet())
            {
                int p = entry.getValue();
                Et += (p * (Emax - Math.log10(p)));
            }
            Et = Et / (lamda * 1.0);
            int Erel = (int) Math.round(Et * 100 / (Emax * 1.0));
            System.out.printf("%d %.1f %d\n", lamda, Et, Erel);
        }
    }
}

