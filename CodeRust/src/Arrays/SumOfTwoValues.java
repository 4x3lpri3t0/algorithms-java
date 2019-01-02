package Arrays;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.*;
import static java.lang.System.*;

public class SumOfTwoValues {
    static boolean find_sum_of_two(int[] A, int val) {
        Set<Integer> found_values = new HashSet<Integer>();
        for (int a : A) {
            if (found_values.contains(val - a)) {
                return true;
            }

            found_values.add(a);
        }

        return false;
    }

    static void test(int[] v, int val) {
        boolean output = find_sum_of_two(v, val);
        System.out.println("exist(A, " + val + ") = " + (output ? "true" : "false") + "\n");
    }

    public static void main(String[] args) {
        int[] v = new int[]{2, 1, 8, 4, 7, 3};
        test(v, 3);
        test(v, 20);
        test(v, 1);
        test(v, 2);
        test(v, 7);
    }
}
