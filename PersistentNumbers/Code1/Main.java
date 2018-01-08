package UVa.PersistentNumbers.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 11/07/2017.
 */
public class Main
{

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
        for (; ; )
        {
            st = new StringTokenizer(in.readLine());
            BigInteger N = new BigInteger(st.nextToken());

            if (N.compareTo(BigInteger.ZERO) < 0)
            {
                return;
            }
            if ((N + "").length() == 1)
            {
                System.out.println("1" + N);
                continue;
            }
            BigInteger num = N;
            int[] f = new int[10];
            for (int i = 2; i < 10 && check(i, N); i++)
            {
                BigInteger I = BigInteger.valueOf(i);
                int count = 0;
                while (num.mod(I).compareTo(BigInteger.ZERO) == 0)
                {
                    count++;
                    num = num.divide(I);
                }
                if (count > 0)
                {
                    f[i] = count;
                }
            }
            if (num.compareTo(BigInteger.valueOf(10L)) >= 0)
            {
                System.out.println("There is no such number.");
                continue;
            }
            if (num.compareTo(BigInteger.ONE) > 0)
            {
                f[num.intValue()]++;
            }
            f[8] = f[2] / 3;
            f[2] %= 3; //0, 1, 2//
            f[9] = f[3] / 2;
            f[3] %= 2; //0, 1//
            f[6] += Math.min(f[2], f[3]);
            f[2] -= f[6];
            f[3] -= f[6];
            f[4] = f[2] / 2;
            f[2] %= 2;
            String result = "";
            for (int i = 2; i < 10; i++)
            {
                result += getString(i, f[i]);
            }
            System.out.println(result);
        }

    }

    public boolean check(long i, BigInteger N)
    {
        return BigInteger.valueOf(i * 1L * i).compareTo(N) <= 0;
    }


    public String getString(int num, int count)
    {
        String result = "";
        for (int i = 1; i <= count; i++)
        {
            result += num;
        }
        return result;
    }
}
