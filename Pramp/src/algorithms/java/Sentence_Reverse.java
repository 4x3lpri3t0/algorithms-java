/*
# Sentence Reverse

You are given an array of characters arr, which consists of sequences of characters
separated by space characters.

Each space-delimited sequence of characters defines a word.

How can you most efficiently reverse the order of the words in the array?

For example:

[ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ', 'm', 'a', 'k', 'e', 's', '  ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

Would turn into:

[ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ', 'm', 'a', 'k', 'e', 's', '  ', 'p', 'e', 'r', 'f', 'e', 'c', 't' ]
*/

public class Sentence_Reverse {
    private String sentence;

    public Sentence_Reverse(String sentence) {
        this.sentence = sentence;
    }

    public String smartReverse() {
        StringBuilder result = new StringBuilder(sentence);

        reverse(result, 0, result.length());
        reverseWords(result);

        return result.toString();
    }

    private void reverse(StringBuilder string, int from, int to) {
        for (int i = 0; i < (to - from) / 2; ++i) {
            swapCharacters(string, from + i, to - 1 - i);
        }
    }

    private void swapCharacters(StringBuilder string, int leftIndex, int rightIndex) {
        char left = string.charAt(leftIndex);
        char right = string.charAt(rightIndex);

        string.setCharAt(leftIndex, right);
        string.setCharAt(rightIndex, left);
    }

    private void reverseWords(StringBuilder string) {
        int start = 0;
        int spaceIndex;

        while ((spaceIndex = string.indexOf(" ", start)) != -1) {
            reverse(string, start, spaceIndex);
            start = spaceIndex + 1;
        }

        reverse(string, start, string.length());
    }
}