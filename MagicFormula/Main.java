package UVa.MagicFormula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Mar-16.
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
        boolean isFirst = true;
        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            long a = Long.parseLong(tokens[0]);
            long b = Long.parseLong(tokens[1]);
            long c = Long.parseLong(tokens[2]);
            long d = Long.parseLong(tokens[3]);
            long limit = Long.parseLong(tokens[4]);
            int ans = 0;
            if (a == 0 && b == 0 && c == 0 && limit == 0 && d == 0)
            {
                break;
            }
            int count = 0;
            for (int i = 0; i <= limit; i++)
            {
                long term1 = i * i * a;
                long term2 = i * b;
                if ((term1 + term2 + c) % d == 0)
                {
                    count++;
                }
            }
            ans = count;
            if (isFirst)
            {
                isFirst = false;
                System.out.print(ans);
            } else
            {
                System.out.print("\n" + ans);
            }
        }
    }
}

