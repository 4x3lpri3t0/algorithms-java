package data.structures._01_arrays; // Delete in HR, CF

import java.util.Scanner;

public class Left_Rotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            int rotatedIdx = (a_i + n - d) % n;
            a[rotatedIdx] = in.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        in.close();
    }
}