package Math;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/130002
public class CalculateSquareRoot {
    private static final double EPSILON = 0.00001;

    public static double squareRootIterative(double num) {
        double low = 0;

        // Square root can never be more than
        // half of number except if number is <= 1
        // so square root of any number always lie
        // between 0 and 1 + (num / 2)
        double high = 1 + num / 2;

        while (low < high) {
            double mid = (low + high) / 2;
            double sqr = mid * mid;

            // We can't do a == b for doubles because
            // of rounding errors, so we use error threshold EPSILON.
            // Two doubles a and b are equal if abs(a-b) <= EPSILON

            double diff = Math.abs(num - sqr);

            if (diff <= EPSILON) {
                return mid;
            }

            if (sqr < num) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return -1;
    }

    private static void test(double x) {
        double res1 = squareRootIterative(x);
        double res2 = Math.sqrt(x);

        double diff = Math.abs(res1 - res2);
        // System.out.println(diff <= EPSILON * 10);
    }

    public static void main(String[] args) {
        double count = 0;
        for (double i = 0.01; i < 10000; i += 0.01) {
            test(i);
            ++count;
        }
        System.out.println("Completed Count = " + count);
    }
}