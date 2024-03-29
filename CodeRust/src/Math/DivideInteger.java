package Math;

import static java.lang.System.out;

public class DivideInteger {
    public static int integerDivide(int x, int y) {

        // We will return -1 if the
        // divisor is '0'.
        if (y == 0) {
            return -1;
        }

        if (x < y) {
            return 0;
        } else if (x == y) {
            return 1;
        } else if (y == 1) {
            return x;
        }

        int q = 1;
        int val = y;

        while (val < x) {
            val <<= 1;
            // We can also use 'val = val + val;'
            q <<= 1;
            // We can also use 'q = q + q;'
        }

        if (val > x) {
            val >>= 1;
            q >>= 1;

            return q + integerDivide(x - val, y);
        }

        return q;
    }

    public static void main(String[] args) {
        out.println("5/11 " + String.valueOf(integerDivide(55, 11) == 5));
        out.println("54/2 " + String.valueOf(integerDivide(54, 2) == 27));
        out.println("51/13 " + String.valueOf(integerDivide(51, 13) == 3));
        out.println("51/0 " + String.valueOf(integerDivide(51, 0) == -1));
    }
}