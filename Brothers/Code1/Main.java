package UVa.Brothers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
            int heirs = Integer.parseInt(tokens[0]);
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            int battles = Integer.parseInt(tokens[3]);

            if (heirs == 0 && heirs == row && row == col && col == battles)
            {
                return;
            }

            int kingdom[][] = new int[row][col];
            for (int i = 0; i < kingdom.length; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int j = 0; j < tokens.length; j++)
                {
                    kingdom[i][j] = Integer.parseInt(tokens[j]);
                }
            }


            int drow[] = new int[]{-1, 0, +1, 0};
            int dcol[] = new int[]{0, -1, 0, +1};

            for (int battle = 1; battle <= battles; battle++)
            {
                int temp[][] = new int[row][col];
                for (int i = 0; i < temp.length; i++)
                {
                    Arrays.fill(temp[i], -1);
                }

                for (int i = 0; i < kingdom.length; i++)
                {
                    for (int j = 0; j < kingdom[i].length; j++)
                    {
                        for (int k = 0; k < 4; k++)
                        {
                            if (i + drow[k] >= 0 && i + drow[k] < row && j + dcol[k] < col && j + dcol[k] >= 0)
                            {
                                if ((kingdom[i][j] + 1) % heirs == kingdom[i + drow[k]][j + dcol[k]])
                                {
                                    temp[i + drow[k]][j + dcol[k]] = kingdom[i][j];
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < temp.length; i++)
                {
                    for (int j = 0; j < temp[i].length; j++)
                    {
                        temp[i][j] = temp[i][j] == -1 ? kingdom[i][j] : temp[i][j];
                    }
                }
                kingdom = temp;
            }
            print(kingdom);
        }
    }

    public void print(int kingdom[][])
    {
        for (int r = 0; r < kingdom.length; r++)
        {
            for (int c = 0; c < kingdom[r].length; c++)
            {
                if (c == 0)
                {
                    System.out.print(kingdom[r][c]);
                } else
                {
                    System.out.print(" " + kingdom[r][c]);
                }
            }
            System.out.println();
        }
    }
}

