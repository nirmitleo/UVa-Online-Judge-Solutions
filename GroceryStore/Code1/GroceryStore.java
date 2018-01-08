package UVa.GroceryStore.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

import java.util.PriorityQueue;

public class GroceryStore
{
    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        for (long i = 1; i <= 2000; i++)
        {
            for (long j = i; j <= 2000; j++)
            {
                if (i + j > 2000 || i * j > 2_00_00) continue;
                for (long k = j; k <= 2000; k++)
                {
                    if (i == 125 && j == 160 && k == 175)
                    {
                        System.out.println("hi");
                    }
                    if (i + j + k > 2000 || i * j * k > 2_00_00_00) continue;
                    long p = i * j * k;
                    for (long x = 1; x <= 2_00_00_00_00L / p; x++)
                    {
                        long a = i * j * k * x;
                        long b = i + j + k + x;
                        if (a == b * 1_000_000)
                        {
                            PriorityQueue<Long> set = new PriorityQueue<>();
                            set.add(i);
                            set.add(j);
                            set.add(k);
                            set.add(x);
                            out.println((set.poll() / 100.0) + " " + (set.poll() / 100.0) + " " + (set.poll() / 100.0) + " " + (set.poll() / 100.0));
                        }
                    }
                }
            }
        }
    }
}
