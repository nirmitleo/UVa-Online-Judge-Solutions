package UVa.ProductOfDigits.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 10/07/2017.
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
        st = new StringTokenizer(in.readLine());
        int test = Integer.parseInt(st.nextToken());
        outer:
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0 || n == 1)
            {
                System.out.println(n);
                continue;
            }

            int f[] = {2, 3, 5, 7};
            int count[] = new int[10];
            for (int i = 0; i < f.length; i++)
            {
                while (n % f[i] == 0)
                {
                    switch (f[i])
                    {
                        case 2:
                            count[2]++;
                            break;
                        case 3:
                            count[3]++;
                            break;
                        case 5:
                            count[5]++;
                            break;
                        case 7:
                            count[7]++;
                            break;
                    }
                    n /= f[i];
                }
            }
            switch (n)
            {
                case 2:
                    count[2]++;
                    break;
                case 3:
                    count[3]++;
                    break;
                case 5:
                    count[5]++;
                    break;
                case 7:
                    count[7]++;
                    break;
                case 1:
                    break;
                default:
                    System.out.println(-1);
                    continue outer;
            }
            count[8] = count[2] / 3;
            count[2] %= 3; //0, 1, 2//

            count[9] = count[3] / 2;
            count[3] %= 2; //0, 1//

            count[4] = count[2] / 2;
            count[2] %= 2;

            count[6] = Math.min(count[2], count[3]);
            count[2] -= count[6];
            count[3] -= count[6];
            String result = "";
            for (int i = 0; i < 10; i++)
            {
                result += getString(i, count[i]);
            }
            System.out.println(result);
        }
    }

    public String getString(int n, int count)
    {
        String result = "";
        for (int i = 1; i <= count; i++)
        {
            result += n;
        }
        return result;
    }
}
