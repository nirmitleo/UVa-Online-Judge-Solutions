package UVa.MinimalCoverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DELL on 20-Mar-16.
 */
public class Main
{
    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine().trim());
        br.readLine();
        while (test-- > 0)
        {
            int m = Integer.parseInt(br.readLine().trim());
            ArrayList<Line> queue = new ArrayList<Line>();
            while (true)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int left = Integer.parseInt(tokens[0]);
                int right = Integer.parseInt(tokens[1]);
                if (right == left && right == 0)
                {
                    break;
                }
                queue.add(new Line(left, right));
            }
            Collections.sort(queue);


            int start = 0;
            int end = m;
            int count = 0;
            String result = "";
            while (start < end)
            {
                Line best = queue.get(0);
                int max = -1;
                boolean isSelected = false;
                for (int i = 0; i < queue.size(); i++)
                {
                    Line temp = queue.get(i);
                    int left = temp.left;
                    int right = temp.right;
                    if (left <= start && right > start)
                    {
                        if (max < right - start)
                        {
                            max = right - start;
                            best = temp;
                            isSelected = true;
                        }
                    } else if (left > start)
                    {
                        break;
                    }
                }
                if (!isSelected)
                {
                    start = 0;
                    break;
                }
                count++;
                result += best.left + " " + best.right + "\n";
                start = best.right;
            }
            result = count + "\n" + result;
            if (test == 0)
            {
                if (start == 0)
                {
                    System.out.print("0\n");
                } else
                {
                    System.out.print(result);
                }
            } else
            {
                if (start == 0)
                {
                    System.out.println("0\n");
                } else
                {
                    System.out.println(result);
                }
            }
            if (br.readLine() == null)
            {
                break;
            }
        }

    }
}

class Line implements Comparable<Line>
{
    int left;
    int right;

    public Line(int left, int right)
    {
        this.left = left;
        this.right = right;
    }

    public int compareTo(Line that)
    {
        int leftDiff = this.left - that.left;
        if (leftDiff < 0)
        {
            return -1;
        } else if (leftDiff > 0)
        {
            return 1;
        }
        return that.right - this.right;
    }
}
