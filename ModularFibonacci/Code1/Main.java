package UVa.ModularFibonacci.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 01-05-2017.
 */
public class Main
{

    private String line;
    private StringTokenizer tokens;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        while (true)
        {
            line = br.readLine();
            if (line == null || line.length() == 0)
            {
                return;
            }
            tokens = new StringTokenizer(line);
            int exp = Integer.parseInt(tokens.nextToken());
            int MOD = Integer.parseInt(tokens.nextToken());
            MOD = (1 << MOD);
            long result = fastExp(exp, MOD);
            System.out.println(result);
        }
    }

    public long fastExp(int exp, int MOD)
    {
        Matrix base = new Matrix(2, 2);
        base.matrix[0][0] = 1;
        base.matrix[0][1] = 1;
        base.matrix[1][0] = 1;

        Matrix result = new Matrix(2, 2);
        result.matrix[0][0] = 1;
        result.matrix[1][1] = 1;

        while (exp > 0)
        {
            if ((exp & 1) > 0)
            {
                result = multiply(result, base, MOD);
            }
            base = multiply(base, base, MOD);
            exp /= 2;
        }
        return result.matrix[0][1] % MOD;
    }

    public Matrix multiply(Matrix a, Matrix b, int MOD)
    {
        Matrix c = new Matrix(2, 2);
        for (int i = 0; i < c.row; i++)
        {
            for (int j = 0; j < c.col; j++)
            {
                for (int k = 0; k < a.col; k++)
                {
                    c.matrix[i][j] = ((c.matrix[i][j] + (a.matrix[i][k] * b.matrix[k][j]) % MOD) % MOD);
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
            matrix = new long[row][col];
        }
    }

}

