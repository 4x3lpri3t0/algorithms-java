package String;

public class ReverseSentenceWords {
    public static void reverseWords(char[] sentence) {
        if (sentence == null || sentence.length == 0)
            return;

        StringBuilder words = new StringBuilder();
        StringBuilder letters = new StringBuilder();

        for (int i = 0; i < sentence.length; i++) {
            char cur = sentence[i];
            if (cur == ' ') {
                letters.insert(0, ' ');
                words.insert(0, letters);
                letters = new StringBuilder();
            } else {
                letters.append(cur);
            }
        }

        words.insert(0, letters);

        System.out.println(words.toString().trim());
    }

    public static void main(String[] args) {
        reverseWords(new char[]{'c', 'o', 'd', 'e', ' ', 'r', 'u', 's', 't' });
        reverseWords(" Quick brown fox jumped over the lazy dog ".toCharArray());
    }
}