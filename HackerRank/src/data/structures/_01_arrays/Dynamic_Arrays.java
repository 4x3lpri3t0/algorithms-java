package data.structures._01_arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Dynamic_Arrays {

    public static void main(String[] args) {
        // Input
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        Object[] sequences = new Object[n];
        for (int i = 0; i < n; i++)
            sequences[i] = new LinkedList<Integer>();

        // Solution
        int lastAns = 0;
        while (q-- != 0) {
            int ch = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();

            int seq = (x ^ lastAns) % n;
            List<Integer> sequence = ((LinkedList<Integer>) sequences[seq]);

            if (ch == 1) {
                sequence.add(y);
            } else {
                int ele = y % sequence.size();
                lastAns = sequence.get(ele);
                System.out.println(lastAns);
            }
        }
    }
}