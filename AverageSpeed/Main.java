package UVa.AverageSpeed;

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

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        double time = 0;
        double speed = 0;
        double distance = 0;
        while ((line = br.readLine()) != null)
        {
            tokens = line.split("[ ]");
            double newTime = getTime(tokens[0]);
            distance += speed * (newTime - time);
            if (tokens.length == 1)
            {
                System.out.printf(tokens[0] + " %.2f km\n", distance);
            }
            time = newTime;
            speed = tokens.length == 2 ? Double.parseDouble(tokens[1]) : speed;
        }
    }


    public double getTime(String time)
    {
        String t[] = time.split(":");
        double hours = 0;
        hours += Integer.parseInt(t[2]) / (3600 * 1.0);
        hours += Integer.parseInt(t[1]) / (60 * 1.0);
        hours += Integer.parseInt(t[0]);
        return hours;
    }

}
