package String;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/240003
class RegularExpression {
    static boolean regxMatchRec(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            String remainingPattern = pattern.substring(2);
            String remainingText = text;

            for (int i = 0; i < text.length() + 1; ++i) {
                if (regxMatchRec(remainingText, remainingPattern)) {
                    return true;
                }

                if (remainingText.isEmpty()) {
                    return false;
                }

                if (pattern.charAt(0) != '.' && remainingText.charAt(0) != pattern.charAt(0)) {
                    return false;
                }

                remainingText = remainingText.substring(1);
            }
        }

        if (text.isEmpty() || pattern.isEmpty()) {
            return false;
        }

        if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
            String remainingText = "";
            if (text.length() >= 2) {
                remainingText = text.substring(1);
            }

            String remainingPattern = "";
            if (pattern.length() >= 2) {
                remainingPattern = pattern.substring(1);
            }

            return regxMatchRec(remainingText, remainingPattern);
        }

        return false;
    }

    static boolean regexMatch(String text, String pattern) {
        return regxMatchRec(text, pattern);
    }

    public static void test(String s, String p) {
        boolean output2 = regexMatch(s, p);

        if (output2) {
            out.print(s + " " + p + " matched - ");
        } else {
            out.print(s + " " + p + " did not match - ");
        }
    }

    public static void main(String[] args) {
        test("abb", "abb");
        test("abbc", "ab*c");
        test("abb", "ab*");

        test("", "b*c");
        test("a", "ab*");

        test("aaabbbbbcccd", "a*bbb*c*d");
        test("a", "ab*");
        test("aaabbbbbcccd", "a*bbb*.*d");
        test("aaabbbbbcccde", "a*bbb*.*d");
        test("b", "b*");
        test("aabcd", "aa*d");
        test("", "aa*d");
        test("", "a*");
        test("b", "b*c");
    }
}