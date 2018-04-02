/*
Array Index & Element Equality

Given an array of sorted distinct integers named arr, write a function that returns an index
i in arr for which arr[i] = i or -1 if no such index exists.

Implement the most efficient solution possible, prove the correctness of your solution and
analyze its runtime complexity (in terms of n - the length of arr).

Examples:

Given arr = [-8,0,2,5] the function returns 2, since arr[2] = 2
Given arr = [-1,0,3,6] the function returns -1, since no index in arr satisfies arr[i] = i
*/

import java.util.List;

public class Arr_IndexAndElement_Equal {
    private List<Integer> array;

    public Arr_IndexAndElement_Equal(List<Integer> array) {
        this.array = array;
    }

    public int findIndex() {
        return findIndex(0, array.size() - 1);
    }

    private int findIndex(int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (array.get(mid) == mid) {
            return mid;
        } else if (array.get(mid) < mid) {
            return findIndex(mid + 1, end);
        } else {
            return findIndex(start, mid - 1);
        }
    }
}