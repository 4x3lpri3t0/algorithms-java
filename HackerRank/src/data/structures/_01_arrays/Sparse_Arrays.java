package data.structures._01_arrays;

import java.util.Scanner;

public class Sparse_Arrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stringCount = in.nextInt();
        String[] arr = new String[stringCount];
        for (int i = 0; i < stringCount; i++) {
            arr[i] = in.next();
        }

        int queryCount = in.nextInt();
        for (int j = 0; j < queryCount; j++) {
            String query = in.next();
            int count = 0;
            for (String a : arr) {
                if (a.equals(query)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}