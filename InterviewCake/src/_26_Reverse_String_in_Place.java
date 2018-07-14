class _26_Reverse_String_in_Place {
    public static String reverse(String str) {
        char[] strChars = str.toCharArray();

        int left = 0;
        int right = strChars.length - 1;

        while (left < right) {
            // Swap characters
            char temp = strChars[left];
            strChars[left] = strChars[right];
            strChars[right] = temp;

            // Move towards middle
            left++;
            right--;
        }

        return new String(strChars);
    }
    // O(n) time
    // O(1) space
}