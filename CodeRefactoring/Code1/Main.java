package UVa.CodeRefactoring.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 24/06/2017.
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
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 2; i * i <= n; i++)
            {
                if (n % i == 0)
                {
                    if (n / i != i)
                    {
                        result.add(n / i);
                        result.add(i);
                    }
                }
            }
            String print = "Case #" + t + ": " + n + " = ";
            System.out.println(print + result.get(0) + " * " + result.get(1) + " = " + result.get(2) + " * " + result.get(3));;
        }

    }
}
