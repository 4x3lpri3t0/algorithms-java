import java.util.HashSet;

public class _804_Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        String[] morseAlphabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (String word : words) {
            StringBuffer morse = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                int idx = cur - 'a';
                morse.append(morseAlphabet[idx]);
            }

            set.add(morse.toString());
        }

        return set.size();
    }
}
