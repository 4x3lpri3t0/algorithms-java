public class _36_Single_Riffle_Check {
    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {
        return isSingleRiffle(half1, half2, shuffledDeck, 0, 0, 0);
    }

    private static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck,
                                          int shuffledDeckIndex, int half1Index, int half2Index) {
        // Base case we've hit the end of shuffledDeck
        if (shuffledDeckIndex == shuffledDeck.length) {
            return true;
        }

        // If we still have cards in half1
        // and the "top" card in half1 is the same
        // as the top card in shuffledDeck
        if ((half1Index < half1.length)
                && (half1[half1Index] == shuffledDeck[shuffledDeckIndex])) {
            half1Index++;

            // If we still have cards in half2
            // and the "top" card in half2 is the same
            // as the top card in shuffledDeck
        } else if ((half2Index < half2.length)
                && (half2[half2Index] == shuffledDeck[shuffledDeckIndex])) {
            half2Index++;

            // If the top card in shuffledDeck doesn't match the top
            // card in half1 or half2, this isn't a single riffle.
        } else {
            return false;
        }

        // The current card in shuffledDeck has now been "accounted for"
        // so move on to the next one
        shuffledDeckIndex++;
        return isSingleRiffle(half1, half2, shuffledDeck, shuffledDeckIndex, half1Index, half2Index);
    }
}