package UVa.CodeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 03-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            String line = "";
            while ((line = br.readLine()) != null)
            {
                if (line.length() == 0)
                {
                    System.out.println();
                    break;
                }
                for (int i = 0; i < line.length(); i++)
                {
                    char temp = line.charAt(i);
                    switch (temp)
                    {
                        case '0':
                            temp = 'O';
                            break;
                        case '1':
                            temp = 'I';
                            break;
                        case '2':
                            temp = 'Z';
                            break;
                        case '3':
                            temp = 'E';
                            break;
                        case '4':
                            temp = 'A';
                            break;
                        case '5':
                            temp = 'S';
                            break;
                        case '6':
                            temp = 'G';
                            break;
                        case '7':
                            temp = 'T';
                            break;
                        case '8':
                            temp = 'B';
                            break;
                        case '9':
                            temp = 'P';
                            break;
                    }
                    System.out.print(temp);
                }
                System.out.println();
            }
        }
    }
}
