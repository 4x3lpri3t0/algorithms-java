package impl;

import java.util.Scanner;

public class Impl_Kangaroo {
    public static void main() {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = "NO";

        if(v1 > v2) {
            int xDiff = Math.abs(x1 - x2);
            int vDiff = Math.abs(v1 - v2);
            if (xDiff % vDiff == 0) {
                result = "YES";
            }
        }

        System.out.println(result);
    }
}