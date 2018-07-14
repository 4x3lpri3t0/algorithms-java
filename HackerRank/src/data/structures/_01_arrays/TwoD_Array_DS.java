package data.structures._01_arrays; // Delete in HR, CF

import java.util.Scanner;

public class TwoD_Array_DS {
    public static void main(String[] args) {
        int[][] arr = getInput();

        int maxHourglass = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int row1 = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int row2 = arr[i + 1][j + 1];
                int row3 = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                int total = row1 + row2 + row3;
                if (total > maxHourglass)
                    maxHourglass = total;
            }
        }

        System.out.println(maxHourglass);
    }

    private static int[][] getInput() {
        int[][] arr = new int[6][6];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        return arr;
    }
}