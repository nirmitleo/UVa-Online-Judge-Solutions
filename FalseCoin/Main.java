package UVa.FalseCoin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by DELL on 17-Oct-15.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Main demo = new Main();
        demo.solve(in, out);

        out.close();
    }

    public void solve(BufferedReader in, PrintWriter out) throws IOException
    {

        int m = Integer.parseInt(in.readLine());
        while (m-- > 0)
        {
            in.readLine();
            String input[] = in.readLine().split("\\s+");
            boolean coins[] = new boolean[Integer.parseInt(input[0])];
            int k = Integer.parseInt(input[1]);
            while (k-- > 0)
            {
                String line1 = in.readLine();
                String line2 = in.readLine();
                if (line2.charAt(0) != '=')
                {
                    continue;
                }
                else
                {
                    String numbers[] = line1.split("\\s+");
                    for (int i = 1; i < numbers.length; i++)
                    {
                        coins[Integer.parseInt(numbers[i]) - 1] = true;
                    }
                }
            }
            int coin = -1;
            boolean isFound = false;
            for (int i = 0; i < coins.length; i++)
            {
                if (!coins[i] && isFound)
                {
                    coin = 0;
                    break;
                }
                if (!coins[i] && !isFound)
                {
                    coin = i + 1;
                    isFound = true;
                }
            }
            if (m != 0)
            {
                out.println(coin + "\n");
            }
            else
            {
                out.println(coin);
            }
        }
    }
}

