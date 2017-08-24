package UVa.Division.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 17/07/2017.
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
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0)
            {
                return;
            }
            String s = "";
            outer:
            for (int f = 0; f < 10; f++)
            {
                for (int g = 0; g < 10; g++)
                {
                    for (int h = 0; h < 10 && f != g; h++)
                    {
                        for (int i = 0; i < 10 && h != f && h != g; i++)
                        {
                            for (int j = 0; j < 10 && i != f && i != g && i != h; j++)
                            {
                                if (j != f && j != g && j != h && j != i)
                                {
                                    int fghij = j + i * 10 + h * 100 + g * 1000 + f * 10000;
                                    int abcde = N * fghij;
                                    if (abcde >= 1e5)
                                    {
                                        break outer;
                                    }
                                    if (check(abcde, fghij))
                                    {
                                        s += abcde + " / " + ((fghij < 1e4) ? "0" + fghij : fghij) + " = " + N + "\n";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (t == 1)
            {
                if (s.length() == 0)
                {
                    System.out.println("There are no solutions for " + N + ".");
                } else
                {
                    System.out.print(s);
                }
            } else
            {
                System.out.println();
                if (s.length() == 0)
                {
                    System.out.println("There are no solutions for " + N + ".");
                } else
                {
                    System.out.print(s);
                }
            }
        }
    }

    public boolean check(int a, int b)
    {
        int count = 0;
        boolean[] digit = new boolean[10];
        while (a > 0)
        {
            int d = a % 10;
            if (digit[d])
            {
                return false;
            }
            digit[d] = true;
            a /= 10;
            count++;
        }
        while (b > 0)
        {
            int d = b % 10;
            if (digit[d])
            {
                return false;
            }
            digit[d] = true;
            b /= 10;
            count++;
        }
        return count == 10 || count == 9 && !digit[0];
    }


}
