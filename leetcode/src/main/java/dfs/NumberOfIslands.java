package dfs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.
 NOTE: Need only horizontal and vertical. Different than what is on GeeksForGeeks
 * Created by ritesh on 9/9/17.
 */
public class NumberOfIslands {

    public static void main(String args[]) {

        int[][] island = new int[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};

        int count = numberOfIslands(island);

        System.out.print(count);
    }

    private static int numberOfIslands(int[][] graph) {

        if (graph.length == 0) {
            return 0;
        }

        boolean[][] isVisited = new boolean[graph.length][graph[0].length];

        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {

                if (graph[i][j] ==  1 && !isVisited[i][j]) {
                    dfs(graph, i, j, isVisited);

                    count = count + 1;

                }

                isVisited[i][j] = true;
            }
        }

        return count;
    }

    private static void dfs(int[][] graph, int col, int row, boolean[][] isVisited) {

        int neighbors = 4;

        int x[] = new int[]{-1,0, 0, 1};
        int y[] = new int[]{0,-1, 1, 0};

        isVisited[col][row] = true;

        for (int k = 0; k < neighbors; k++) {

            if (isSafe(graph, col + x[k], row + y[k], isVisited)) {

                dfs(graph, col + x[k], row + y[k], isVisited);
            }
        }
    }

    private static boolean isSafe(int[][] island, int col, int row, boolean[][] isVisited) {

        if ((row >= 0 && row < island[0].length) && (col >= 0 && col < island.length) && island[col][row] == 1 && !isVisited[col][row]) {
            return true;
        }

        return false;
    }
}
