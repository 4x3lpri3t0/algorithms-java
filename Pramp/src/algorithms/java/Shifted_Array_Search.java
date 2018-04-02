/*
#Shifted Array Search

Find a given number num in a sorted array arr:

arr = [2, 4, 5, 9, 12, 17]

If the sorted array arr is shifted left by an unknown offset and you don't have
a pre-shifted copy of it, how would you modify your method to find a number in the shifted array?

shiftArr = [9, 12, 17, 2, 4, 5]

Explain and code an efficient solution and analyze its runtime complexity if num
doesn't exist in the array, return -1
*/

public class Shifted_Array_Search {
    static int shiftedArrSearch(int[] shiftArr, int num) {
        int start = 0;
        int size = shiftArr.length;
        int end = shiftArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (shiftArr[mid] == num)
                return mid;

            if (shiftArr[start] <= shiftArr[mid]) {
                if (num >= shiftArr[start] && num <= shiftArr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (shiftArr[mid] <= shiftArr[end]) {
                if (num >= shiftArr[mid] && num <= shiftArr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3, 4, 5, 1, 2}; // [2, 3, 1]

        System.out.println(shiftedArrSearch(num, 1));
    }
}