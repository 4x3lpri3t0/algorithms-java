package algorithms.java.hr.implementation;

import java.util.Scanner;

public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int appleCount = 0;
        int orangeCount = 0;
        for (int i = 0; i < m; i++) {
            int apple = in.nextInt();
            int applePos = a + apple;
            if (applePos >= s && applePos <= t)
                appleCount++;
        }
        for (int i = 0; i < n; i++) {
            int orange = in.nextInt();
            int orangePos = b + orange;
            if (orangePos >= s && orangePos <= t)
                orangeCount++;
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
