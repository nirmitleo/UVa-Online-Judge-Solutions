package UVa.BilliardBounces.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 30/06/2017.
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
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            double X = Double.parseDouble(st.nextToken());
            double Y = Double.parseDouble(st.nextToken());
            double V = Double.parseDouble(st.nextToken());
            double theta = Math.toRadians(Double.parseDouble(st.nextToken()));
            double time = Double.parseDouble(st.nextToken());
            if (X + Y <= 1e-6)
            {
                return;
            }

            double Vx = V * Math.cos(theta);
            double Vy = V * Math.sin(theta);

            double Ax = Vx / time;
            double Ay = Vy / time;

            double Sx = Vx * time;
            Sx -= 0.5 * Ax * time * time;

            double Sy = Vy * time;
            Sy -= 0.5 * Ay * time * time;

            int countH = 0;
            int countV = 0;

            if (Sx >= X / 2.0)
            {
                countH++;
                Sx -= X / 2.0;
                countH += Sx / X;
            }

            if (Sy >= Y / 2.0)
            {
                countV++;
                Sy -= Y / 2.0;
                countV += Sy / Y;
            }
            System.out.println(countH + " " + countV);

        }

    }
}
