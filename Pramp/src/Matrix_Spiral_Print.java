/*
#Matrix Spiral Print

Given a 2D array (matrix) named M, print all items of M in a spiral order, clockwise.

For example:

M  =  1   2   3   4   5
      6   7   8   9  10
     11  12  13  14  15
     16  17  18  19  20

The clockwise spiral print is: 1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12
*/

public class Matrix_Spiral_Print {
    public static void spiralPrint(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
            return;
        }
        int lastRow = M.length - 1;
        int lastCol = M[0].length - 1;

        int firstRow = 0;
        int firstCol = 0;

        StringBuilder sb = new StringBuilder();

        while (firstCol <= lastCol && firstRow <= lastRow) {
            for (int j = firstCol; j <= lastCol; j++) {
                // Right
                sb.append(M[firstRow][j]);
                sb.append(" ");
            }
            firstRow++;

            for (int i = firstRow; i <= lastRow; i++) {
                // Down
                sb.append(M[i][lastCol]);
                sb.append(" ");
            }
            lastCol--;

            // Left
            for (int j = lastCol; j >= firstCol; j--) {
                sb.append(M[lastRow][j]);
                sb.append(" ");
            }
            lastRow--;

            // Up
            for (int i = lastRow; i >= firstRow; i--) {
                sb.append(M[i][firstCol]);
                sb.append(" ");
            }
            firstCol++;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        spiralPrint(arr);
    }
}