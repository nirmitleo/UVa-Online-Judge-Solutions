package UVa.Cantor.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 26-05-2017.
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
        //demo.test1();
    }

    public void test()
    {
        System.out.println(toBase3(0.875));
    }

    public StringBuffer toBase3(double num)
    {
        StringBuffer result = new StringBuffer(".");
        for (int i = 1; i < 1e5; i++)
        {
            int digit = (int) ((num * 3) / 1);
            num = (num * 3) % 1;
            result.append(digit);
        }
        return result;
    }

    public void solve() throws IOException
    {
        while (true)
        {
            line = in.readLine();
            if (line.contains("END"))
            {
                return;
            }

            double num = Double.parseDouble(line);
            String result = toBase3(num).toString();
            if (result.contains("1"))
            {
                System.out.println("NON-MEMBER");
            } else
            {
                System.out.println("MEMBER");
            }
        }

    }
}
