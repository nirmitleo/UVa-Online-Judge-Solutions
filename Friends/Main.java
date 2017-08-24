package UVa.Friends;

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
    int size[];
    int max = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String arpp[]) throws IOException
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
            size = new int[n];
            for (int i = 0; i < p.length; i++)
            {
                p[i] = i;
                size[i] = 1;
            }
            int m = Integer.parseInt(tokens[1]);
            while (m-- > 0)
            {
                tokens = br.readLine().split(" ");
                unionSet(Integer.parseInt(tokens[0]) - 1, Integer.parseInt(tokens[1]) - 1);
            }
            System.out.println(max);
            max = 0;
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
                size[x] += size[y];
                max = Math.max(max, size[x]);
            }
            else
            {
                p[x] = y;
                size[y] += size[x];
                max = Math.max(max, size[y]);
                if (rank[x] == rank[y])
                {
                    rank[y]++;
                }
            }
        }
    }
}
