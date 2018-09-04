package String;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class PalindromeSubstrings {
    private static boolean isPalindrome(String input, int i, int j) {
        while (j > i) {
            if (input.charAt(i) != input.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    static int findAllPalindromeSubstrings(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (isPalindrome(input, i, j)) {
                    out.print(input.substring(i, j + 1) + ", ");
                    count++;
                }
            }
        }
        out.println();
        return count;
    }

    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = findAllPalindromeSubstrings(str);
        out.println(count == 7);
    }
}