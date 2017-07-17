package amazon;

/**
 * Find number of islands. 1- earth, 0 - water Created by ritesh on 7/3/17.
 */
public class NumberOfIslands
{

    public static void main(String args[])
    {

        int[][] island = new int[][] {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};

        int count = numberOfIslands(island);

        System.out.print(count);
    }

    private static int numberOfIslands(int[][] islands)
    {

        boolean[][] isVisited = new boolean[islands[0].length][islands.length];

        int count = 0;

        for (int i = 0; i < islands[0].length; i++)
        {
            for (int j = 0; j < islands.length; j++)
            {

                if (islands[i][j] == 1 && !isVisited[i][j])
                {

                    dfs(islands, i, j, isVisited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] island, int row, int column, boolean[][] isVisited)
    {

        int[] rowNum = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] columnNum = {-1, 0, 1, -1, 1, -1, 0, 1};

        isVisited[row][column] = true;

        int neightbors = island.length - 1 + island.length - 1;
        for (int k = 0; k < neightbors; k++)
        {

            if (isSafe(island, row + rowNum[k], column + columnNum[k], isVisited))
            {

                dfs(island, row + rowNum[k], column + columnNum[k], isVisited);
            }
        }
    }

    private static boolean isSafe(int[][] island, int row, int col, boolean[][] isVisited)
    {

        if ((row >= 0 && row < island[0].length) && (col >= 0 && col < island.length) && island[row][col] == 1 && !isVisited[row][col])
        {
            return true;
        }

        return false;
    }
}
