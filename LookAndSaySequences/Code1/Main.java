package UVa.LookAndSaySequences.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/07/2017.
 */
public class Main
{

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
            st = new StringTokenizer(in.readLine());
            String now = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if (n == 0 && pos == 0 && now.equals("0"))
            {
                return;
            }

            now += " ";
            for (int p = 1; ; p++)
            {
                if (p == n)
                {
                    System.out.println(now.charAt(pos - 1));
                    break;
                } else
                {
                    String next = "";
                    int count = 1;
                    char ch = now.charAt(0);
                    for (int i = 1; i < now.length(); i++)
                    {
                        if (now.charAt(i) == ch)
                        {
                            count++;
                        } else
                        {
                            next += count + "" + ch;
                            count = 1;
                            ch = now.charAt(i);
                            if (next.length() >= pos + 5)
                            {
                                break;
                            }
                        }
                    }
                    now = next + " ";
                }
            }
        }
    }

    public String get(char ch, int count)
    {
        String x = "";
        for (int i = 0; i < count; i++)
        {
            x += ch;
        }
        return x;
    }
}
