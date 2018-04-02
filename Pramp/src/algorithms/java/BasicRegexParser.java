/*
Implement a regular expression function isMatch that supports the '.' and '*' symbols.

The function receives two strings - text and pattern - and should return true
if the text matches the pattern as a regular expression.

For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string
and are used as special symbols only in the pattern string.

In case you aren’t familiar with regular expressions, the function determines if the text
and pattern are the equal, where the '.' is treated as a single a character wildcard (see third example),
and '*' is matched for a zero or more sequence of the previous letter (see fourth and fifth examples).

Examples:

input:  text = "aa", pattern = "a"
output: false

input:  text = "aa", pattern = "aa"
output: true

input:  text = "abc", pattern = "a.c"
output: true

input:  text = "abbb", pattern = "ab*"
output: true

input:  text = "acd", pattern = "ab*c."
output: true
*/

public class BasicRegexParser {
    public static boolean isValid(String text, int t, String pattern, int p) {
        if (t >= text.length()) {
            if (p >= pattern.length()) {
                return true;
            } else {
                if (isAsterisk(pattern, p))
                    return isValid(text, t, pattern, p + 2);
                else
                    return false;
            }
        } else if (p >= pattern.length()) {
            return false;
        } else if (isAsterisk(pattern, p)) {
            if (equalOrDot(text, t, pattern, p))
                return isValid(text, t + 1, pattern, p) || isValid(text, t, pattern, p + 2);
            else
                return isValid(text, t, pattern, p + 2); //Case where the text char does not match the pattern first char + *, so move onto the next pattern.
        } else if (equalOrDot(text, t, pattern, p)) {
            return isValid(text, t + 1, pattern, p + 1);
        }

        return false;
    }

    private static boolean equalOrDot(String text, int t, String pattern, int p) {
        return text.charAt(t) == pattern.charAt(p) || pattern.charAt(p) == '.';
    }

    private static boolean isAsterisk(String pattern, int p) {
        return p + 1 < pattern.length() && pattern.charAt(p + 1) == '*';
    }

    public static void main(String[] args) {
        System.out.println(isValid("aaaaaaa", 0, "a.*", 0));
//        System.out.println(isValid("aa", 0, "a", 0)); //false
//        System.out.println(isValid("aa", 0, "ab", 0)); //false
//        System.out.println(isValid("ba", 0, "ab", 0)); //false
//        System.out.println(isValid("ba", 0, "a*b.*", 0));
//        System.out.println(isValid("aaaaaaa", 0, "a*", 0));
//        System.out.println(isValid("aaaaaaa", 0, ".*b", 0)); //false
//        System.out.println(isValid("aaaaaaab", 0, ".*.", 0));
//        System.out.println(isValid("aaaaaaabbxxxxyz", 0, ".*b.*xy.*", 0));
//        System.out.println(isValid("aaaaaaabbxxxxyz", 0, ".*b.*xy", 0)); //false
//        System.out.println(isValid("bxxxxy", 0, ".*b.*xy", 0));
//        System.out.println(isValid("b", 0, "a*c*x*", 0)); //false
    }
}