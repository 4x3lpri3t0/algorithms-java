package algorithms.java.cf.problemset; // Delete in HR

import java.util.*;

public class Taxi {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[5];

        // Assign frequencies
        for(int i = 0; i < n; i++) {
            int count = in.nextInt();
            s[count]++;
        }

        s[1] = Math.max(0, s[1] - s[3]);
        // s[1] are now the amount of 1's that don't have a partner 3

        // Switch from amount of 2 groups, to actual units
        int unitsFromTwo = s[2] * 2;

        int onesAndTwos = (s[1] + unitsFromTwo + 3) / 4;
        int result = s[4] + s[3] + onesAndTwos;

        System.out.println(result);
    }
}