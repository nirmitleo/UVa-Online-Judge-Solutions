package UVa.DigitalFortress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 03-Feb-16.
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
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            String line = br.readLine();
            int length = line.length();
            boolean isValid = false;
            int size = 0;
            for (int i = 0; i <= 100; i++)
            {
                if (i * i == length)
                {
                    isValid = true;
                    size = i;
                    break;
                }
            }
            if (!isValid)
            {
                System.out.println("INVALID");
                continue;
            }
            String ans = "";
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    ans += line.charAt((j * size) + i);
                }
            }
            System.out.println(ans);
        }
    }
}
