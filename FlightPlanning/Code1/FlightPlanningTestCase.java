package UVa.FlightPlanning.Code1;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.io.StringWriter;
import java.util.*;

public class FlightPlanningTestCase
{
    private Random r = new Random();

    @TestCase
    public Collection<Test> createTests()
    {
        ArrayList<Test> tests = new ArrayList<>();
        int T = 0;
        if (T == 0)
        {
            return tests;
        }
        StringWriter sw = new StringWriter();
        sw.append(T + "\n");
        for (int t = 1; t <= T; t++)
        {
            int n = nextInt(10, 70);
            sw.append(n + "\n");
            ArrayList<Integer> vertices = new ArrayList<>();
            for (int i = 0; i < n; i++)
            {
                vertices.add(i + 1);
            }

            Collections.shuffle(vertices);
            for (int i = 1; i < n; i++)
            {
                sw.append(vertices.get(i - 1) + " " + vertices.get(i) + "\n");
            }
        }
        tests.add(new Test(sw.toString()));
        return tests;
    }

    private void slow(String input)
    {

    }

    private int nextInt(int min, int max)
    {
        return r.nextInt(max - min + 1) + min;
    }

    private Integer[] getDistinctInteger(int n, int min, int max)
    {
        if (max - min + 1 < n)
        {
            throw new RuntimeException();
        }
        TreeSet<Integer> set = new TreeSet<>();
        while (set.size() < n)
        {
            int num = nextInt(min, max);
            set.add(num);
        }
        Integer[] a = new Integer[n];
        set.toArray(a);
        return a;
    }

    private String createRandomTree(int n, int offset)
    {
        String s = n + "\n";

        ArrayList<Integer> vertices = new ArrayList<>();
        for (int i = offset; i < offset + n; i++)
        {
            vertices.add(i);
        }

        Collections.shuffle(vertices);
        for (int i = 1; i < n; i++)
        {
            int from = vertices.get(i - 1);
            int to = vertices.get(i);
            s += from + " " + to + "\n";
        }
        return s;
    }
}
