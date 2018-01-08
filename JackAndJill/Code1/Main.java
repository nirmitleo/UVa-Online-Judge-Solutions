package UVa.JackAndJill.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24/06/2017.
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
        for (int t = 1; ; t++)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            double UP = Double.parseDouble(st.nextToken());
            if (UP < 1 && !st.hasMoreTokens())
            {
                return;
            }
            double D = Double.parseDouble(st.nextToken());
            double L = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double P = Double.parseDouble(st.nextToken());
            double DOWN = Double.parseDouble(st.nextToken());
            double V = Double.parseDouble(st.nextToken());

            ArrayList<String> result = new ArrayList<String>();
            result.add(String.format("     up hill         %10.2f sec\n", UP));
            result.add(String.format("     well diameter   %10.2f in\n", D));
            result.add(String.format("     water level     %10.2f in\n", L));
            result.add(String.format("     bucket volume   %10.2f cu ft\n", B));
            result.add(String.format("     bucket ascent rate%8.2f in/sec\n", P));
            result.add(String.format("     down hill       %10.2f sec\n", DOWN));
            result.add(String.format("     required volume %10.2f cu ft\n", V));


            double R = D / 2 / 12; //Radius in ft//
            double h = B;
            h /= Math.PI;
            h /= (R * R); //h  in ft//

            L /= 12; //L in ft//

            double time = 0;
            double left = V;
            for (; left > 1e-7; )
            {
                time += UP;
                time += getTimeDown(L);
                time += getTimeUp(L, P);
                L += h;
                time += DOWN;
                left -= B;
            }
            result.add(String.format("     TIME REQUIRED   %10.2f sec\n", time));
            if (t == 1)
            {
                System.out.println("Scenario " + t + ":");
            } else
            {
                System.out.println("\nScenario " + t + ":");
            }
            for (String s : result)
            {
                System.out.print(s);
            }
        }

    }

    public double getTimeDown(double L)
    {
        return Math.sqrt(L / 16.1);
    }

    public double getTimeUp(double L, double P)
    {
        double time = L * 12;
        return time / P;
    }
}
