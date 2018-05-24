package backtracking.part1;

/**
 * N Queen problem Created by ritesh on 7/5/17.
 */
public class NQueenProblem
{

    public static void main(String args[])
    {

        int board[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},};

        int numberOfQueens = 4;

        solveNQ(board, numberOfQueens);
    }

    private static boolean solveNQ(int[][] board, int numberOfQueens)
    {

        if (numberOfQueens >= board[0].length)
        {
            return true;
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < board[0].length; i++)
        {

            if (isSafeToPlaceQueen(board, i, numberOfQueens))
            {

                board[i][numberOfQueens] = 1;
                if (solveNQ(board, numberOfQueens++) == true)
                {

                    return true;
                }
                else
                {

                    board[i][numberOfQueens] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isSafeToPlaceQueen(int[][] board, int row, int col)
    {

        for (int i = 0; i < col; i++)
        {

            if (board[row][i] == 1)
            {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {

            if (board[i][j] == 1)
            {
                // upper diagonal
                return false;
            }
        }

        for (int i = row, j = col; i < board[0].length && j >= 0; i++, j--)
        {
            if (board[i][j] == 1)
            {
                // lower diagonal
                return false;
            }
        }

        return true;
    }
}
