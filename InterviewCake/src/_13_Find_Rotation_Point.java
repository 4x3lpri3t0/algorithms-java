// When loIdx and hiIdx are next to each other, we know the lo is the
// last item we added before starting from the beginning of the dictionary,
// and the ceiling is the first item we added after.

class _13_Find_Rotation_Point {
    public static int findRotationPoint(String[] words) {
        final String firstWord = words[0];

        int loIdx = 0;
        int hiIdx = words.length - 1;

        while (loIdx < hiIdx) {
            // Guess a point halfway between floor and ceiling
            int guessIdx = loIdx + ((hiIdx - loIdx) / 2);

            // If guess comes after first word or is the first word
            if (words[guessIdx].compareTo(firstWord) >= 0) {
                // Go right
                loIdx = guessIdx;
            } else {
                // Go left
                hiIdx = guessIdx;
            }

            // If lo and hi have converged
            if (loIdx + 1 == hiIdx) {
                // Between hi and lo is where we flipped to the
                // beginning so ceiling is alphabetically first
                break;
            }
        }

        return hiIdx;
    }
}
// O(lgn) time