// The trick to many "parsing" questions like this is using
// a stack to track which brackets/phrases/etc are "open" as you go.
//
// So next time you get a parsing question,
// one of your first thoughts should be "use a stack!"

class _28_Matching_Parens {
    public static int getClosingParen(String str, int startParenIdx) {
        int openers = 0;

        for (int pos = startParenIdx + 1; pos < str.length(); pos++) {
            char c = str.charAt(pos);

            if (c == '(') {
                openers++;
            } else if (c == ')') {
                if (openers == 0) {
                    return pos;
                } else {
                    openers--;
                }
            }
        }

        throw new IllegalArgumentException("No closing parenthesis...");
    }
    // O(n) time
    // O(1) space
}