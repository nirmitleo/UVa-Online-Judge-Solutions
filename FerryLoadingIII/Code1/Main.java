package UVa.FerryLoadingIII.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Car> leftSide = new ArrayList<Car>();
            ArrayList<Car> rightSide = new ArrayList<Car>();
            for (int i = 0; i < m; i++)
            {
                st = new StringTokenizer(in.readLine());
                int clock = Integer.parseInt(st.nextToken());
                if (st.nextToken().startsWith("left"))
                {
                    leftSide.add(new Car(i, clock));
                } else
                {
                    rightSide.add(new Car(i, clock));
                }
            }
            Collections.sort(leftSide);
            Collections.sort(rightSide);
            int[] result = new int[m];

            int total = m;
            int left = -1;
            int right = -1;
            boolean isLeft = true;
            int now = 0;
            while (total > 0)
            {
                int c = 0;
                total -= n;
                if (isLeft)
                {
                    isLeft = !isLeft;
                    now = Math.max(now + t, leftSide.get(left + n).time + t);
                    for (int i = left + 1; i < leftSide.size() && c < n; i++, c++)
                    {
                        Car car = leftSide.get(i);
                        result[car.id] = now;
                    }
                } else
                {
                    isLeft = !isLeft;
                    now = Math.max(now + t, rightSide.get(right + n).time + t);
                    for (int i = right + 1; i < rightSide.size() && c < n; i++, c++)
                    {
                        Car car = rightSide.get(i);
                        result[car.id] = now;
                    }
                }
            }
            for (int i = 0; i < m; i++)
            {
                System.out.println(result[i]);
            }
            if (t != test)
            {
                System.out.println();
            }
        }
    }

    class Car implements Comparable<Car>
    {
        int id;
        int time;

        public Car(int id, int time)
        {
            this.id = id;
            this.time = time;
        }

        public int compareTo(Car that)
        {
            int timeDiff = Integer.compare(this.time, that.time);
            return timeDiff != 0 ? timeDiff : Integer.compare(this.id, that.id);
        }
    }
}
