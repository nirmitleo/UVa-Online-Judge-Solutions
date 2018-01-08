package UVa.QueensChessProblem;

import java.util.Scanner;

/**
 * Created by DELL on 10-Dec-15.
 */
public class Main
{
    int pRow;
    int pCol;
    int row[];
    int lineNumber;
    boolean leftDiagonal[];
    boolean rightDiagonal[];
    boolean r[];
    /*long leftDiagonal;
    long rightDiagonal;
    long r;*/

    private static boolean isFirst = true;

    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        Main demo = new Main();
        int t = in.nextInt();
        while (t-- > 0)
        {
            demo.pRow = in.nextInt() - 1;
            demo.pCol = in.nextInt() - 1;
            demo.row = new int[8];
            demo.leftDiagonal = new boolean[2 * demo.row.length - 1];
            demo.rightDiagonal = new boolean[2 * demo.row.length - 1];
            demo.r = new boolean[demo.row.length];
            demo.lineNumber = 0;
            System.out.println("SOLN       COLUMN");
            System.out.println(" #      1 2 3 4 5 6 7 8\n");
            demo.placeQueens(0);
            if (t > 0)
            {
                System.out.println();
            }
        }
    }

    /*public void placeQueens(int col)
    {
        if (col == 8 && row[pCol] == pRow)
        {
            System.out.format("%2d      %d", (++lineNumber), row[0] + 1);
            for (int j = 1; j < row.length; j++)
            {
                System.out.printf(" %d", row[j] + 1);
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < row.length; j++)
        {
            boolean isLeftDiagonalMarked = (leftDiagonal & (1 << (j - col + row.length))) != 0;
            boolean isRightDiagonalMarked = (rightDiagonal & (1 << (j + col))) != 0;
            boolean isRowMarked = (r & (1 << j)) != 0;
            if (!isLeftDiagonalMarked && !isRightDiagonalMarked && !isRowMarked)
            {
                row[col] = j;
                leftDiagonal |= (1 << (j - col + row.length));
                rightDiagonal |= (1 << (j + col));
                r |= (1 << j);
                placeQueens(col + 1);
                leftDiagonal &= ~(1 << (j - col + row.length));
                rightDiagonal &= ~(1 << (j + col));
                r &= ~(1 << j);
            }
        }
    }*/

    public void placeQueens(int col)
    {
        if (col == 8)
        {
            if (row[pCol] == pRow)
            {
                System.out.format("%2d      %d", (++lineNumber), row[0] + 1);
                for (int j = 1; j < row.length; j++)
                {
                    System.out.printf(" %d", row[j] + 1);
                }
                System.out.println();
            }
            return;
        }
        for (int j = 0; j < row.length; j++)
        {
            if (!leftDiagonal[col - j + row.length - 1] && !rightDiagonal[j + col] && !r[j])
            {
                row[col] = j;
                leftDiagonal[col - j + row.length - 1] = true;
                rightDiagonal[j + col] = true;
                r[j] = true;
                placeQueens(col + 1);
                leftDiagonal[col - j + row.length - 1] = false;
                rightDiagonal[j + col] = false;
                r[j] = false;
            }
        }
    }
}
