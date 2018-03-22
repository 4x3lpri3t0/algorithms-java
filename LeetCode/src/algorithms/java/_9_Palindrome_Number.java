// https://leetcode.com/problems/palindrome-number

class _9_Palindrome_Number {
    boolean isPalindrome(int x) {
        int input = x;
        int rev = 0;

        if (x < 0) {
            return false;
        }

        while (x != 0) {
            int digit = x % 10;

            // Build the reverse in rev
            rev = rev * 10 + digit;

            // Remove last digit from x
            x /= 10;
        }

        return input == rev;
    }
}