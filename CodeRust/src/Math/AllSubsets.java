package Math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/150001
// TC: Exponential, O(2n) - where 'n' is number of integers in the given set.
// MC: Exponential, O(2n)
public class AllSubsets {
    static int getBit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;

        if (temp == 0) {
            return 0;
        }

        return 1; // temp could be > 1
    }

    static void getAllSubsets(List<Integer> v, List<HashSet<Integer>> sets) {
        int subsetsCount = (int) Math.pow((double) 2, (double) v.size());
        for (int i = 0; i < subsetsCount; ++i) {
            HashSet<Integer> set = new HashSet<>();

            // Bitmask?
            for (int j = 0; j < v.size(); ++j) {
                if (getBit(i, j) == 1) {
                    int x = v.get(j);
                    set.add(x);
                }
            }

            sets.add(set);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 7};
        List<Integer> listOfIntegers = new ArrayList<>();
        for (Integer i : integers) {
            listOfIntegers.add(i);
        }

        List<HashSet<Integer>> subsets = new ArrayList<>();

        getAllSubsets(listOfIntegers, subsets);

        out.println("**** Total: " + subsets.size() + " *****");
        for (int i = 0; i < subsets.size(); ++i) {
            out.print("{");
            for (Integer it : subsets.get(i)) {
                out.print(it + ", ");
            }
            out.println("}");
        }
        out.println("**** Total: " + subsets.size() + " *****");
    }
}
