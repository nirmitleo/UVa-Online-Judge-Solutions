package UVa.DigitCounting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 30-Mar-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        Item list[] = new Item[10001];
        list[0] = new Item(0, new int[10]);
        for (int i = 1; i < 10001; i++)
        {
            int temp[] = new int[10];
            System.arraycopy(list[i - 1].a, 0, temp, 0, temp.length);
            int n = i;
            while (n != 0)
            {
                temp[n % 10]++;
                n /= 10;
            }
            list[i] = new Item(i, temp);
        }
        int test = Integer.parseInt(br.readLine().trim());

        while (test-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(list[n].toString());
        }
    }
}

class Item
{
    int id;
    int a[] = new int[10];

    public Item(int id, int a[])
    {
        this.id = id;
        this.a = a;
    }

    public String toString()
    {
        String result = "";
        for (int i = 0; i < a.length; i++)
        {
            result += a[i] + " ";
        }
        return result.trim();
    }
}

