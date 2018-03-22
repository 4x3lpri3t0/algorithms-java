// https://leetcode.com/problems/plus-one

class _66_Plus_One {
    public int[] plusOne(int[] digits) {
        // Iterate backwards
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}

// The last part of code is only for the case that
// the whole input array is 9s.

// For example : 99999-----> 100000

// Any other case would return in the loop.