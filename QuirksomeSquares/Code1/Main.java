package UVa.QuirksomeSquares.Code1;

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
//        StringBuilder sb = new StringBuilder("");
//        for (int i = 0; i <= 9; i++)
//        {
//            for (int j = 0; j <= 9; j++)
//            {
//                int num = i * 10 + j;
//                if ((i + j) * (i + j) == num)
//                {
//                    sb.append(i + "" + j + "\n");
//                }
//            }
//        }
//        System.out.println(sb);
//
//        sb = new StringBuilder("");
//        for (int a = 0; a < 10; a++)
//        {
//            for (int b = 0; b < 10; b++)
//            {
//                for (int c = 0; c < 10; c++)
//                {
//                    for (int d = 0; d < 10; d++)
//                    {
//                        int num = a * 1000 + b * 100 + c * 10 + d;
//                        int first = a * 10 + b;
//                        int second = c * 10 + d;
//                        if ((first + second) * (first + second) == num)
//                        {
//                            sb.append("" + a + b + c + d + "\n");
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(sb);
//
//        sb = new StringBuilder("");
//        for (int a = 0; a < 10; a++)
//        {
//            for (int b = 0; b < 10; b++)
//            {
//                for (int c = 0; c < 10; c++)
//                {
//                    for (int d = 0; d < 10; d++)
//                    {
//                        for (int e = 0; e < 10; e++)
//                        {
//                            for (int f = 0; f < 10; f++)
//                            {
//                                int num = a * 100000 + b * 10000 + c * 1000 + d * 100 + e * 10 + f;
//                                int first = a * 100 + b * 10 + c;
//                                int second = d * 100 + e * 10 + f;
//                                if ((first + second) * (first + second) == num)
//                                {
//                                    sb.append("" + a + b + c + d + e + f + "\n");
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(sb);
//
//        sb = new StringBuilder("");
//        for (int a = 0; a < 10; a++)
//        {
//            for (int b = 0; b < 10; b++)
//            {
//                for (int c = 0; c < 10; c++)
//                {
//                    for (int d = 0; d < 10; d++)
//                    {
//                        for (int e = 0; e < 10; e++)
//                        {
//                            for (int f = 0; f < 10; f++)
//                            {
//                                for (int internalGraph = 0; internalGraph < 10; internalGraph++)
//                                {
//                                    for (int h = 0; h < 10; h++)
//                                    {
//                                        int num = a * 10000000 + b * 1000000 + c * 100000 + d * 10000 + e * 1000 + f * 100 + internalGraph * 10 + h;
//                                        int first = a * 1000 + b * 100 + c * 10 + d;
//                                        int second = e * 1000 + f * 100 + internalGraph * 10 + h;
//                                        if ((first + second) * (first + second) == num)
//                                        {
//                                            sb.append("" + a + b + c + d + e + f + internalGraph + h + "\n");
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(sb);
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            if (n == 2)
            {
                System.out.print("00\n" +
                        "01\n" +
                        "81\n");
            } else if (n == 4)
            {
                System.out.print("0000\n" +
                        "0001\n" +
                        "2025\n" +
                        "3025\n" +
                        "9801\n");
            } else if (n == 6)
            {
                System.out.print("000000\n" +
                        "000001\n" +
                        "088209\n" +
                        "494209\n" +
                        "998001\n");
            } else
            {
                System.out.print("00000000\n" +
                        "00000001\n" +
                        "04941729\n" +
                        "07441984\n" +
                        "24502500\n" +
                        "25502500\n" +
                        "52881984\n" +
                        "60481729\n" +
                        "99980001\n");
            }
        }

    }
}
