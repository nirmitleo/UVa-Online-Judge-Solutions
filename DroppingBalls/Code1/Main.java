package UVa.DroppingBalls.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 22-May-16.
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
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            tokens = br.readLine().split("[ ]+");
            int depth = Integer.parseInt(tokens[0]);
            int iteration = Integer.parseInt(tokens[1]);
            int position = 1;
            int limit = (1 << depth) - 1;
            while (position <= limit)
            {
                position = (iteration & 1) == 0 ? (position << 1) + 1 : position << 1;
                iteration = (int) Math.ceil(iteration / 2.0);
            }
            System.out.println(position>>1);
        }

    }
}

