package Math;

import java.math.BigDecimal;

import static java.lang.System.out;

// A naive solution for this problem: multiply 'x' by 'n' times.
// The TC of this algorithm would be O(n).
// We can use divide and conquer approach to solving this problem more efficiently.

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/170001

// TC: Logarithmic, O(log n).
// MC: Logarithmic, O(log n).
public class PowerOfANumber {
    static double powerRec(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double temp = powerRec(x, n / 2);
        if (n % 2 == 0) { // Even pow
            return temp * temp;
        } else {
            return x * temp * temp; // Odd pow -> Add extra x
        }
    }

    static double power(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }

        double result = powerRec(x, n);

        if (isNegative) {
            return 1 / result;
        }

        return result;
    }

    public static void main(String[] args) {
        int pass_count = 0, fail_count = 0;
        for (double n = -10.9876; n <= 5.987; n = round(n + 0.1)) {
            for (int k = -4; k <= 6; ++k) {
                double r1 = round(power(round(n), k));
                double r2 = round(Math.pow(round(n), k));
                double diff = r1 - r2;
                if (diff < 0) {
                    diff = diff * -1;
                }
                if (diff > 0.0000000001) {
                    String msg = String.format("r1 = %f, r2 = %f, difference = %f", r1, r2, diff);
                    out.println("Failed for (" + n + ", " + k + ") " + msg);
                    fail_count++;
                } else {
                    pass_count++;
                }

                out.println(diff <= 0.0000000001);
            }
        }

        out.printf("Passed Count: %d, Fail Count: %d\n", pass_count, fail_count);
    }

    private static double round(double value) {
        return round(value, 6);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}