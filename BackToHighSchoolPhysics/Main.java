package UVa.BackToHighSchoolPhysics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 04-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        while ((line = br.readLine()) != null)
        {
            if(line.length() == 0)
            {
                break;
            }
            String tokens[] = line.split(" ");
            System.out.println(Long.parseLong(tokens[0]) * 2 * Long.parseLong(tokens[1]));
        }
    }
}
