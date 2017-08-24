package UVa.DominoEffect.Code1;

import java.util.Random;

/**
 * Created by DELL on 17-Jun-16.
 */
public class Tester
{
    private static Random r = new Random();

    public static void main(String ar[])
    {
        int nodes = r.nextInt(10);
        int edges = (r.nextInt(nodes));
        System.out.println(nodes + " " + edges);
        for (int i = 0; i < edges; i++)
        {
            int from = r.nextInt(nodes);
            int to = r.nextInt(nodes);
            int cost = r.nextInt(10);
            System.out.println(from + " " + to + " " + cost);
        }
    }
}
