package UVa.PolePosition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 09-Apr-16.
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
        int index = 0;
        while (true)
        {
            line = br.readLine();
            if (line == null)
            {
                break;
            }
            int size = Integer.parseInt(line.trim());
            if (size == 0)
            {
                return;
            }
            int startGrid[] = new int[size + 1];
            String result = "";
            for (int i = 1; i < startGrid.length; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int car = Integer.parseInt(tokens[0]);
                int delta = Integer.parseInt(tokens[1]);

                if (!result.equals("-1") && i + delta <= size && i + delta > 0 && startGrid[i + delta] == 0)
                {
                    startGrid[i + delta] = car;
                } else
                {
                    result = "-1";
                }
            }
            if (!result.equals("-1"))
            {
                for (int i = 1; i < startGrid.length; i++)
                {
                    result += startGrid[i] + " ";
                }
            }
            System.out.println(result.trim());
        }
    }
}

