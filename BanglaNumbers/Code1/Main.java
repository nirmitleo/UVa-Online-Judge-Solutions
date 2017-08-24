package UVa.BanglaNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 05/07/2017.
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
        for (int t = 1; ; t++)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                System.out.println();
                return;
            }
            boolean ok = false;
            for (int i = 0; i < line.length(); i++)
            {
                if (line.charAt(i) != '0')
                {
                    ok = true;
                    line = line.substring(i);
                    break;
                }
            }
            if (!ok)
            {
                line = "0";
            }

            if (line.trim().length() == 1)
            {
                if (t == 1)
                {
                    System.out.print(String.format("%4d", t) + ". " + line.trim());
                } else
                {
                    System.out.println();
                    System.out.print(String.format("%4d", t) + ". " + line.trim());
                }
                continue;
            }
            char[] num = line.trim().toCharArray();
            int N = num.length;
            String result = "";
            for (int i = N - 1, j = 1; i >= 0; i--, j++)
            {
                if (j <= 2 || j == 5 || j == 12 || j == 7 || j == 14 || j == 9 || j == 16)
                {
                    if (j == 1)
                    {
                        if (num[i - 1] == '0' && num[i] == '0')
                        {
                            i--;
                            j++;
                            continue;
                        }
                        if (num[i - 1] == '0' && num[i] != '0')
                        {
                            result = num[i] + result;
                            i--;
                            j++;
                            continue;
                        }
                        result = num[i - 1] + "" + num[i] + "" + result;
                        i--;
                        j++;
                    } else
                    {
                        if (num[i] == '0')
                        {
                            continue;
                        }
                        result = num[i] + result;
                    }
                } else if (j == 3 || j == 10)
                {
                    if (num[i] == '0')
                    {
                        continue;
                    }
                    result = num[i] + " shata " + result;
                } else if (j == 4 || j == 11)
                {
                    if (num[i] == '0' && i - 1 >= 0 && num[i - 1] == '0')
                    {
                        i--;
                        j++;
                        continue;
                    }
                    result = num[i] + " hajar " + result;
                } else if (j == 6 || j == 13)
                {
                    if (num[i] == '0' && i - 1 >= 0 && num[i - 1] == '0')
                    {
                        i--;
                        j++;
                        continue;
                    }
                    result = num[i] + " lakh " + result;
                } else if (j == 8 || j == 15)
                {
                    if (num[i] == '0' && i - 1 >= 0 && num[i - 1] == '0')
                    {
                        result = "kuti " + result;
                        i--;
                        j++;
                        continue;
                    }
                    result = num[i] + " kuti " + result;
                }
            }
            if (t == 1)
            {
                System.out.print(String.format("%4d", t) + ". " + result.trim());
            } else
            {
                System.out.println();
                System.out.print(String.format("%4d", t) + ". " + result.trim());
            }
        }

    }
}
