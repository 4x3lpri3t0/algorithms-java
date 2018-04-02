/*
# Merging 2 Packages

Given a package with a weight limit and an array arr of item weights,
how can you most efficiently find two items with sum of weights that equals the weight limit?
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Merge_Packages {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergePackage(21, new int[]{4, 6, 10, 15, 16})));
        System.out.println(Arrays.toString(mergePackage(21, new int[]{4, 10, 6, 15, 16})));
    }

    static int[] mergePackage(int limit, int[] arr) {
        if (arr == null)
            return null;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(limit - arr[i])) {
                return new int[]{i, map.get(limit - arr[i])};
            } else {
                map.put(arr[i], i);
            }
        }

        return null;
    }
}