package DPBook._01_Fibonacci;

import static java.lang.System.out;

public class _01_First {
    // Compute the nth Fibonacci Number
    // We assume that n >= 0 and that int is
    // sufficient to hold the result
    static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        out.println(fib(0)); // 0
        out.println(fib(1)); // 1
        out.println(fib(5)); // 5
        out.println(fib(10)); // 55
    }
}
