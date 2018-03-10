package data_structures._01_arrays; // Delete in HR, CF

import java.io.*;
import java.util.*;

public class Arrays_DS {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];

        for(int i = 0; i < size; i++)
            input[i] = sc.nextInt();

        // Solution
        for(int i = input.length - 1; i >= 0; i--)
            System.out.print(input[i] + " ");
    }
}