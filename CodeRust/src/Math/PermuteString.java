package Math;

import java.util.*;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/80002
// TC: O(n!), MC: O(n)
// Number of permutations of a set of size n is n! (factorial).
public class PermuteString {
    // Since we could have repeated chars
    // -> use a Set to avoid having it twice
    public static Set<String> result = new HashSet<>();
    private static int endingIndex;

    static void swapChar(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    static void permuteString(char[] input, int currentIndex) {
        if (currentIndex == endingIndex) {
            result.add(new String(input));
            return;
        }

        // Swap all chars to current position
        for (int i = currentIndex; i <= endingIndex; i++) {
            swapChar(input, currentIndex, i);
            permuteString(input, currentIndex + 1);
            swapChar(input, currentIndex, i);
        }
    }

    // Initializer
    static Set<String> permuteString(String input) {
        endingIndex = input.length() - 1;
        permuteString(input.toCharArray(), 0);
        return result;
    }

    public static void main(String[] args) {
        String input = "abc";
        Set<String> result = permuteString(input);
        out.println(Arrays.toString(result.toArray()));

        result.clear();

        input = "pizza";
        result = permuteString(input);
        out.println(Arrays.toString(result.toArray()));
    }
}
