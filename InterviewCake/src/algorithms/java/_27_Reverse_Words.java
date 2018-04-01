// Solve a simpler version of the problem
// (in this case, reversing the characters instead of the words),
// and see if that gets us closer to a solution
// for the original problem.

class _27_Reverse_Words {
    public static void reverseWords(char[] message) {
        // First we reverse all the characters in the entire message array
        // this gives us the right word order
        // but with each word backwards
        reverseCharacters(message, 0, message.length - 1);

        // Now we'll make the words forward again
        // by reversing each word's characters

        // We hold the index of the *start* of the current word
        // as we look for the *end* of the current word
        int currentWordStartIndex = 0;
        for (int i = 0; i <= message.length; i++) {
            // Found the end of the current word!
            if (i == message.length || message[i] == ' ') {
                // If we haven't exhausted the array, our
                // next word's start is one character ahead
                reverseCharacters(message, currentWordStartIndex, i - 1);
                currentWordStartIndex = i + 1;
            }
        }
    }

    private static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {
        // Walk towards the middle, from both sides
        while (leftIndex < rightIndex) {
            // Swap the left char and right char
            char temp = message[leftIndex];
            message[leftIndex] = message[rightIndex];
            message[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }
    // O(n) time
    // O(1) space
}