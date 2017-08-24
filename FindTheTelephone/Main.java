package UVa.FindTheTelephone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Jan-16.
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
        while ((line = br.readLine()) != null)
        {
            for (int i = 0; i < line.length(); i++)
            {
                char n = line.charAt(i);
                if (n >= 'A' && n <= 'Z')
                {
                    switch (n)
                    {
                        case 'A':
                        case 'B':
                        case 'C':
                            System.out.print(2);
                            break;
                        case 'D':
                        case 'E':
                        case 'F':
                            System.out.print(3);
                            break;
                        case 'G':
                        case 'H':
                        case 'I':
                            System.out.print(4);
                            break;
                        case 'J':
                        case 'K':
                        case 'L':
                            System.out.print(5);
                            break;
                        case 'M':
                        case 'N':
                        case 'O':
                            System.out.print(6);
                            break;
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                            System.out.print(7);
                            break;
                        case 'T':
                        case 'U':
                        case 'V':
                            System.out.print(8);
                            break;
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                            System.out.print(9);
                            break;
                    }
                }
                else
                {
                    System.out.print(n);
                }
            }
            System.out.println();
        }
    }
}
