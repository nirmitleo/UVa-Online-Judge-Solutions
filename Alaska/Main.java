package UVa.Alaska;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

        while (true)
        {
            line = br.readLine();
            if (line == null)
            {
                return;
            }
            int stations = Integer.parseInt(line.trim());
            if (stations == 0)
            {
                return;
            }
            int dist[] = new int[stations + 1];
            int max = -1;
            for (int i = 0; i < stations; i++)
            {
                dist[i] = Integer.parseInt(br.readLine().trim());
                max = Math.max(max, dist[i]);
            }

            int n = dist.length;
            dist[n - 1] = max + (2 * (1422 - max));

            Arrays.sort(dist);

            int current = 0;
            boolean result = true;
            for (int i = 1; i < dist.length; i++)
            {
                if (current + 200 < dist[i])
                {
                    result = false;
                    break;
                }
                current = dist[i];
            }
            if (result)
            {
                System.out.println("POSSIBLE");
            } else
            {
                System.out.println("IMPOSSIBLE");
            }


        }

    }
}

