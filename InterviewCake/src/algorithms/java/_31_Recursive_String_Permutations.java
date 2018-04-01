import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class _31_Recursive_String_Permutations {
    private static Set<String> getPermutations(String str) {
        // Base case
        if (str.length() <= 1) {
            return new HashSet<>(Collections.singletonList(str));
        }

        // All permutations of chars except last
        String excLast = str.substring(0, str.length() - 1);
        // Last char
        char last = str.charAt(str.length() - 1);

        // Recursive call: Get all possible permutations for all chars except last
        Set<String> prmsExcLast = getPermutations(excLast);

        // Put the last char in all possible positions for each permutation
        Set<String> prms = new HashSet<>();
        for (String prmExcLast : prmsExcLast) {
            for (int pos = 0; pos <= excLast.length(); pos++) {
                // Permutation
                String prm = prmExcLast.substring(0, pos)
                        + last
                        + prmExcLast.substring(pos);

                prms.add(prm);
            }
        }

        return prms;
    }
}