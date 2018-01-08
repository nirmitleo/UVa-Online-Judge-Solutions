package UVa.PigLatin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Jan-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solve() throws IOException
    {
        int count = 0;
        //br = new BufferedReader(new FileReader(new File("./src/UVa/PigLatin/input.txt")));
        StringBuilder ans = new StringBuilder("");
        StringBuilder word = new StringBuilder("");
        while (true)
        {
            int temp = br.read();
            if (temp < 0)
            {
                break;
            }
            char currentChar = (char) temp;
            if ((currentChar >= 'a' && currentChar <= 'z') || (currentChar >= 'A' && currentChar <= 'Z'))
            {
                word.append(currentChar);
            }
            else
            {
                if (word.length() > 0)
                {
                    char firstChar = word.charAt(0);
                    if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u' || firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U')
                    {
                        ans.append(word.append("ay"));
                    }
                    else
                    {
                        char fc = word.charAt(0);
                        ans.append(word.substring(1)).append(fc).append("ay");
                    }
                }
                ans.append(currentChar);
                word = new StringBuilder("");
            }
        }
        System.out.print(ans);
    }


    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }
}
