/*
#Getting a Different Number

Given an array arr of n unique non-negative integers, how can you most efficiently find a non-negative integer that is not in the array?

Your solution should return such an integer or null if arr contains all possible integers. Analyze the runtime and space complexity of your solution.
*/

public class Getting_Diff_Number {
    public int getDiffNum(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 1) {
            return 0; // 0 is not in an empty array
        }

        boolean[] foundNum = new boolean[n + 1];

        for (int i : arr) {
            if (i < foundNum.length) {
                foundNum[i] = true;
            }
        }

        for (int i = 0; i < foundNum.length; i++) {
            if (!foundNum[i]) {
                return i;
            }
        }

        return -1; // Array holds more than n+1 unique elements
    }
}