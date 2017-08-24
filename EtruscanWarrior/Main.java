package UVa.EtruscanWarrior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 23-Feb-16.
 */
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
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            long n = Long.parseLong(br.readLine());
            long a = (long) ((-1 + Math.sqrt(1 + (4 * 2 * n))) / 2);
            System.out.println(a);
        }
    }

}
