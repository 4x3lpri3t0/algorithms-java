// https://leetcode.com/problems/reverse-integer

class _7_Reverse_Integer {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;

            // Reverse last op to check if it overflowed
            if ((newResult - tail) / 10 != result) {
                return 0;
            }

            result = newResult;
            x = x / 10;
        }

        return result;
    }

    // Alternative using long to avoid overflow
    // (not allowed in problem description)
    public int reverse_alt(int x) {
        long result = 0;
        for (; x != 0; x /= 10) {
            result = result * 10 + x % 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)result;
    }
}
