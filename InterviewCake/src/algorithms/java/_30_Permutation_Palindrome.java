import java.util.HashSet;
import java.util.Set;

class _30_Permutation_Palindrome {
    public static boolean hasPalindromePermutation(String theString) {
        // Track characters we've seen an odd number of times
        Set<Character> unpairedCharacters = new HashSet<>();

        for (char c : theString.toCharArray()) {
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }

        // The string has a palindrome permutation if it
        // has one or zero characters without a pair
        return unpairedCharacters.size() <= 1;
    }
    // O(n) time
    // O(n) space / O(1) -> See problem explanation
}