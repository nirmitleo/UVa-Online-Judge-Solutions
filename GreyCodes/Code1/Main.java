package UVa.GreyCodes.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 12/06/2017.
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
        for (int t = 1; t <= test; t++)
        {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String bin = Integer.toBinaryString(k);
            while (bin.length() < n)
            {
                bin = "0" + bin;
            }

            String result = "";
            for (int i = n - 2; i >= 0; i--)
            {
                char ch1 = bin.charAt(i);
                char ch2 = bin.charAt(i + 1);
                if ((ch1 == '0' && ch2 == '1') || (ch1 == '1' && ch2 == '0'))
                {
                    result = "1" + result;
                } else
                {
                    result = "0" + result;
                }
            }
            result = bin.charAt(0) + result;
            System.out.println(Integer.parseInt(result, 2));
        }
    }
}
