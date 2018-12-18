package DPBook._01_Fibonacci;

import static java.lang.System.*;

public class _03_Turn {
    // Compute the n th Fibonacci number iteratively
    static int fib(int n) {
        if (n == 0)
            return 0;

        // Initialize cache
        int[] cache = new int[n + 1];
        cache[1] = 1;

        // Fill cache iteratively
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

    public static void main(String[] args) {
        out.println(fib(0)); // 0
        out.println(fib(1)); // 1
        out.println(fib(5)); // 5
        out.println(fib(10)); // 55
    }
}
