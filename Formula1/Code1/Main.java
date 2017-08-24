package UVa.Formula1.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 01-May-16.
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
            int contests = Integer.parseInt(tokens[0]);
            int participants = Integer.parseInt(tokens[1]);
            if (contests == participants && contests == 0)
            {
                return;
            }

            int results[][] = new int[contests][participants];
            for (int i = 0; i < results.length; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int j = 0; j < results[i].length; j++)
                {
                    results[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            int schemes = Integer.parseInt(br.readLine());
            int scores[][] = new int[schemes][participants];
            for (int i = 0; i < schemes; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int j = 1; j < tokens.length; j++)
                {
                    scores[i][j - 1] = Integer.parseInt(tokens[j]);
                }
            }


            int champions[] = new int[participants];
            for (int s = 0; s < scores.length; s++)
            {
                int max = -1;
                int points[] = new int[participants];
                for (int i = 0; i < results.length; i++)
                {
                    for (int j = 0; j < results[i].length; j++)
                    {
                        points[j] += scores[s][results[i][j] - 1];
                        max = Math.max(max, points[j]);
                    }
                }
                String ans = "";
                for (int i = 0; i < points.length; i++)
                {
                    if (points[i] == max)
                    {
                        ans += (i + 1) + " ";
                    }
                }
                System.out.println(ans.trim());
            }
        }
    }
}

