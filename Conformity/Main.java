package UVa.Conformity;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 23-Oct-15.
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
        while (true)
        {
            int n = Integer.parseInt(in.readLine());
            if ( n == 0 )
            {
                break;
            }
            TreeMap<String, Integer> conformity = new TreeMap<String, Integer>();
            while (n-- > 0)
            {
                String temp[] = in.readLine().split(" ");
                int course[] = new int[temp.length];
                for (int i = 0; i < temp.length; i++)
                {
                    course[i] = Integer.parseInt(temp[i]);
                }
                Arrays.sort(course);
                String courseKey = "";
                for (int i = 0; i < course.length; i++)
                {
                    courseKey += course[i] + "";
                }
                if ( conformity.get(courseKey) == null )
                {
                    conformity.put(courseKey, 1);
                } else
                {
                    conformity.put(courseKey, conformity.get(courseKey) + 1);
                }
            }
            int max = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entry : conformity.entrySet())
            {
                max = Math.max(max, entry.getValue());
            }
            int count = 0;
            for (Map.Entry<String, Integer> entry : conformity.entrySet())
            {
                if ( entry.getValue() == max )
                {
                    count += max;
                }
            }
            out.println(count);
        }
        System.exit(0);
    }
}
