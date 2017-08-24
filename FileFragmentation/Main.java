package UVa.FileFragmentation;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 22-Oct-15.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(outputStream, true);

        Main demo = new Main();
        demo.solve(in, out);


        out.close();
    }

    public void solve(BufferedReader in, PrintWriter out) throws IOException
    {
        int test = Integer.parseInt(in.readLine());
        in.readLine();
        while (test-- > 0)
        {
            TreeMap<String, Integer> fragments = new TreeMap<String, Integer>();
            ArrayList<String> initialFragments = new ArrayList<String>();
            boolean flag = false;
            while (true)
            {
                String line = in.readLine();
                if (line == null || line.isEmpty())
                {
                    break;
                }
                String secondFragment = line;
                for (int i = 0; i < initialFragments.size() && flag; i++)
                {
                    String firstFragment = initialFragments.get(i);
                    String one = firstFragment + secondFragment;
                    String second = secondFragment + firstFragment;
                    if (fragments.get(one) != null)
                    {
                        fragments.put(one, fragments.get(one) + 1);
                    }
                    else
                    {
                        fragments.put(one, 1);
                    }

                    if (!firstFragment.equals(line) && fragments.get(second) != null)
                    {
                        fragments.put(second, fragments.get(second) + 1);
                    }
                    else if (!firstFragment.equals(secondFragment))
                    {
                        fragments.put(second, 1);
                    }
                }
                if (!flag)
                {
                    flag = true;
                    fragments.put(secondFragment, 1);
                }
                initialFragments.add(secondFragment);
            }
            int max = Integer.MIN_VALUE;
            String ans = "";
            for (Map.Entry<String, Integer> entry : fragments.entrySet())
            {
                int value = entry.getValue();
                if (max < value)
                {
                    ans = entry.getKey();
                    max = value;
                }
            }
            if (test == 0)
            {
                out.println(ans);
            }
            else
            {
                out.println(ans + "\n");
            }

        }
        System.exit(0);
    }
}
