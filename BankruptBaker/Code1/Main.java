package UVa.BankruptBaker.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by DELL on 23-Apr-16.
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
            TreeSet<Recipe> result = new TreeSet<Recipe>();
            String binder = br.readLine().trim();
            tokens = br.readLine().trim().split("[ ]+");
            int totalCost = Integer.parseInt(tokens[0]);
            int recipies = Integer.parseInt(tokens[1]);
            int budget = Integer.parseInt(tokens[2]);

            TreeMap<String, Integer> costs = new TreeMap<String, Integer>();
            while (totalCost-- > 0)
            {
                tokens = br.readLine().trim().split("[ ]+");
                String ing = tokens[0];
                int cost = Integer.parseInt(tokens[1]);
                costs.put(ing, cost);
            }

            while (recipies-- > 0)
            {
                String name = br.readLine().trim();
                int steps = Integer.parseInt(br.readLine().trim());
                int amount = 0;
                while (steps-- > 0)
                {
                    tokens = br.readLine().trim().split("[ ]+");
                    String ing = tokens[0];
                    amount += costs.get(ing) * Integer.parseInt(tokens[1]);
                }
                if (amount <= budget)
                {
                    result.add(new Recipe(name, amount));
                }
            }
            System.out.println(binder.toUpperCase());
            if (result.isEmpty())
            {
                System.out.println("Too expensive!");
            } else
            {
                while (!result.isEmpty())
                {
                    Recipe temp = result.pollFirst();
                    System.out.println(temp.name);
                }
            }
            System.out.println();
        }
    }
}

class Recipe implements Comparable<Recipe>
{
    public String name;
    public int cost;

    public Recipe(String name, int cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public int compareTo(Recipe that)
    {
        int costDiff = this.cost - that.cost;
        if (costDiff == 0)
        {
            return this.name.compareTo(that.name);
        }
        return costDiff;
    }
}