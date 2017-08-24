package UVa.Cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        String line = "";
        while ((line = br.readLine()).charAt(0) != '0')
        {
            String tokens[] = br.readLine().split(" ");
            int key[] = new int[tokens.length];
            for (int i = 0; i < key.length; i++)
            {
                key[i] = Integer.parseInt(tokens[i]) - 1;
            }
            while ((line = br.readLine()).charAt(0) != '0')
            {
                int k = Integer.parseInt(line.charAt(0) + "");
                int place = 10;
                String message = "";
                for (int i = 1; i < line.length(); i++)
                {
                    char temp = line.charAt(i);
                    if (temp < '0' || temp > '9')
                    {
                        message = line.substring(i + 1);
                        break;
                    }
                    k = (k * place) + Integer.parseInt(temp + "");
                }
                char result[] = new char[key.length];
                int cycles[] = new int[tokens.length];
                Arrays.fill(result, ' ');
                while (message.length() != key.length)
                {
                    message += " ";
                }
                for (int i = 0; i < key.length; i++)
                {
                    int cycleLength = 1;
                    int index = i;
                    while (key[index] != i)
                    {
                        cycleLength++;
                        index = key[index];
                    }
                    cycles[i] = cycleLength;
                }
                for (int i = 0; i < cycles.length; i++)
                {
                    int cycle = k % cycles[i];
                    int index = i;
                    while (cycle-- > 0)
                    {
                        index = key[index];
                    }
                    result[index] = message.charAt(i);
                }
                message = new String(result);
                System.out.println(message);
            }
            System.out.println();
        }
    }
}
