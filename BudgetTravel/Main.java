package UVa.BudgetTravel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/*
    1) Dont forget to remove the package statement
    2) Remove the public access specifier from the UpperBound class.
    
    Train insane or remain the same!
*/

public class Main
{
    double totalDistance;
    double capacity;
    double rate;
    double dist[];
    double costs[];
    String line = "";
    String tokens[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter sout = new PrintWriter(System.out, true);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 0;
        while (!(line = br.readLine()).startsWith("-1"))
        {
            totalDistance = Double.parseDouble(line);
            tokens = br.readLine().split("[ ]+");
            capacity = Double.parseDouble(tokens[0]);
            rate = Double.parseDouble(tokens[1]);
            double cost = Double.parseDouble(tokens[2]);
            int stations = Integer.parseInt(tokens[3]);
            dist = new double[stations + 2];
            costs = new double[stations + 2];

            dist[0] = 0;
            costs[0] = cost * 100;

            dist[dist.length - 1] = totalDistance;
            costs[costs.length - 1] = 1;
            for (int i = 1; i < dist.length - 1; i++)
            {
                tokens = br.readLine().split("[ ]+");
                dist[i] = Double.parseDouble(tokens[0]);
                costs[i] = Double.parseDouble(tokens[1]);
            }
            for (int i = 0; i < dist.length; i++)
            {
                System.out.println(dist[i] + " " + costs[i]);
            }
            sout.println("Data Set #" + (++test));
            sout.println("minimum cost = $" + ((costs[0] + minCost(1, capacity - (dist[1] / rate), 0)) / 100));
        }

        sout.flush();
        sout.close();
    }

    public double minCost(int index, double level, double cost)
    {
        if ( index == dist.length - 1 )
        {
            return (cost);
        }

        double requiredLevel = ((dist[index + 1] - dist[index]) / rate);
        if ( level * 2 < capacity || level < requiredLevel )
        {
            cost = cost + (((capacity - level) * costs[index]) + 200);
            level = capacity - ((dist[index + 1] - dist[index]) / rate);
            return minCost(index + 1, level, cost);
        } else
        {
            //If I skip this station//
            double cost1 = cost;
            double level1 = level - ((dist[index + 1] - dist[index]) / rate);

            //If I fill at this station//
            double cost2 = cost + (((capacity - level) * costs[index]) + 200);
            double level2 = capacity - ((dist[index + 1] - dist[index]) / rate);

            return Math.min(minCost(index + 1, level1, cost1), minCost(index + 1, level2, cost2));
        }
    }

    public double round(double cost)
    {
        return Double.parseDouble(String.format("%.2f", cost));
    }

}
