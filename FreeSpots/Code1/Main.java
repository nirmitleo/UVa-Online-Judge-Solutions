package UVa.FreeSpots.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 28-Apr-16.
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
            int width = Integer.parseInt(tokens[0]);
            int height = Integer.parseInt(tokens[1]);
            int n = Integer.parseInt(tokens[2]);

            if (width == height && height == n && n == 0)
            {
                return;
            }

            boolean a[][] = new boolean[height][width];
            for (int i = 0; i < n; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int x1 = Integer.parseInt(tokens[0]) - 1;
                int y1 = Integer.parseInt(tokens[1]) - 1;

                int x2 = Integer.parseInt(tokens[2]) - 1;
                int y2 = Integer.parseInt(tokens[3]) - 1;


                int xFrom = Math.min(x1, x2);
                int yFrom = Math.min(y1, y2);

                int xTo = Math.max(x1, x2);
                int yTo = Math.max(y1, y2);


                for (int y = yFrom; y <= yTo; y++)
                {
                    for (int x = xFrom; x <= xTo; x++)
                    {
                        a[y][x] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a[i].length; j++)
                {
                    if (!a[i][j])
                    {
                        count++;
                    }
                }
            }
            if (count == 0)
            {
                System.out.println("There is no empty spots.");
            } else if (count == 1)
            {
                System.out.println("There is one empty spot.");
            } else
            {
                System.out.println("There are " + count + " empty spots.");
            }
            br.readLine();
        }
    }
}

