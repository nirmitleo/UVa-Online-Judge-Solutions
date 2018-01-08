package UVa.MirrorMirror.Code1;

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
        int test = 1;
        while ((line = br.readLine()) != null)
        {
            int n = Integer.parseInt(line.trim());
            boolean start[][] = new boolean[n][n];
            boolean end[][] = new boolean[n][n];

            for (int i = 0; i < start.length; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int j = 0; j < tokens[0].length(); j++)
                {
                    start[i][j] = tokens[0].charAt(j) == 'X';
                    end[i][j] = tokens[1].charAt(j) == 'X';
                }
            }
            String result = "Pattern " + (test++) + " was ";
            if (isEqual(start, end))
            {
                System.out.println(result + "preserved.");
                continue;
            }

            // Rotate by 90 degree //
            //print(start);
            boolean temp[][] = rotate90(start);
            //System.out.println("Matrix after rotation");
            //print(temp);
            if (isEqual(temp, end))
            {
                System.out.println(result + "rotated 90 degrees.");
                continue;
            }

            // Rotate by 180 degree //
            temp = rotate90(temp);
            if (isEqual(temp, end))
            {
                System.out.println(result + "rotated 180 degrees.");
                continue;
            }

            // Rotate by 270 degree //
            temp = rotate90(temp);
            if (isEqual(temp, end))
            {
                System.out.println(result + "rotated 270 degrees.");
                continue;
            }

            // Vertical Reflection //
            temp = verticalReflection(start);
            if (isEqual(temp, end))
            {
                System.out.println(result + "reflected vertically.");
                continue;
            }

            // Rotate by 90 //
            temp = rotate90(temp);
            if (isEqual(temp, end))
            {
                System.out.println(result + "reflected vertically and rotated 90 degrees.");
                continue;
            }

            temp = rotate90(temp);
            if (isEqual(temp, end))
            {
                System.out.println(result + "reflected vertically and rotated 180 degrees.");
                continue;
            }

            temp = rotate90(temp);
            if (isEqual(temp, end))
            {
                System.out.println(result + "reflected vertically and rotated 270 degrees.");
                continue;
            }

            System.out.println(result + "improperly transformed.");
        }
    }

    public boolean isEqual(boolean a[][], boolean b[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if (a[i][j] != b[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean[][] verticalReflection(boolean a[][])
    {
        boolean b[][] = new boolean[a.length][a.length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                b[a.length - 1 - i][j] = a[i][j];
            }
        }
        return b;
    }

    public void print(boolean a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                char c = a[i][j] ? 'X' : '.';
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public boolean[][] rotate90(boolean a[][])
    {
        boolean b[][] = new boolean[a.length][a.length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                b[j][a.length - 1 - i] = a[i][j];
            }
        }
        return b;
    }
}

