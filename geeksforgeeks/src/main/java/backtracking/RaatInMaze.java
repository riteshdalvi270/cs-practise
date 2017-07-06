package backtracking;

/**
 * Rat in Maze backtracking sum.
 * @author Ritesh Dalvi (rd026600).
 */
public class RaatInMaze
{
    public static void main(String args[])
    {

        int[][] maze = new int[][] {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};

        solveRatInMaze(maze, 0, 0);
    }

    private static boolean solveRatInMaze(final int[][] maze, int x, int y)
    {
        if (x == maze.length - 1 && y == maze.length - 1)
        {
            maze[x][y] = 1;
            return true;
        }

        // solve recursilvely

        if (isSafe(maze, x, y))
        {
            if (solveRatInMaze(maze, x + 1, y))
            {
                maze[x][y] = 1;
                return true;
            }

            if (solveRatInMaze(maze, x, y + 1))
            {
                maze[x][y] = 1;
                return true;
            }

            maze[x][y] = 0;
        }

        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y)
    {
        // check if safe to move, 0-deadend, 1- can move.

        if ((x > 0 && x <= maze[0].length && y > 0 && y <= maze.length) && maze[x][y] != 0)
        {
            return true;
        }

        return false;
    }
}
