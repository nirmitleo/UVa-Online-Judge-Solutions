package UVa.InTheAirport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 19-Feb-16.
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
        for (int t = 1; t <= test; t++)
        {
            tokens = br.readLine().split(" ");
            int total = Integer.parseInt(tokens[0]);
            int cakes = Integer.parseInt(tokens[1]);
            int drinks = Integer.parseInt(tokens[2]);

            tokens = br.readLine().split(" ");
            long menu[] = new long[tokens.length];
            long sum = 0;
            double average = 0;
            for (int i = 0; i < tokens.length; i++)
            {
                menu[i] = Long.parseLong(tokens[i]);
                sum += menu[i];
            }
            average = sum / menu.length;

            long cakePrice = Long.MAX_VALUE;
            long drinkPrice = Long.MAX_VALUE;
            double cakeMin = Double.MAX_VALUE;
            double drinkMin = Double.MAX_VALUE;
            for (int i = 0; i < cakes + drinks; i++)
            {
                if (i < cakes && Math.abs(average - menu[i]) <= cakeMin)
                {
                    cakeMin = Math.abs(average - menu[i]);
                    cakePrice = Math.abs(average - menu[i]) == cakeMin ? Math.min(cakePrice, menu[i]) : menu[i];
                    continue;
                }
                if (i < cakes + drinks && Math.abs(average - menu[i]) <= drinkMin)
                {
                    drinkMin = Math.abs(average - menu[i]);
                    drinkPrice = Math.abs(average - menu[i]) == drinkMin ? Math.min(drinkPrice, menu[i]) : menu[i];
                }
            }

            System.out.println("Case #" + t + ": " + cakePrice + " " + drinkPrice);
        }
    }
}
