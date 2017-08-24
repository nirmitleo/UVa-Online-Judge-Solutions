package UVa.AverageSpeed.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 23/06/2017.
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
        String prev = "";
        String now = "";
        double speed = 0;
        boolean first = true;
        double total = 0;
        for (; ; )
        {
            line = in.readLine();
            if (line == null)
            {
                return;
            }
            line = line.trim();
            if (first)
            {
                if (line.length() == 8)
                {
                    System.out.println(line.substring(0, 8) + " " + String.format("%.2f", total) + " km");
                    continue;
                }
                first = false;
                now = line.substring(0, 8);
                speed = Double.parseDouble(line.substring(8).trim());
            } else
            {
                if (line.length() == 8)
                {
                    prev = now;
                    now = line.substring(0, 8);
                    long timeDiff = timeInSeconds(now) - timeInSeconds(prev);
                    double s = convertToMetresPerSecond(speed);
                    double dist = (s * timeDiff) / 1000.0;
                    total += dist;
                    System.out.println(line.substring(0, 8) + " " + String.format("%.2f", total) + " km");
                } else
                {
                    prev = now;
                    now = line.substring(0, 8);
                    long timeDiff = timeInSeconds(now) - timeInSeconds(prev);
                    double s = convertToMetresPerSecond(speed);
                    double dist = (s * timeDiff) / 1000.0;
                    total += dist;
                    speed = Double.parseDouble(line.substring(8).trim());
                }
            }
        }
    }

    public double convertToKMPerHour(double speed)
    {
        return (speed * 18) / 5.0;
    }

    public double convertToMetresPerSecond(double speed)
    {
        return (speed * 5) / 18.0;
    }

    public long timeInSeconds(String s)
    {
        int colon1 = s.indexOf(":");
        int colon2 = s.lastIndexOf(":");
        int hours = Integer.parseInt(s.substring(0, colon1).trim());
        int min = Integer.parseInt(s.substring(colon1 + 1, colon2).trim());
        int seconds = Integer.parseInt(s.substring(colon2 + 1).trim());
        return seconds + (min * 60L) + (hours * 3600L);
    }
}
