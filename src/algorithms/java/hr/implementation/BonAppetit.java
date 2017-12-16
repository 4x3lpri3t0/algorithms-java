package hr.implementation; // Delete in HR

import java.util.Scanner;

public class BonAppetit {
    static int bonAppetit(int n, int k, int b, int[] ar) {
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += ar[i];
        }

        int expected = (total - ar[k]) / 2;

        return b - expected;
    }

    public static void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        int result = bonAppetit(n, k, b, ar);
        System.out.println(result == 0 ? "Bon Appetit" : result);
    }
}