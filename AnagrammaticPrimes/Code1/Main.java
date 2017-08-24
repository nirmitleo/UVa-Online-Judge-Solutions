package UVa.AnagrammaticPrimes.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 07/07/2017.
 */
public class Main
{
    private char[] a;
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
//        demo.test1();
        demo.test();
    }

    public void test() throws IOException
    {
        int[] t = new int[]{2,
                3,
                5,
                7,
                11,
                13,
                17,
                31,
                37,
                71,
                73,
                79,
                97,
                113,
                131,
                199,
                311,
                337,
                373,
                733,
                919,
                991};
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            int low = -1;
            int high = 22;
            while (high - low > 1)
            {
                int mid = low + (high - low) / 2;
                if (t[mid] <= n)
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
            if (high == 22 || (high < 22 && t[high] >= Math.pow(10, (n + "").length())))
            {
                System.out.println(0);
            } else
            {
                System.out.println(t[high]);
            }
        }
    }

    public void solve() throws IOException
    {
        int P = 664579;
        int N = (int) 1e7;
        boolean[] seive = new boolean[N + 1];
        int[] primes = new int[P];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                seive[j] = false;
            }
        }

        for (int i = 0, j = 0; i <= N; i++)
        {
            if (seive[i])
            {
                primes[j++] = i;
            }
        }
        int A = 22;
        int[] ap = new int[A];
        outer:
        for (int i = 0, j = 0; i < P; i++)
        {
            a = (primes[i] + "").toCharArray();
            Arrays.sort(a);
            do
            {
                int t = Integer.parseInt(new String(a));
                int index = Arrays.binarySearch(primes, t);
                if (index < 0 || index >= P)
                {
                    continue outer;
                }
            } while (nextPermutation());
            ap[j++] = primes[i];
            //System.out.println(primes[i]);
        }
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
            {
                return;
            }
            int low = -1;
            int high = A;
            while (high - low > 1)
            {
                int mid = low + (high - low) / 2;
                if (ap[mid] <= n)
                {
                    low = mid;
                } else
                {
                    high = mid;
                }
            }
            if (high == A)
            {
                System.out.println(0);
            } else
            {
                System.out.println(ap[high]);
            }
        }
    }

    public boolean nextPermutation()
    {
        int N = a.length;
        int i = N - 2;
        for (; i >= 0; i--)
        {
            if (a[i] < a[i + 1])
            {
                break;
            }
        }
        if (i == -1)
        {
            return false;
        }
        for (int j = N - 1; j > i; j--)
        {
            if (a[i] < a[j])
            {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }
        }
        for (int start = i + 1, end = N - 1; start < end; start++, end--)
        {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
        return true;
    }
}
