package UVa.FerryLoadingIV.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 11/06/2017.
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
            ArrayList<Integer> leftSide = new ArrayList<Integer>();
            ArrayList<Integer> rightSide = new ArrayList<Integer>();

            st = new StringTokenizer(in.readLine());
            int length = Integer.parseInt(st.nextToken()) * 100;
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++)
            {
                st = new StringTokenizer(in.readLine());
                int len = Integer.parseInt(st.nextToken());
                String side = st.nextToken();
                if (side.startsWith("l"))
                {
                    leftSide.add(len);
                } else
                {
                    rightSide.add(len);
                }
            }

            int best = 0;
            int count = leftSide.size() + rightSide.size();
            int left = -1;
            int right = -1;
            boolean isLeft = true;
            while (count > 0)
            {
                best++;
                int now = length;
                if (isLeft)
                {
                    isLeft = !isLeft;
                    for (int i = left + 1; i < leftSide.size(); i++)
                    {
                        int next = leftSide.get(i);
                        if (now - next < 0)
                        {
                            break;
                        }
                        count--;
                        now -= next;
                        left = i;
                    }
                } else
                {
                    isLeft = !isLeft;
                    for (int i = right + 1; i < rightSide.size(); i++)
                    {
                        int next = rightSide.get(i);
                        if (now - next < 0)
                        {
                            break;
                        }
                        count--;
                        now -= next;
                        right = i;
                    }
                }
            }
            System.out.println(best);
        }
    }
}
