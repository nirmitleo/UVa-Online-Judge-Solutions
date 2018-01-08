package UVa.PetersSmoke;

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
        while ((line = br.readLine()) != null)
        {
            tokens = line.trim().split("[ ]+");
            int butts = Integer.parseInt(tokens[0]);
            int conversionRatio = Integer.parseInt(tokens[1]);
            int result = butts;
            while (true)
            {
                int temp = butts / conversionRatio;
                if (temp == 0)
                {
                    break;
                }
                result += temp;
                temp += butts % conversionRatio;
                butts = temp;
            }
            System.out.println(result);
        }
    }
}

