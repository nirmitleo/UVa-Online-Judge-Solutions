package UVa.BinomialTheorem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 29-Mar-16.
 */
public class Main
{
    private long binomialCoeff[][] = new long[51][51];
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
        for (int i = 0; i < binomialCoeff.length; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || i == j)
                {
                    binomialCoeff[i][j] = 1;
                } else
                {
                    binomialCoeff[i][j] = binomialCoeff[i - 1][j] + binomialCoeff[i - 1][j - 1];
                }
            }
        }
        int test = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= test; t++)
        {
            String result = "";
            String expression = br.readLine().trim();
            int from = expression.indexOf("(");
            int to = expression.indexOf("+");
            String operand1 = expression.substring(from + 1, to);

            from = to;
            to = expression.indexOf(")");
            String operand2 = expression.substring(from + 1, to);

            int power = Integer.parseInt(expression.substring(expression.indexOf("^") + 1).trim());

            for (int i = 0; i < power + 1; i++)
            {
                if (i == 0)
                {
                    result += power - i == 1 ? operand1 + "+" : operand1 + "^" + (power - i) + "+";
                } else if (i == power)
                {
                    result += i == 1 ? operand2 : operand2 + "^" + i;
                } else
                {
                    if (power - i == 1 && i == 1)
                    {
                        result += binomialCoeff[power][i] + "*" + operand1 + "*" + operand2 + "+";
                    } else if (power - i == 1)
                    {
                        result += binomialCoeff[power][i] + "*" + operand1 + "*" + operand2 + "^" + i + "+";
                    } else if (i == 1)
                    {
                        result += binomialCoeff[power][i] + "*" + operand1 + "^" + (power - i) + "*" + operand2 + "+";
                    } else
                    {
                        result += binomialCoeff[power][i] + "*" + operand1 + "^" + (power - i) + "*" + operand2 + "^" + i + "+";
                    }
                }
            }
            System.out.println("Case " + t + ": " + result);
        }
    }
}

