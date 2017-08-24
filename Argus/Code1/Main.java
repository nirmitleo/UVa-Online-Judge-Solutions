package UVa.Argus.Code1;

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
        PriorityQueue<Register> queue = new PriorityQueue<Register>();

        int count = 0;
        while (!(line = br.readLine()).startsWith("#"))
        {
            tokens = line.trim().split("[ ]+");
            String name = tokens[1];
            int freq = Integer.parseInt(tokens[2]);

            queue.add(new Register(name, freq, freq));
        }

        int limit = Integer.parseInt(br.readLine().trim());
        String result = "";
        while (count < limit)
        {
            Register temp = queue.poll();


            if (count == 0)
            {
                result += temp.name;
            } else
            {
                result += "\n" + temp.name;
            }
            temp.time += temp.freq;
            queue.add(temp);
            count++;
        }

        System.out.print(result);
    }
}

class Register implements Comparable<Register>
{
    String name;
    int freq;
    int time;

    public Register(String name, int freq, int time)
    {
        this.name = name;
        this.freq = freq;
        this.time = time;
    }

    public int compareTo(Register that)
    {
        int timeDiff = this.time - that.time;

        if (timeDiff == 0)
        {
            return this.name.compareTo(that.name);
        }
        return timeDiff;
    }

}
