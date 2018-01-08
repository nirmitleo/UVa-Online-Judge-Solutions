package UVa.MoneyMatters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 06-Feb-16.
 */
public class Main
{
    int n;
    int p[];
    int rank[];
    int money[];
    boolean visited[];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            String tokens[] = br.readLine().split(" ");
            n = Integer.parseInt(tokens[0]);
            p = new int[n];
            rank = new int[n];
            money = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < p.length; i++)
            {
                money[i] = Integer.parseInt(br.readLine());
                p[i] = i;
            }
            int m = Integer.parseInt(tokens[1]);
            while (m-- > 0)
            {
                tokens = br.readLine().split(" ");
                unionSet(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
            }
            printResult();
        }
    }

    public void printResult()
    {
        for (int i = 0; i < visited.length; i++)
        {
            if (!visited[i] && findSetMoney(i) != 0)
            {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println("POSSIBLE");
    }

    public int findSetMoney(int i)
    {
        if (i == p[i])
        {
            visited[i] = true;
            return money[i];
        }
        else
        {
            visited[p[i]] = true;
            return findSetMoney(p[i]);
        }
    }

    public int findSet(int i)
    {
        return i == p[i] ? i : (p[i] = findSet(p[i]));
    }

    public boolean isSameSet(int i, int j)
    {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j)
    {
        if (!isSameSet(i, j))
        {
            int x = findSet(i);
            int y = findSet(j);
            if (rank[x] > rank[y])
            {
                p[y] = x;
                money[x] += money[y];
            }
            else
            {
                p[x] = y;
                money[y] += money[x];
                if (rank[x] == rank[y])
                {
                    rank[y]++;
                }
            }
        }
    }
}
