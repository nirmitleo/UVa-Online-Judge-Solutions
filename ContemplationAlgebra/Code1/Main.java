package UVa.ContemplationAlgebra.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 02-05-2017.
 */
public class Main
{
    private String line;
    private StringTokenizer tokens;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String a[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while (true)
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                out.flush();
                out.close();
                return;
            }
            tokens = new StringTokenizer(line);
            long p = Long.parseLong(tokens.nextToken());
            long q = Long.parseLong(tokens.nextToken());
            if (!tokens.hasMoreTokens() && p == 0 && q == 0)
            {
                out.flush();
                out.close();
                return;
            }
            long n = Long.parseLong(tokens.nextToken());
            long result = fastExp(n, p, q);
            out.println(result);
        }
    }

    public long fastExp(long exp, long p, long q)
    {
        Matrix result = new Matrix(2, 2);
        result.matrix[0][0] = 1L;
        result.matrix[1][1] = 1L;

        Matrix base = new Matrix(2, 2);
        base.matrix[0][0] = p;
        base.matrix[0][1] = -q;
        base.matrix[1][0] = 1L;
        base.matrix[1][1] = 0;

        while (exp > 0)
        {
            if ((exp & 1) > 0)
            {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp /= 2;
        }

        Matrix given = new Matrix(2, 1);
        given.matrix[0][0] = p;
        given.matrix[1][0] = 2;

        result = multiply(result, given);
        return result.matrix[1][0];
    }

    public Matrix multiply(Matrix a, Matrix b)
    {
        Matrix c = new Matrix(a.row, b.col);
        for (int i = 0; i < c.row; i++)
        {
            for (int j = 0; j < c.col; j++)
            {
                for (int k = 0; k < a.col; k++)
                {
                    c.matrix[i][j] += (a.matrix[i][k] * b.matrix[k][j]);
                }
            }
        }
        return c;
    }

    class Matrix
    {
        int row;
        int col;
        long matrix[][];

        public Matrix(int row, int col)
        {
            this.row = row;
            this.col = col;
            this.matrix = new long[row][col];
        }
    }

}
