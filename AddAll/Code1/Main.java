package UVa.AddAll.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        while (!(line = br.readLine()).trim().startsWith("0"))
        {
            int n = Integer.parseInt(line.trim());
            tokens = br.readLine().trim().split("[ ]+");

            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for (int i = 0; i < tokens.length; i++)
            {
                int temp = Integer.parseInt(tokens[i]);
                queue.add(temp);
            }

            int cost = 0;
            while (queue.size() > 1)
            {
                int a = queue.poll();
                int b = queue.poll();
                cost += (a + b);
                queue.add(a + b);
            }
            System.out.println(cost);


        }

    }
}

