package algorithms.java.hr.implementation;

import java.util.*;

public class Kangaroo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = "NO";

        if(v1 >= v2) {
            if(x1 < x2 && v1 > v2) {
                int xDiff = Math.abs(x1 - x2);
                int vDiff = Math.abs(v1 - v2);
                if (xDiff % vDiff == 0) {
                    result = "YES";
                }
            }
        }

        System.out.println(result);
    }
}