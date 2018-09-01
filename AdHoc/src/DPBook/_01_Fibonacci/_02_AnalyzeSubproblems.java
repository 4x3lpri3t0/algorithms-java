package DPBook._01_Fibonacci;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _02_AnalyzeSubproblems {
    // Compute the nth fibonacci number recursively.
    // Optimized by caching subproblem results.
    static int fib(int n) {
        if (n < 2)
            return n;

        // Create cache and initialize to -1
        int[] cache = new int[n + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }

        // Fill initial values in cache
        cache[0] = 0;
        cache[1] = 1;

        return fib(n, cache);
    }

    // Overloaded private method
    private static int fib(int n, int[] cache) {
        // If value is set in cache, return
        if (cache[n] >= 0)
            return cache[n];

        // Compute and add to cache before returning
        cache[n] = fib(n - 1, cache) + fib(n - 2, cache);

        return cache[n];
    }

    public static void main(String[] args) {
        out.println(fib(0)); // 0
        out.println(fib(1)); // 1
        out.println(fib(5)); // 5
        out.println(fib(10)); // 55
    }
}
