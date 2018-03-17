// https://leetcode.com/problems/reverse-words-in-a-string-iii

public class _557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        // Split into chunks
        String words[] = s.split(" ");

        // Reverse each chunk (using SB!)
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            String reversed = new StringBuffer(word).reverse().toString();
            res.append(reversed + " ");
        }

        return res.toString().trim();
    }
}
