package UVa.MappingTheRoute.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by DELL on 02-Jul-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private int row;
    private int col;
    private int map[][];
    private boolean was[][];
    private int trace[][];
    private final int QUESTION_MARK = -100;
    private Stack<Point> stack;

    public void solve() throws IOException
    {
        int test = 1;
        while (true)
        {
            int startRow = 0;
            int startCol = 0;
            int endRow = 0;
            int endCol = 0;
            int index = 0;
            while (index < 6)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int i = 0; i < tokens.length; i++)
                {
                    if (tokens[i].trim().equals(""))
                    {
                        continue;
                    }
                    switch (index)
                    {
                        case 0:
                            row = Integer.parseInt(tokens[i]);
                            break;
                        case 1:
                            col = Integer.parseInt(tokens[i]);
                            break;
                        case 2:
                            startRow = Integer.parseInt(tokens[i]) - 1;
                            break;
                        case 3:
                            startCol = Integer.parseInt(tokens[i]) - 1;
                            break;
                        case 4:
                            endRow = Integer.parseInt(tokens[i]) - 1;
                            break;
                        case 5:
                            endCol = Integer.parseInt(tokens[i]) - 1;
                            break;
                    }
                    index++;
                }
            }
            if (row + col + startRow + startCol + endRow + endCol == -4)
            {

                return;
            }

            map = new int[row][col];
            trace = new int[row][col];
            was = new boolean[row][col];
            stack = new Stack<Point>();


            for (int i = 0; i < row; i++)
            {
                tokens = br.readLine().trim().split("[ ]+");
                for (int j = 0; j < tokens.length; j++)
                {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            if (test == 1)
            {
                System.out.println("Maze " + (test++) + "\n");
            } else
            {
                System.out.println("\n\n\nMaze " + (test++) + "\n");
            }

            dfs(startRow, startCol, endRow, endCol);
            int count = stack.size();
            while (!stack.isEmpty())
            {
                Point temp = stack.pop();
                int r = temp.x;
                int c = temp.y;
                trace[r][c] = count;
                count--;
            }
            displayMap();
            br.readLine();
        }
    }

    public boolean dfs(int startRow, int startCol, int endRow, int endCol)
    {
        stack.push(new Point(startRow, startCol));
        was[startRow][startCol] = true;

        if (startRow == endRow && startCol == endCol)
        {
            return true;
        }
        if (startCol > 0 && map[startRow][startCol - 1] != 1 && map[startRow][startCol - 1] != 3 && !was[startRow][startCol - 1])
        {
            if (dfs(startRow, startCol - 1, endRow, endCol))
            {
                return true;
            }
        }
        if (startRow > 0 && map[startRow - 1][startCol] != 2 && map[startRow - 1][startCol] != 3 && !was[startRow - 1][startCol])
        {
            if (dfs(startRow - 1, startCol, endRow, endCol))
            {
                return true;
            }
        }
        if (startCol < col - 1 && map[startRow][startCol] != 1 && map[startRow][startCol] != 3 && !was[startRow][startCol + 1])
        {
            if (dfs(startRow, startCol + 1, endRow, endCol))
            {
                return true;
            }
        }
        if (startRow < row - 1 && map[startRow][startCol] != 2 && map[startRow][startCol] != 3 && !was[startRow + 1][startCol])
        {
            if (dfs(startRow + 1, startCol, endRow, endCol))
            {
                return true;
            }
        }
        trace[startRow][startCol] = QUESTION_MARK;
        stack.pop();
        return false;
    }

    public void displayMap()
    {
        System.out.print("+");
        for (int i = 0; i < col; i++)
        {
            System.out.print("---+");
        }
        for (int i = 0; i < row; i++)
        {
            System.out.print("\n|");
            for (int j = 0; j < col; j++)
            {
                if (trace[i][j] != QUESTION_MARK)
                {
                    if (trace[i][j] == 0)
                    {
                        System.out.print("   ");
                    } else
                    {
                        System.out.print("  " + trace[i][j]);
                    }
                } else
                {
                    System.out.print("???");
                }


                if (j < col - 1 && (map[i][j] == 1 || map[i][j] == 3))
                {
                    System.out.print("|");
                } else if (j < col - 1)
                {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            if (i != row - 1)
            {
                System.out.print("\n+");
                for (int j = 0; j < col; j++)
                {
                    if (i >= 0 && (map[i][j] == 2 || map[i][j] == 3))
                    {
                        System.out.print("---+");
                    } else
                    {
                        System.out.print("   +");
                    }
                }
            }
        }
        System.out.print("\n+");
        for (int i = 0; i < col; i++)
        {
            System.out.print("---+");
        }
    }

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }
}

class Point
{
    int x;
    int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}