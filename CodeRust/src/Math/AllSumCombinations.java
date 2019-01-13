package Math;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/120003
public class AllSumCombinations {
    static void printList(List<Integer> v) {
        for (int i : v) {
            out.print(i + ",");
        }

        out.println("");
    }

    static void printAllSumRec(int target, int currentSum, int start, List<Integer> output) {
        if (target == currentSum) {
            printList(output);
        }

        for (int i = start; i < target; ++i) {
            int tempSum = currentSum + i;
            if (tempSum <= target) {
                output.add(i);
                printAllSumRec(target, tempSum, i, output);
                output.remove(output.size() - 1);
            } else {
                return;
            }
        }
    }

    static void printAllSum(int target) {
        List<Integer> output = new ArrayList<>();
        printAllSumRec(target, 0, 1, output);
    }

    public static void main(String[] args) {
        int n = 10;
        printAllSum(n);
    }
}
