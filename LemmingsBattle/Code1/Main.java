package UVa.LemmingsBattle.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by DELL on 24-Apr-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine().trim());
        while (test-- > 0)
        {
            tokens = br.readLine().trim().split("[ ]+");
            int battleFields = Integer.parseInt(tokens[0]);
            int greenTotal = Integer.parseInt(tokens[1]);
            int blueTotal = Integer.parseInt(tokens[2]);

            PriorityQueue<Integer> green = new PriorityQueue<Integer>();
            PriorityQueue<Integer> blue = new PriorityQueue<Integer>();

            for (int i = 0; i < greenTotal; i++)
            {
                int power = -Integer.parseInt(br.readLine().trim());
                if (power != 0)
                {
                    green.add(power);
                }
            }
            for (int i = 0; i < blueTotal; i++)
            {
                int power = -Integer.parseInt(br.readLine().trim());
                if (power != 0)
                {
                    blue.add(power);
                }
            }


            while (!green.isEmpty() && !blue.isEmpty())
            {
                ArrayList<Integer> tempGreen = new ArrayList<Integer>();
                ArrayList<Integer> tempBlue = new ArrayList<Integer>();
                for (int i = 0; i < battleFields; i++)
                {

                    Integer g = green.peek();
                    Integer b = blue.peek();

                    if (g == null || b == null)
                    {
                        break;
                    }

                    g = -green.poll();
                    b = -blue.poll();
                    if (g > b)
                    {
                        tempGreen.add(-(g - b));
                    } else if (b > g)
                    {
                        tempBlue.add(-(b - g));
                    }
                }
                for (int i = 0; i < tempGreen.size(); i++)
                {
                    green.add(tempGreen.get(i));
                }
                for (int i = 0; i < tempBlue.size(); i++)
                {
                    blue.add(tempBlue.get(i));
                }
            }
            if (green.size() == blue.size() && green.size() == 0)
            {
                System.out.println("green and blue died");
            } else if (green.size() == 0)
            {
                System.out.println("blue wins");
                while (!blue.isEmpty())
                {
                    System.out.println(-blue.poll());
                }
            } else
            {
                System.out.println("green wins");
                while (!green.isEmpty())
                {
                    System.out.println(-green.poll());
                }
            }
            if (test != 0)
            {
                System.out.println();
            }
        }
    }
}

