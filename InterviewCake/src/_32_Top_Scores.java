class _32_Top_Scores {
    public static int[] sortScores(int[] scores, int maxScore) {
        // Array of 0s at indices 0..highestPossibleScore
        int[] scoreCounts = new int[maxScore + 1];

        // Populate scoreCounts
        for (int score : scores) {
            scoreCounts[score]++;
        }

        // Populate the final sorted array
        int[] sortedScores = new int[scores.length];
        int currentIdx = 0;

        // For each item in scoreCounts
        for (int score = maxScore; score >= 0; score--) {
            int count = scoreCounts[score];

            // For the number of times the item occurs
            for (int occurrence = 0; occurrence < count; occurrence++) {
                // Add it to the sorted array
                sortedScores[currentIdx] = score;
                currentIdx++;
            }
        }

        return sortedScores;
    }
}