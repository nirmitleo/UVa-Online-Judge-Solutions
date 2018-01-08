package UVa.MappingTheSwaps.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 16/06/2017.
 */
public class Main
{
    private int N;
    private int S;
    private int[] a;
    private int[] sorted;
    private int[] x1;
    private int[] x2;
    private int result;
    private TreeSet<String> set;

    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        for (int t = 1; ; t++)
        {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            result = 2 * N;
            set = new TreeSet<String>();
            if (N == 0)
            {
                return;
            }
            a = new int[N];
            sorted = new int[N];
            for (int i = 0; i < N; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
                sorted[i] = a[i];
            }
            Arrays.sort(sorted);

            S = N - 1;
            x1 = new int[S];
            x2 = new int[S];
            for (int i = 0; i < N - 1; i++)
            {
                x1[i] = i;
                x2[i] = i + 1;
            }
            go(0, "");
            System.out.println("There are " + set.size() + " swap maps for input data set " + t + ".");
//            while (!set.isEmpty())
//            {
//                System.out.println(set.pollFirst());
//            }
        }
    }

    public void go(int i, String map)
    {
        if (Arrays.equals(a, sorted))
        {
            if (result >= i)
            {
                if (result == i)
                {
                    if (map.length() > 0)
                    {
                        set.add(map);
                    }
                } else
                {
                    if (map.length() > 0)
                    {
                        result = i;
                        set = new TreeSet<String>();
                        set.add(map);
                    }
                }
            }
        } else
        {
            if (i > result)
            {
                return;
            }
            for (int k = 0; k < S; k++)
            {
                int index1 = x1[k];
                int index2 = x2[k];
                swap(index1, index2);
                go(i + 1, map + index1);
                swap(index1, index2);
            }
        }
    }

    public void swap(int x1, int x2)
    {
        int temp = a[x1];
        a[x1] = a[x2];
        a[x2] = temp;
    }
}
