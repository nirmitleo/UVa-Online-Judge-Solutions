package UVa.FunnyEncryptionMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Jan-16.
 */
public class Main
{
    String line;
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            int b1 = Integer.bitCount(n);
            int b2 = countOnes(n + "");
            System.out.println(b1 + " " + b2);
        }
    }

    public int countOnes(String hex)
    {
        int sum = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            switch (hex.charAt(i))
            {
                case '0':
                    sum += 0;
                    break;
                case '1':
                case '2':
                case '4':
                case '8':
                    sum += 1;
                    break;
                case '3':
                case '5':
                case '6':
                case '9':
                case 'a':
                case 'A':
                case 'c':
                case 'C':
                    sum += 2;
                    break;
                case '7':
                case 'b':
                case 'B':
                case 'd':
                case 'D':
                case 'e':
                case 'E':
                    sum += 3;
                    break;
                case 'f':
                case 'F':
                    sum += 4;
                    break;
            }
        }
        return sum;
    }

}
