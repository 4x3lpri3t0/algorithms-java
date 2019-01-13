package Math;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/840001
// TC: O(n)
// MC: O(1)
public class IsNumberValid {
    enum STATE {START, INTEGER, DECIMAL, UNKNOWN, AFTER_DECIMAL}

    static STATE getNextState(STATE currentState, char ch) {
        switch (currentState) {
            case START:
            case INTEGER:
                if (ch == '.') {
                    return STATE.DECIMAL;
                } else if (ch >= '0' && ch <= '9') {
                    return STATE.INTEGER;
                } else {
                    return STATE.UNKNOWN;
                }
            case DECIMAL:
            case AFTER_DECIMAL:
                if (ch >= '0' && ch <= '9') {
                    return STATE.AFTER_DECIMAL;
                } else {
                    return STATE.UNKNOWN;
                }
        }

        return STATE.UNKNOWN;
    }

    static boolean isNumberValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }

        STATE currentState = STATE.START;

        while (i < s.length()) {
            currentState = getNextState(currentState, s.charAt(i));

            if (currentState == STATE.UNKNOWN) {
                return false;
            }

            i = i + 1;
        }

        if (currentState == STATE.DECIMAL)
            return false;

        return true;
    }

    static void test(String s, boolean expected) {
        boolean is_valid = isNumberValid(s);

        if (is_valid) {
            System.out.println(s + " is valid.");
        } else {
            System.out.println(s + " is not valid.");
        }
    }

    public static void main(String[] args) {
        test("4.325", true);
        test("4.325a", false);
        test("x4.325", false);
        test("4.32.5", false);
        test("4325", true);
        test("1.", false);
        test("1.1.", false);
        test("1.1.1", false);
        test("1.1.1.", false);
        test("+1.1.", false);
        test("+1.1", true);
        test("-1.1.", false);
        test("-1.1", true);
        test("", true);
    }
}
