package Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/90002
public class FindMissingNumber {

    // TC: O(n), MC: O(n)
    static int findMissing(List<Integer> input) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= input.size() + 1; i++) {
            set.add(i);
        }

        for (Integer element : input) {
            set.remove(element);
        }

        if (set.size() != 1)
            return -1;
        else
            return (int) set.toArray()[0];
    }

    // TC: O(n), MC: O(1)
    static int findMissingOptimized(List<Integer> input) {
        // Calculate sum of all elements in input list
        int sumOfElements = 0;
        for (Integer x : input) {
            sumOfElements += x;
        }

        // There is exactly 1 number missing
        int n = input.size() + 1;

        // Gauss formula: Arithmetic series sum formula
        // https://www.varsitytutors.com/hotmath/hotmath_help/topics/sum-of-the-first-n-terms-of-an-arithmetic-sequence
        // http://mathcentral.uregina.ca/qq/database/qq.02.06/jo1.html
        int actualSum = (n * (n + 1)) / 2;

        return actualSum - sumOfElements;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 7, 1, 2, 8, 4, 5};
        List<Integer> list = Arrays.asList(arr);

        out.println(findMissing(list));
        out.println(findMissingOptimized(list));
    }
}