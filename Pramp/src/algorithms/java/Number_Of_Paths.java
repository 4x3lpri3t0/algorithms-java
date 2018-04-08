/*
# Number of Paths

You’re testing a new driverless car that is located at the Southwest
(bottom-left) corner of an n×n grid.

The car is supposed to get to the opposite, Northeast (top-right),
corner of the grid.

Given n, the size of the grid’s axes, write a function numOfPathsToDest
that returns the number of the possible paths the driverless car can take.
*/

// https://medium.com/@vickdayaram/find-the-number-of-paths-d7d9cfccba08

public class Number_Of_Paths {
    static int numOfPathsToDest(int n) {
        int[][] memo = new int[n][n];
        memo[0][0] = 1;

        // First row = 1
        for (int i = 1; i < n; i++) {
            memo[0][i] = 1;
        }

        // i = row, j = col
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int left = memo[i][j - 1];
                int top = memo[i - 1][j];
                memo[i][j] = left + top;
            }
        }

        // Take the last one
        return memo[n - 1][n - 1];
    }

    public static void main() {
//        System.out.println(numOfPathsToDest(3));
//        System.out.println(numOfPathsToDest(4));
        System.out.println(numOfPathsToDest(5));
    }
}