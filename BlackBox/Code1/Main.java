package UVa.BlackBox.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by DELL on 24-Apr-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

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
            br.readLine();
            tokens = br.readLine().trim().split("[ ]+");
            int total1 = Integer.parseInt(tokens[0]);
            int total2 = Integer.parseInt(tokens[1]);

            TreeMap<Integer, String> list = new TreeMap<Integer, String>();

            String tokens1[] = br.readLine().trim().split("[ ]+");
            int elements[] = new int[tokens1.length];
            for (int i = 0; i < tokens1.length; i++)
            {
                elements[i] = Integer.parseInt(tokens1[i]);
            }

            String tokens2[] = br.readLine().trim().split("[ ]+");
            int index[] = new int[tokens2.length];
            for (int i = 0; i < index.length; i++)
            {
                index[i] = Integer.parseInt(tokens2[i]);
            }

            int j = 0;
            PriorityQueue<Integer> result = new PriorityQueue<Integer>();
            for (int i = 0; i < index.length; i++)
            {
                int position = index[i];

                while (j < elements.length && j >= result.size() - 1)
                {
                    result.add(-elements[j++]);
                }
                if (test == 0 && i == index.length - 1)
                {
                    out.print(-result.poll());
                } else
                {
                    out.println(-result.poll());
                }
            }
            if (test != 0)
            {
                out.println();
            }
        }
        out.close();
    }
}

