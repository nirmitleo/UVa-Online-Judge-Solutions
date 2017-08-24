package UVa.BackTo8Queens;

import java.util.Scanner;

/**
 * Created by DELL on 12-Dec-15.
 */


public class Main
{

    int currentRow[];
    int row[];
    long leftDiagonal;
    long rightDiagonal;
    long rowDiagonal;
    int allCombinations[][] = new int[92][8];
    int index = 0;
    private static int caseCounter = 0;

    public static void main(String ar[])
    {
        Scanner in = new Scanner(System.in);

        Main demo = new Main();
        demo.row = new int[8];
        demo.placeQueens(0);
        while (in.hasNext())
        {
            demo.currentRow = new int[8];
            for (int i = 0; i < demo.currentRow.length; i++)
            {
                demo.currentRow[i] = in.nextInt() - 1;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < demo.allCombinations.length; i++)
            {
                int score = 0;
                for (int j = 0; j < demo.allCombinations[i].length; j++)
                {
                    score = (demo.currentRow[j] != demo.allCombinations[i][j]) ? score + 1 : score;
                }
                min = (score < min) ? score : min;
            }
            System.out.println("Case " + (++Main.caseCounter) + ": " + min);
        }

    }

    public void placeQueens(int col)
    {
        if (col == 8)
        {
            for (int i = 0; i < row.length; i++)
            {
                allCombinations[index][i] = row[i];
            }
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
