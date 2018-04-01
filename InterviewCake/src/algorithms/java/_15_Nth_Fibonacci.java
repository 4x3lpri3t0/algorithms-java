import java.util.HashMap;

class _15_Nth_Fibonacci {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    // Recursive
    public static int fib(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }
    // O(n) time
    // O(n) space

    // Iterative (Bottom-up)
    public static int fb(int n) {
        if (n == 0 || n == 1)
            return n;

        int prevPrev = 0;  // 0th fibonacci
        int prev = 1;      // 1st fibonacci
        int current = 0;

        for (int i = 1; i < n; i++) {
            // Iteration 1: current = 2nd fibonacci
            // Iteration 2: current = 3rd fibonacci
            // Iteration 3: current = 4th fibonacci
            // To get nth fibonacci ... do n-1 iterations
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }
    // O(n) time
    // O(1) space
}