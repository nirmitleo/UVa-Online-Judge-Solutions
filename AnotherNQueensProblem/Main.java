package UVa.AnotherNQueensProblem;

/**
 * Created by DELL on 17-Dec-15.
 */

import java.util.Scanner;


/**
 * Created by DELL on 12-Dec-15.
 */


public class Main
{

    int row[];
    long leftDiagonal;
    long rightDiagonal;
    long rowDiagonal;
    int index = 0;

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);

        while (in.hasNext())
        {
            Main demo = new Main();

            int n = in.nextInt();
            demo.row = new int[n];
            demo.placeQueens(0);
            System.out.println("N = " + (n) + ": " + demo.index);
        }
    }


    public void placeQueens(int col)
    {
        if (col == row.length)
        {
            index++;
            return;
        }
        for (int i = 0; i < row.length; i++)
        {
            boolean isLeftDiagonalMarked = (leftDiagonal & (1 << (col - i + row.length - 1))) != 0;
            boolean isRightDiagonalMarked = (rightDiagonal & (1 << col + i)) != 0;
            boolean isRowDiagonalMarked = (rowDiagonal & (1 << i)) != 0;
            if (!isLeftDiagonalMarked && !isRightDiagonalMarked && !isRowDiagonalMarked)
            {
                row[col] = i;
                leftDiagonal |= (1 << (col - i + row.length - 1));
                rightDiagonal |= (1 << (col + i));
                rowDiagonal |= (1 << i);
                placeQueens(col + 1);
                leftDiagonal &= ~(1 << (col - i + row.length - 1));
                rightDiagonal &= ~(1 << (col + i));
                rowDiagonal &= ~(1 << i);
            }
        }
    }
}

