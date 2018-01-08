package UVa.HelpingFillBates.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 27-05-2017.
 */
public class Main
{

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String s = in.readLine().trim();
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0)
        {
            String t = in.readLine().trim();
            int index = s.indexOf(t);
            if (index != -1)
            {
                System.out.println("Matched " + index + " " + (index + t.length() - 1));
            }else
            {
                System.out.println("Not matched");
            }
        }
    }
}
