package UVa.DartAMania.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Nirmit on 17/07/2017.
 */
public class Main
{
    private String asterik = "**********************************************************************";
    private int count = 0;
    private int[] score = new int[3];
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
        StringBuilder sb = new StringBuilder("");
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n <= 0)
            {
                System.out.print(sb);
                System.out.println("END OF OUTPUT");
                return;
            }
            int p = 0;
            TreeSet<Item> set = new TreeSet<Item>();
            for (int i = 0; i <= 60; i++)
            {
                if (check(i))
                {
                    for (int j = 0; j <= 60; j++)
                    {
                        if (check(j))
                        {
                            int k = n - i - j;
                            if (check(k))
                            {
                                Item item = new Item(i, j, k);
                                if (!set.contains(item))
                                {
//                                            System.out.println(item);
                                    set.add(item);
                                    p += item.p;
                                }
                            }
                        }
                    }
                }
            }
            int c = set.size();
            if (c == 0)
            {
                sb.append("THE SCORE OF " + n + " CANNOT BE MADE WITH THREE DARTS.\n");
            } else
            {
                sb.append("NUMBER OF COMBINATIONS THAT SCORES " + n + " IS " + c + ".\n");
                sb.append("NUMBER OF PERMUTATIONS THAT SCORES " + n + " IS " + p + ".\n");
            }
            sb.append(asterik + "\n");
        }
    }

    public boolean check(int i)
    {
        boolean b1 = (i >= 0 && i <= 20);
        b1 |= (i > 20 && (i / 2 >= 0) && (i / 2 <= 20) && i % 2 == 0);
        b1 |= (i > 20 && (i / 3 >= 0) && (i / 3 <= 20) && i % 3 == 0);
        b1 |= (i == 50);
        return b1;
    }

    class Item implements Comparable<Item>
    {
        int a;
        int b;
        int c;
        int p;

        public Item(int a, int b, int c)
        {
            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));
            this.a = min;
            this.b = a + b + c - min - max;
            this.c = max;

            int same = 0;
            if (this.a == this.b)
            {
                same++;
            }
            if (this.b == this.c)
            {
                same++;
            }
            if (this.a == this.c)
            {
                same++;
            }
            if (same == 0)
            {
                p += 6;
            }
            if (same == 1)
            {
                p += 3;
            }
            if (same == 3)
            {
                p += 1;
            }
        }

        public int compareTo(Item that)
        {
            int aDiff = Integer.compare(this.a, that.a);
            if (aDiff == 0)
            {
                int bDiff = Integer.compare(this.b, that.b);
                return bDiff != 0 ? bDiff : Integer.compare(this.c, that.c);
            }
            return aDiff;
        }

        public String toString()
        {
            return a + " " + b + " " + c;
        }
    }

}
