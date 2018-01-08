package UVa.HashmatTheBraveWarrior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 04-Feb-16.
 */
public class Main
{
    private static String tokens[];
    private static String line = "";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {

        while ((line = br.readLine()) != null)
        {
            if (line.length() == 0)
            {
                break;
            }
            tokens = line.split(" ");
            if (tokens.length == 2)
            {
                System.out.println(Math.abs(Long.parseLong(tokens[0]) - Long.parseLong(tokens[1])));
            }
        }
    }
}
