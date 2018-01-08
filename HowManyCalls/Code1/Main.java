package UVa.HowManyCalls.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 01-05-2017.
 */
public class Main
{

    private String line = "";
    private StringTokenizer tokens;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = 1;
        while (true)
        {
            line = br.readLine();
            if (line == null || line.trim().length() == 0)
            {
                out.flush();
                out.close();
                return;
            }
            tokens = new StringTokenizer(line);
            long n = Long.parseLong(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            if (n == 0 && b == 0)
            {
                out.flush();
                out.close();
                return;
            }
            BigInteger result = BigInteger.ONE;
            result = fastExp(n, b);
            result = ((((result.multiply(BigInteger.valueOf(2L))).mod(BigInteger.valueOf(b)).subtract(BigInteger.ONE).mod(BigInteger.valueOf(b)))));
            out.println("Case " + test + ": " + n + " " + b + " " + result.intValue());
            test++;
        }
    }

    public BigInteger fastExp(long exp, int MOD)
    {
        Matrix result = new Matrix(2, 2);
        result.matrix[0][0] = BigInteger.ONE;
        result.matrix[1][1] = BigInteger.ONE;
        result.matrix[1][0] = BigInteger.ZERO;
        result.matrix[0][1] = BigInteger.ZERO;

        Matrix base = new Matrix(2, 2);
        base.matrix[0][0] = BigInteger.ONE;
        base.matrix[0][1] = BigInteger.ONE;
        base.matrix[1][0] = BigInteger.ONE;
        base.matrix[1][1] = BigInteger.ZERO;
        while (exp > 0)
        {
            if ((exp & 1) > 0)
            {
                result = multiply(result, base, MOD);
            }
            base = multiply(base, base, MOD);
            exp /= 2;
        }

        Matrix given = new Matrix(2, 1);
        given.matrix[0][0] = BigInteger.ONE;
        given.matrix[1][0] = BigInteger.ONE;
        result = multiply(result, given, MOD);
        return result.matrix[1][0];
    }

    public Matrix multiply(Matrix a, Matrix b, long MOD)
    {
        Matrix c = new Matrix(a.row, b.col);
        for (int i = 0; i < c.row; i++)
        {
            for (int j = 0; j < c.col; j++)
            {
                c.matrix[i][j] = BigInteger.ZERO;
                for (int k = 0; k < a.col; k++)
                {
                    c.matrix[i][j] = (c.matrix[i][j].add(((a.matrix[i][k].multiply(b.matrix[k][j])).mod(BigInteger.valueOf(MOD)).mod(BigInteger.valueOf(MOD)))));
                    //c.matrix[i][j] = (c.matrix[i][j] + (a.matrix[i][k] * b.matrix[k][j]));
                }
            }
        }
        return c;
    }

    class Matrix
    {
        int row;
        int col;
        BigInteger matrix[][];

        public Matrix(int row, int col)
        {
            this.row = row;
            this.col = col;
            matrix = new BigInteger[row][col];
        }
    }
}
