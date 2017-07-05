package backtracking;

/**
 * Knight's tour. Created by ritesh on 7/4/17.
 */
public class KnightsTour
{
    public static void main(String args[])
    {
        solveKT();
    }

    private static void solveKT()
    {
        int[][] sol = new int[8][8];

        for (int i = 0; i < sol.length - 1; i++)
        {

            for (int j = 0; j < sol.length - 1; i++)
            {

                sol[i][j] = -1;
            }
        }

        int[] xMoves = {2, 2, -2, -2, -1, 1, 1, -1};
        int[] yMoves = {1, -1, 1, -1, -2, -2, 2, 2};

        for (int i = 0; i < sol[0].length; i++)
        {

            for (int j = 0; j < sol.length; j++)
            {
                sol[i][j] = 1;

                if (solveKTUtil(sol, i, j, xMoves, yMoves, 1))
                {
                    // print solution
                }
            }
        }
    }

    private static boolean solveKTUtil(int[][] sol, int x, int y, int[] xMoves, int[] yMoves, int moves)
    {
        if (moves == sol[0].length * sol.length)
        {
            return true;
        }

        for (int k = 0; k < 8; k++)
        {
            int nextXMove = x + xMoves[k];
            int nextYMove = y + yMoves[k];

            if (isSafe(nextXMove, nextYMove, sol))
            {
                solveKTUtil(sol, nextXMove, nextXMove, xMoves, yMoves, moves + 1);
            }
            else
            {
                sol[nextXMove][nextYMove] = -1;
            }
        }

        return false;
    }

    private static boolean isSafe(int xMove, int yMove, int[][] sol)
    {

        if (xMove <= 0 && yMove <= 0 && sol[xMove][yMove] != -1)
        {
            return true;
        }

        return false;
    }
}
