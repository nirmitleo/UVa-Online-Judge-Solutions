package UVa.PlayOnWords.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class PlayOnWords
{
    private int V;
    private String[] vertices;
    private int[] p;
    private int[] r;
    private int left;


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        outer:
        for (int t = 1; t <= test; t++)
        {
            left = V = in.nextInt();
            vertices = new String[V];
            int[] inDeg = new int[26];
            int[] outDeg = new int[26];
            p = new int[V];
            r = new int[V];

            for (int i = 0; i < V; i++)
            {
                String s = in.next();
                char first = s.charAt(0);
                outDeg[first - 'a']++;
                char last = s.charAt(s.length() - 1);
                inDeg[last - 'a']++;
                vertices[i] = s;
                p[i] = i;
            }

            outer2:
            for (int i = 0; i < V; i++)
            {
                char x1 = vertices[i].charAt(0);
                char y1 = vertices[i].charAt(vertices[i].length() - 1);
                for (int j = i + 1; j < V; j++)
                {
                    char x2 = vertices[j].charAt(0);
                    char y2 = vertices[j].charAt(vertices[j].length() - 1);
                    if (y1 == x2 || x1 == y2)
                    {
                        join(i, j);
                        if (left == 1)
                        {
                            break outer2;
                        }
                    }
                }
            }
            if (left != 1)
            {
                out.println("The door cannot be opened.");
            } else
            {
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < 26; i++)
                {
                    if (inDeg[i] != outDeg[i])
                    {
                        int diff = inDeg[i] - outDeg[i];
                        if (diff == -1)
                        {
                            count1++;
                        } else if (diff == 1)
                        {
                            count2++;
                        } else
                        {
                            out.println("The door cannot be opened.");
                            continue outer;
                        }
                    }
                }
                if ((count1 == 1 && count2 == 1) || (count1 + count2 == 0))
                {
                    out.println("Ordering is possible.");
                } else
                {
                    out.println("The door cannot be opened.");
                }
            }
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

    public void join(int i, int j)
    {
        if (!isSameSet(i, j))
        {
            left--;
            int X = findSet(i);
            int Y = findSet(j);
            if (r[X] > r[Y])
            {
                p[Y] = X;
            } else
            {
                p[X] = Y;
                if (r[X] == r[Y])
                {
                    r[Y]++;
                }
            }
        }
    }

}
