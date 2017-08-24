package UVa.ExpertEnough.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 14/07/2017.
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
            String[] name = new String[n];
            int[] L = new int[n];
            int[] H = new int[n];
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                name[i] = st.nextToken();
                L[i] = Integer.parseInt(st.nextToken());
                H[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            int q = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder("");
            outer:
            for (int i = 0; i < q; i++)
            {
                st = new StringTokenizer(in.readLine());
                int p = Integer.parseInt(st.nextToken());
                String result = null;
                for (int j = 0; j < n; j++)
                {
                    if (p >= L[j] && p <= H[j])
                    {
                        if (result == null)
                        {
                            result = name[j];
                        } else
                        {
                            sb.append("UNDETERMINED\n");
                            continue outer;
                        }
                    }
                }
                if (result == null)
                {
                    sb.append("UNDETERMINED\n");
                } else
                {
                    sb.append(result + "\n");
                }
            }
            if (t == 1)
            {
                System.out.println(sb.toString().trim());
            } else
            {
                System.out.println("\n" + sb.toString().trim());
            }
        }


    }
}
