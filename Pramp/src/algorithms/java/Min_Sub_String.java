/*
# Smallest Substring of All Characters

Given an array with unique characters arr and a string str,
find the smallest substring of str containing all characters of arr.

Example: arr: [x,y,z], str: xyyzyzyx result: zyx

Implement your solution and analyze the runtime complexity
 */

import java.util.HashMap;
import java.util.Map;

public class Min_Sub_String {
    private static String getMinSubString(char[] arr, String str) {
        int head = 0;
        int tail = head;
        String minSubString = str;
        int minSubStringLength = str.length();
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();

        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], 0);
        }

        while (tail < str.length()) {
            countMap.put(str.charAt(tail), countMap.get(str.charAt(tail)) + 1);

            while (!countMap.containsValue(0)) {
                if (tail - head + 1 < minSubStringLength) {
                    minSubString = str.substring(head, tail + 1);
                    minSubStringLength = tail - head + 1;
                }

                countMap.put(str.charAt(head), countMap.get(str.charAt(head)) - 1);
                head++;
            }
            tail++;
        }

        return minSubString;
    }

    public static void main(String[] args) {
        char[] arr = {'x', 'y', 'z', 'r'};
        String str = "xyyrrryrxxyrryzyyyyyyx";

        System.out.println(getMinSubString(arr, str));
    }
}