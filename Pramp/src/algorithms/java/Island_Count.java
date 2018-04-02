/*
#Island Count

Given a 2D matrix M, filled with either 0s or 1s, count the number of islands of 1s in M. An island is a group of adjacent values that are all 1s. Every cell in M can be adjacent to the 4 cells that are next to it on the same row or column.

Explain and code the most efficient solution possible and analyze its runtime complexity.

Example: the matrix below has 6 islands:

    0  1  0  1  0
    0  0  1  1  1
    1  0  0  1  0
    0  1  1  0  0
    1  0  1  0  1
*/

public class Island_Count {

    static int[][] visited;

    static int getNumberOfIslands(int[][] binaryMatrix) {
        int islandsExplored = 0;
        visited = new int[binaryMatrix.length][binaryMatrix[0].length];

        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[0].length; j++) {
                if (binaryMatrix[i][j] == 1 && visited[i][j] != 1) {
                    exploreIsland(binaryMatrix, i, j);
                    islandsExplored += 1;
                }
            }
        }

        return islandsExplored;
    }

    static void exploreIsland(int[][] binaryMatrix, int row, int column) {
        if (row < 0
                || column < 0
                || row >= binaryMatrix.length
                || column >= binaryMatrix[0].length
                || binaryMatrix[row][column] == 0
                || visited[row][column] == 1) {
            return;
        } else {
            // Mark the current node as visited
            visited[row][column] = 1;
            exploreIsland(binaryMatrix, row, column + 1);
            exploreIsland(binaryMatrix, row, column - 1);
            exploreIsland(binaryMatrix, row + 1, column);
            exploreIsland(binaryMatrix, row - 1, column);
        }

        return;
    }

    public static void main(String[] args) {
        // TODO: Test
    }
}