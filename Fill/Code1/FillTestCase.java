package UVa.Fill.Code1;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class FillTestCase
{
    private Random r = new Random();

    @TestCase
    public Collection<Test> createTests()
    {
        int T = 10;
        StringWriter sw = new StringWriter();
        sw.append(T + "\n");
        ArrayList<Test> tests = new ArrayList<>();
        for (int t = 1; t <= T; t++)
        {
            int a = getRandom(2, 10);
            int b = getRandom(2, 10);
            int c = getRandom(2, 10);
            int A = Math.min(a, Math.min(b, c));
            int C = Math.max(a, Math.max(b, c));
            int B = a + b + c - A - C;
            int D = getRandom(1, C);
            sw.append(A + " " + B + " " + C + " " + D + "\n");
        }
        tests.add(new Test(sw.toString()));
        return tests;
    }

    public int getRandom(int min, int max)
    {
        return r.nextInt(max - min + 1) + min;
    }
}
