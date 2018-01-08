package UVa.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        boolean isFirst = true;
        while (true)
        {
            tokens = br.readLine().split("[ ]+");
            if ( tokens.length == 1 && tokens[0].charAt(0) == '0' )
            {
                return;
            }
            int a[] = new int[tokens.length - 1];
            for (int i = 1; i < tokens.length; i++)
            {
                a[i - 1] = Integer.parseInt(tokens[i]);
            }
            Arrays.sort(a);

            for (int i = 0; i < a.length - 5; i++)
            {
                for (int j = i + 1; j < a.length - 4; j++)
                {
                    for (int k = j + 1; k < a.length - 3; k++)
                    {
                        for (int l = k + 1; l < a.length - 2; l++)
                        {
                            for (int m = l + 1; m < a.length - 1; m++)
                            {
                                for (int n = m + 1; n < a.length; n++)
                                {
                                    if ( isFirst )
                                    {
                                        System.out.println(a[i] + " " + a[j] + " " + a[k] + " " + a[l] + " " + a[m] + " " + a[n]);
                                    } else
                                    {
                                        System.out.print("\n" + a[i] + " " + a[j] + " " + a[k] + " " + a[l] + " " + a[m] + " " + a[n]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ( !isFirst )
            {
                System.out.println();
            }
            isFirst = false;
        }
    }

}
