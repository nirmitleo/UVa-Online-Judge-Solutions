package UVa.HanoiTowerTroublesAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 29-Feb-16.
 */
public class Main
{
    int max = 0;
    int pegs[] = new int[51];
    int hanoi[] = new int[51];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        max = 0;
        for (int i = 1; i < pegs.length; i++)
        {
            calc(max + 1, i);
            hanoi[i] = max;
        }
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            System.out.println(hanoi[n]);
        }
    }

    public void calc(int disc, int totalPegs)
    {

        for (int i = 0; i < totalPegs; i++)
        {
            if ( pegs[i] == 0 || (Math.sqrt(disc + pegs[i]) % 1 == 0) )
            {
                pegs[i] = disc;
                max = Math.max(disc, max);
                calc(disc + 1, totalPegs);
            }
        }
    }
}
