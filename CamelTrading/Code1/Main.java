package UVa.CamelTrading.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 22/06/2017.
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
            line = in.readLine().trim();
            String num = "";
            ArrayList<String> mulAdd = new ArrayList<>();
            ArrayList<String> addMul = new ArrayList<>();
            for (int i = 0; i < line.length(); i++)
            {
                char ch = line.charAt(i);
                if (ch == '+' || ch == '*')
                {
                    mulAdd.add(num);
                    addMul.add(num + "");
                    num = "";
                    mulAdd.add(ch + "");
                    addMul.add(ch + "");

                } else
                {
                    num += ch;
                }
            }
            mulAdd.add(num);
            addMul.add(num + "");


            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < mulAdd.size(); i++)
            {
                String s = mulAdd.get(i);
                if (s.contains("*"))
                {
                    long a = Long.parseLong(temp.remove(temp.size() - 1));
                    long b = Long.parseLong(mulAdd.get(i + 1));
                    temp.add((a * b) + "");
                    i++;
                } else
                {
                    temp.add(s);
                }
            }
            mulAdd = temp;
            temp = new ArrayList<>();
            for (int i = 0; i < mulAdd.size(); i++)
            {
                String s = mulAdd.get(i);
                if (s.contains("+"))
                {
                    long a = Long.parseLong(temp.remove(temp.size() - 1));
                    long b = Long.parseLong(mulAdd.get(i + 1));
                    temp.add((a + b) + "");
                    i++;
                } else
                {
                    temp.add(s);
                }
            }
            mulAdd = temp;
            String min = mulAdd.get(0);


            temp = new ArrayList<>();
            for (int i = 0; i < addMul.size(); i++)
            {
                String s = addMul.get(i);
                if (s.contains("+"))
                {
                    long a = Long.parseLong(temp.remove(temp.size() - 1));
                    long b = Long.parseLong(addMul.get(i + 1));
                    temp.add((a + b) + "");
                    i++;
                } else
                {
                    temp.add(s);
                }
            }
            addMul = temp;
            temp = new ArrayList<>();
            for (int i = 0; i < addMul.size(); i++)
            {
                String s = addMul.get(i);
                if (s.contains("*"))
                {
                    long a = Long.parseLong(temp.remove(temp.size() - 1));
                    long b = Long.parseLong(addMul.get(i + 1));
                    temp.add((a * b) + "");
                    i++;
                } else
                {
                    temp.add(s);
                }
            }
            addMul = temp;
            String max = addMul.get(0);
            System.out.println("The maximum and minimum are " + max + " and " + min + ".");


        }

    }

}
