import java.util.HashMap;
import java.util.Map;

class _34_Word_Cloud {
    private Map<String, Integer> wordsToCounts = new HashMap<>();

    public _34_Word_Cloud(String inputString) {
        populateWordsToCounts(inputString);
    }

    public Map<String, Integer> getWordsToCounts() {
        return wordsToCounts;
    }

    private void populateWordsToCounts(String inputString) {
        // Iterates over each character in the input string, splitting
        // words and passing them to addWordToHashMap()

        int currentWordStartIndex = 0;
        int currentWordLength = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);

            // If we reached the end of the string we check if the last
            // character is a letter and add the last word to our hash map
            if (i == inputString.length() - 1) {
                if (Character.isLetter(character)) {
                    currentWordLength++;
                }
                if (currentWordLength > 0) {
                    String currentWord = inputString.substring(currentWordStartIndex,
                            currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                }

                // If we reach a space or emdash
                // -> We know we're at the end of a word
            } else if (character == ' ' || character == '\u2014') {
                if (currentWordLength > 0) {
                    String currentWord = inputString.substring(currentWordStartIndex,
                            currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                    currentWordLength = 0;
                }

                // We want to make sure we split on ellipses so if we get two periods in
                // a row we add the current word to our hash map and reset our current word
            } else if (character == '.') {
                if (i < inputString.length() - 1 && inputString.charAt(i + 1) == '.') {
                    if (currentWordLength > 0) {
                        String currentWord = inputString.substring(currentWordStartIndex,
                                currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                }

                // If the character is a letter or an apostrophe, we add it to our current word
            } else if (Character.isLetter(character) || character == '\'') {
                if (currentWordLength == 0) {
                    currentWordStartIndex = i;
                }
                currentWordLength++;

                // If the character is a hyphen, we want to check if it's surrounded by letters
                // if it is, we add it to our current word
            } else if (character == '-') {
                if (i > 0 && Character.isLetter(inputString.charAt(i - 1))
                        && Character.isLetter(inputString.charAt(i + 1))) {
                    if (currentWordLength == 0) {
                        currentWordStartIndex = i;
                    }
                    currentWordLength++;
                } else {
                    if (currentWordLength > 0) {
                        String currentWord = inputString.substring(currentWordStartIndex,
                                currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                }
            }
        }
    }

    private void addWordToHashMap(String word) {
        word = word.toLowerCase();

        // If the word is already in the hash map we increment its count
        if (wordsToCounts.containsKey(word)) {
            wordsToCounts.put(word, wordsToCounts.get(word) + 1);
        } else {
            wordsToCounts.put(word, 1);
        }
    }
}