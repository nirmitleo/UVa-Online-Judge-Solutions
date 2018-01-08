package UVa.MakePalindrome.Code2;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MakePalindromeTestCase
{
    private Random r = new Random();

    @TestCase
    public Collection<Test> createTests()
    {
        int T = 0;
        ArrayList<Test> tests = new ArrayList<>();
        for (int t = 1; t <= T; t++)
        {
            StringWriter sw = new StringWriter();
            int n = nextInt(3, 6);
            String s = "";
            for (int i = 0; i < n; i++)
            {
                char ch = ((char) ('a' + nextInt(0, 4)));
                s += ch;
            }
            tests.add(new Test(s));
        }
        return tests;
    }

    private int nextInt(int min, int max)
    {
        return r.nextInt(max - min + 1) + min;
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
